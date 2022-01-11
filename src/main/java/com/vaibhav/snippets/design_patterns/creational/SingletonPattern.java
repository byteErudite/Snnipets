package com.vaibhav.snippets.design_patterns.creational;

import java.util.Objects;

public class SingletonPattern {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton1.getInstanceAsked());
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton2.getInstanceAsked());
    }
}

class Singleton {
    private static long instanceAsked;
    private static Singleton instance;

    private Singleton() {
        instanceAsked = 1;
    }

    public long getInstanceAsked() {
        return instanceAsked;
    }

    public static Singleton getInstance() {
        instanceAsked++;
        if (Objects.isNull(instance)) {
            instance = new Singleton();
            return instance;
        }
        return instance;
    }
}
