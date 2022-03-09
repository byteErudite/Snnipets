package com.vaibhav.snippets.codingProblems;

import java.util.Arrays;

public class ArrayProductWithoutDividing {

    /*
    Given an array arr[] of n integers, construct a Product Array prod[] (of same size) such that prod[i] is equal
     to the product of all the elements of arr[] except arr[i]. Solve it without division operator in O(n) time.
     */
    public static void main(String[] args) {
        int[] input = {10, 3, 5, 6, 2};
        Arrays.stream(getProductArray(input)).forEach(System.out::println);
    }

    // store left product from start up till ith index at ith index in left array and
    // product from end up till i+1 in right array at ith index
    // for product multiply right and left values
    // Time complexity O(n) and space complexity O(n)
    static int[] getProductArray(int arr[])
    {
        int n = arr.length;
        if (n == 1) {
            arr[0] = 0;
            return arr;
        }

        int left[] = new int[n];
        int right[] = new int[n];
        int prod[] = new int[n];

        int i, j;
        left[0] = 1;
        right[n - 1] = 1;

        for (i = 1; i < n; i++)
            left[i] = arr[i - 1] * left[i - 1];

        for (j = n - 2; j >= 0; j--)
            right[j] = arr[j + 1] * right[j + 1];

        for (i = 0; i < n; i++)
            prod[i] = left[i] * right[i];

        return prod;
    }
}
