package com.vaibhav.snippets.core_java;

import java.util.function.Predicate;

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

    }
}
