package com.vaibhav.snippets.multithreading.future_api;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceImpl {
    public static void main(String[] args) {
        ExecutorService e = Executors.newFixedThreadPool(2);
        Runnable task1 = () -> {
            System.out.print("Thread running : "+Thread.currentThread().getName());
            System.out.println(" : task1 started");
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e13) {
                e13.printStackTrace();
            }
            System.out.println("task1 ended");
        };
        Runnable task2 = () -> {
            System.out.print("Thread running : "+Thread.currentThread().getName());
            System.out.println(" : task2 started");
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e12) {
                e12.printStackTrace();
            }
            System.out.println("task2 ended");
        };
        Runnable task3 = () -> {
            System.out.print("Thread running : "+Thread.currentThread().getName());
            System.out.println(" : task3 started");
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            System.out.println("task3 ended");
        };

        e.submit(task1);
        e.submit(task2);
        e.submit(task3);
        e.shutdown();

    }
}
