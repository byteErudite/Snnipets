package com.vaibhav.snippets.multithreading.future_api;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureImpl2 {

    public static void main(String[] args) {
        for(int i =0; i< 3 ; i++) {
            int a=10;
            CompletableFuture.supplyAsync(() -> getOrderId())
                    .thenApply(orderId -> processOrder(orderId))
                    .thenApply(orderId -> completePayment(orderId))
                    .thenAccept(orderId -> sendNotification(orderId));
        }
    }

    public static String getOrderId() {
        String orderId = UUID.randomUUID().toString();
        System.out.println("order id generated:"+orderId);
        return orderId;
    }
    public static String processOrder(String orderId) {

        System.out.println("order processing with id :"+orderId);
//        timeout(5);
        return orderId;
    }

    public static String completePayment(String orderId) {

        System.out.println("payment processing with order id :"+orderId);
//        timeout(5);
        return orderId;
    }
    public static void sendNotification(String orderId) {

        System.out.println("Notification sent to user for orderId :"+orderId);
//        timeout(5);
    }

}

class Order {





    private static void timeout(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


