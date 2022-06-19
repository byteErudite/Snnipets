package com.vaibhav.snippets.core_java;

import java.sql.Wrapper;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FunctionalInterfaceImpl {

    @FunctionalInterface
    interface Flying {
        void fly();
        default void fly2() {

        }
    }

    static Predicate<Integer> isPrime = num -> {
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

    static Predicate<Integer> isOdd = num ->  num % 2 != 0;

    static Flying mallardFlying = () -> {
        System.out.println("the mallard duck is flying");
    };

    @FunctionalInterface
    interface Operation {
        int of(int value);
    }

    public static void main(String[] args) {
        List<String> newList = new ArrayList<>();
        newList.add("test");
        List<Integer> te = newList.stream().filter(s-> s.length() > 10).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(te.isEmpty());

        FunctionalInterfaceImpl t = new FunctionalInterfaceImpl();
        mallardFlying.fly();
        System.out.println(isPrime.and(t.isOdd).test(17));
        isPrime.and(isOdd).negate().test(17);
        isPrime.or(isOdd).test(17);


        Operation square = (int val) -> val*val;
        int  val = 5;
        System.out.println("The sqaure of "+val+" is : "+square.of(5));


        Function< String, Integer > retrieveLen = (str) -> str.length();
        System.out.println(retrieveLen.apply("Ramesh"));

        //-------------------------------------------------------------------------------------------------------------
        Predicate < Integer > isOdd = (num) -> num % 2 != 0;
        System.out.println(isOdd.test(10));
        //------------------------------------------------------------------------------------------------------------



        //------------------------------------------------------------------------------------------------------------
        /*
        A Consumer is a functional interface in JDK 8, which represents an operation that accepts a single input argument and returns no result.
         */
        Consumer< String > consumer = (str) -> System.out.println(str);
        consumer.accept("Ramesh");
        //------------------------------------------------------------------------------------------------------------




        //------------------------------------------------------------------------------------------------------------
        /*
        The Supplier is a functional interface that represents an operation that takes no argument and returns a result.
         */
        Supplier<LocalDateTime> localDateTime = () -> LocalDateTime.now();
        System.out.println(localDateTime.get());
        //------------------------------------------------------------------------------------------------------------





        //------------------------------------------------------------------------------------------------------------
        /*
        The BiFunction interface is a functional interface that represents a function that takes two arguments of different types and produces a result of another type.

         */
        BiFunction< Integer, Integer, Integer > addition = (num1, num2) -> (num1 + num2);
        System.out.println(addition.apply(200, 100));
        //------------------------------------------------------------------------------------------------------------

        BiConsumer<String,String> namePrinter = ( firstName, lastName) -> System.out.println("The full name is : "+firstName+" "+lastName);
        namePrinter.accept("vaibhav" , "singh");



    }
}
