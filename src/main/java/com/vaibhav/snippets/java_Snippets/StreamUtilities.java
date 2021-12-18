package com.vaibhav.snippets.java_Snippets;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUtilities {

    public static <TYPE extends Collection> Map<TYPE, Long> convertCollectionToFrequencyMap(TYPE collection) {

        return Stream.of(collection)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        /*
        ** To collect based on a specific field, this will not fail even if duplicates are present
        Map<Long, T> employeesMap = collection.stream()
                .collect(Collectors.toMap(T::getId,
                        Function.identity(), (first, second) -> first));

         */
    }


}
