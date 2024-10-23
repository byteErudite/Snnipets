package com.vaibhav.snippets.core_java;

import org.springframework.scheduling.annotation.Async;

public class TestAsynchronous {
    public static  void main(String[] args) throws InterruptedException {
        TAS t = new TAS();

            t.asyncPrinter(500000000);
            printer(50);
    }

    public static void printer(int i) {
        System.out.println("This method was called synchronously after async"+i);
    }

}

class TAS {
    @Async
    public void asyncPrinter(int t) throws InterruptedException {
        for(int i = 0 ; i<t ; i++) {
            Thread.sleep(5000);
        }
        System.out.println("ending aysncrosnous function");
    }


}
