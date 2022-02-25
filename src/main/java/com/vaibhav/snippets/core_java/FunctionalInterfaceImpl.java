package com.vaibhav.snippets.core_java;

import java.time.LocalDateTime;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceImpl {

    @FunctionalInterface
    interface Flying {
        void fly();
        default void fly2() {

        }
    }

    Predicate<Integer> isPrime = num -> {
        if (num == 1) {
            return false;
        }
        int iterator = (int) Math.sqrt(num);
        while(iterator > 1) {
            if (num % iterator == 0) return false;
            iterator--;
        }
        return true;
    };

    Predicate<Integer> isOdd = num ->  num % 2 != 0;

    Flying mallardFlying = () -> {
        System.out.println("the mallard duck is flying");
    };


    public static void main(String[] args) {
        FunctionalInterfaceImpl t = new FunctionalInterfaceImpl();
        t.mallardFlying.fly();
        System.out.println(t.isPrime.and(t.isOdd).test(17));
        t.isPrime.and(t.isOdd).negate().test(17);
        t.isPrime.or(t.isOdd).test(17);

        Function< String, Integer > retrieveLen = (str) -> str.length();
        System.out.println(retrieveLen.apply("Ramesh"));


        Predicate < Integer > isOdd = (val) -> val % 2 != 0;
        System.out.println(isOdd.test(10));

        /*
        A Consumer is a functional interface in JDK 8, which represents an operation that accepts a single input argument and returns no result.
         */
        Consumer< String > consumer = (str) -> System.out.println(str);
        consumer.accept("Ramesh");

        /*
        The Supplier is a functional interface that represents an operation that takes no argument and returns a result.
         */
        Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();
        System.out.println(supplier.get());

        /*
        The BiFunction interface is a functional interface that represents a function that takes two arguments of different types and produces a result of another type.

         */
        BiFunction< Integer, Integer, Integer > addition = (num1, num2) -> (num1 + num2);
        System.out.println(addition.apply(200, 100));

    }
}
