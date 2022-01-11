package com.vaibhav.snippets.multithreading.future_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureApiImpl {
    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {

    }

    private void callAPI() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FutureTask<String> future =
                new FutureTask<String>(new Callable<String>() {
                    public String call() {
                        return null;
                    }});
        executorService.execute(future);
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
            final String CAT_SERVICE_URL = "";
            ResponseEntity<FactModel> response = restTemplate.getForEntity(CAT_SERVICE_URL , FactModel.class);
            if (response.getStatusCode().equals(HttpStatus.OK)) {
                return response.getBody().getFact();
            }
            return null;
    }
}
