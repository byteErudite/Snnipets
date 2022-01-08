package com.vaibhav.snippets.core_java;

public class FunctionalInterfaceImpl {

    @FunctionalInterface
    interface Flying {
        void fly();
        default void fly2() {

        }
    }



    public static void main(String[] args) {
        Flying mallardFlying = () -> {
            System.out.println("the mallard duck is flying");
        };
        mallardFlying.fly();
    }
}
