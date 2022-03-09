package com.vaibhav.snippets.codingProblems;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationsOfString {

    public static void main(String[] args) {
        String testString = "ABC";
        List<String> permutations = new ArrayList<>();
        permute(testString.toCharArray(), 0, testString.length(), permutations);
        permutations.stream().forEach(System.out::println);
    }

    public static void permute(char[] input, int start, int end, List<String> sink) {
        for (int i = start; i <= end; ++i) {
            for (int j = i + 1; j < end; ++j) {
                swap(input, i, j);
                permute(input, i + 1, end, sink);
                swap(input, i, j);
            }
        }
        sink.add(String.valueOf(input));
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
