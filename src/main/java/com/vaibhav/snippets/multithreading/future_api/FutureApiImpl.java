package com.vaibhav.snippets.multithreading.future_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureApiImpl {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureApiImpl instance = new FutureApiImpl();
        instance.callAPI();
    }

    private void callAPI() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FutureTask<String> future =
                new FutureTask<String>(() -> call());
        System.out.println("before executing future");
        executorService.execute(future);
        System.out.println(future.get());
        System.out.println("After executing future");
    }

    private String call() {


//        Movie movie = builder.build().
//                get().
//                uri(MOVIE_SERVICE_URL + movieId).
//                retrieve().
//                bodyToMono(Movie.class).block();
//
//        Rating rating = builder.build().
//                get().
//                uri(RATING_SERVICE_URL + movieId).
//                retrieve().
//                bodyToMono(Rating.class).block();
//        return new ResponseEntity<>(Arrays.asList(new MovieData(movie, rating)), HttpStatus.OK);
        final String CAT_SERVICE_URL = "https://catfact.ninja/fact";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<FactModel> response = restTemplate.getForEntity(CAT_SERVICE_URL, FactModel.class);
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            return response.getBody().getFact();
        } else {
            return "No response available";
        }
    }
}
