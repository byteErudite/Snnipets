package com.vaibhav.snippets.data_structures;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTraversal {
    public static void main(String[] args)
    {
        HashMap<String, Integer> nameByAge = new HashMap<>();
        nameByAge.put("Vaibhav", 25);
        nameByAge.put("Amit", 26);

        System.out.println("MAP : " + nameByAge);

        traverseUsingIterator(nameByAge);
        traverseUsingForLoop(nameByAge);

        nameByAge.forEach((k, v) -> System.out.println(k + " : " + (v)));
    }

    //using iterator
    private static <X,Y> void traverseUsingIterator(HashMap<X, Y> map) {
        Iterator hmIterator = map.entrySet().iterator();
        while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)hmIterator.next();
            Y value = ((Y)mapElement.getValue());

            System.out.println(mapElement.getKey() + " : "
                    + value);
        }
    }

    private static <X,Y> void traverseUsingForLoop(HashMap<X, Y> map) {
        for (Map.Entry mapElement : map.entrySet()) {
            X key = (X)mapElement.getKey();
            Y value = ((Y)mapElement.getValue());
            System.out.println(key + " : " + value);
        }
    }
}
