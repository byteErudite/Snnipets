package com.vaibhav.snippets.multithreading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableVsCallable {

    /*
    Since the early days of Java, multithreading has been a major aspect of the language. Runnable is the core interface provided
     for representing multi-threaded tasks and Callable is an improved version of Runnable that was added in Java 1.5.
    Both interfaces are designed to represent a task that can be executed by multiple threads. Runnable tasks can be run using the
     Thread class or ExecutorService whereas Callables can be run only using the latter.
     */

    /*
    The Runnable interface is a functional interface and has a single run() method which doesn't accept any parameters and does not
     return any values.
    public interface Runnable {
        public void run();
    }*/

    class EventLoggingTask implements  Runnable{
        private Logger logger
                = LoggerFactory.getLogger(EventLoggingTask.class);

        @Override
        public void run() {
            logger.info("Message");
        }
    }

    public void executeTask() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(new EventLoggingTask());
        executorService.shutdown();
    }
    /*In this case, the Future object will not hold any value.*/


    /*
    The Callable interface is a generic interface containing a single call() method – which returns a generic value V:

    public interface Callable<V> {
        V call() throws Exception;
    }
     */

    class FactorialTask implements Callable<Integer> {
        int number;

        public FactorialTask(int number) {
            this.number = number;
        }
        // standard constructors

        public Integer call() {
            System.out.println("task started running......");
            int fact = 1;
            for(int count = number; count > 1; count--) {
                fact = fact * count;
            }
            return fact;
        }
    }

    public int whenTaskSubmitted_ThenFutureResultObtained(int value){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FactorialTask task = new FactorialTask(value);
        Future<Integer> future = executorService.submit(task);
        try {
            return future.get().intValue();
        } catch (InterruptedException e) {
            return 0;
        } catch (ExecutionException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        RunnableVsCallable instance = new RunnableVsCallable();
        instance.executeTask();
        int factorial = instance.whenTaskSubmitted_ThenFutureResultObtained(5);
        System.out.println(factorial);
    }
}
