package com.vaibhav.snippets.multithreading.future_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureImpl {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        {
            try {
                List<Integer> list = Arrays.asList(5, 9, 14);
                list.stream().map(num -> CompletableFuture.supplyAsync(() -> getNumber(num)))
                        .map(CompletableFuture -> CompletableFuture.thenApply(n -> n * n)).map(t -> t.join()).forEach(s -> System.out.println(s));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        CompletableFutureImpl t = new CompletableFutureImpl();
        System.out.println("Before Api call");
        System.out.println(t.callFactApi());
        System.out.println("After Api call");

//        List<CompletableFuture<String>> allFutures = new ArrayList<>();
//        CompletableFuture<FactModel> future = new CompletableFuture<>();
//        CompletableFutureImpl t = new CompletableFutureImpl();
//        allFutures.add(CompletableFuture.supplyAsync(()-> t.callFactApi()));
//        CompletableFuture.allOf(allFutures.toArray(new CompletableFuture[0])).join();
//        System.out.println(allFutures.get(0).get());
//        System.out.println("hhhhhhh");


    }

    private static int getNumber(int a) {
        return a * a;
    }

    private String callFactApi() {
        try {
            final String CAT_SERVICE_URL = "https://catfact.ninja/fact";
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<FactModel> response = restTemplate.getForEntity(CAT_SERVICE_URL, FactModel.class);
            if (response.getStatusCode().equals(HttpStatus.OK)) {
                return response.getBody().getFact();
            }
            return "Failed to fetch API response";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Api call failed";
        }

    }
}
