package com.vaibhav.snippets.codingProblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiffExists {

    /*
    Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

Example :

Input :

A : [1 5 3]
k : 2
Output :

1
as 3 - 1 = 2

Return 0 / 1 for this problem.
     */
    public static int diffPossible(final List<Integer> A, int B) {
        if (A.size() == 0 || A.size() == 1) {
            return 0;
        }
        Set<Integer> values = new HashSet<>();
        for (int a : A) {
            if (B == 0 && !values.add(a)) {
                return 1;
            }
            values.add(a);
        }
        if (B == 0) {
            return 0;
        }
        for (int i = 0; i < A.size(); i++) {
            if (values.contains(A.get(i) - B)) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Integer[] arr = {51, 34, 63, 64, 38,
                65, 83, 50, 44, 18, 34, 71, 80, 22, 28, 20, 96, 33, 70, 0, 25, 64, 96, 18, 2, 53, 100, 24, 47, 98, 69,
                60, 55, 8, 38, 72, 94, 18, 68, 0, 53, 18, 30, 86, 55, 13, 93, 15, 43, 73, 68, 29};
        System.out.println(diffPossible(Arrays.asList(arr), 97)); // expect 0
    }
}
