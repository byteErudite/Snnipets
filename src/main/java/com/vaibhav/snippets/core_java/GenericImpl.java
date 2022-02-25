package com.vaibhav.snippets.core_java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GenericImpl {
    public static <T> T get(T t) {
        return t;
    }


    public static void main(String[] args) {
        Farm farm = new Farm();
        List<Cat> cats = new ArrayList<>();
        List<Dog> dogs = new ArrayList<>();
        farm.addAnimals(cats);
        farm.addAnimals(dogs);
    }

    Set<Integer> values = new HashSet<>();
    Map<Integer,Integer> map = new LinkedHashMap<>();


}

class Farm {
    private List<Animal> animals;

//    public void addAnimals(Collection<Animal> newAnimals) {
//        animals.addAll(newAnimals);
//    }
    public void addAnimals(Collection<? extends Animal> newAnimals) {
        animals.addAll(newAnimals);
    }
}

interface Animal {

}

class Cat implements Animal {

}

class Dog implements Animal{

}


