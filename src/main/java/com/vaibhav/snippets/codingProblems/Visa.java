package com.vaibhav.snippets.codingProblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Visa {
    public static void main(String[] args) {
        String[] arr = {"P", "S", "N", "B"};
        Arrays.sort(arr);
        System.out.println(Arrays.binarySearch(arr, "N"));
    }

    static class Sorter implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
    }
}


