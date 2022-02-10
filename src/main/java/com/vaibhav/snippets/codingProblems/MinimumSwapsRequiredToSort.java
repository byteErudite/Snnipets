package com.vaibhav.snippets.codingProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumSwapsRequiredToSort {
    public static void main(String[] args) {
        int []a = {1, 5, 4, 3, 2};

        System.out.println(minimumSwapsRequired(a));
    }

    private static int minimumSwapsRequired(int[] arr) {
        int[] originalArray = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);
        int traverseIndex = 0;
        int minSwapCount = 0;
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for(int i =0; i< originalArray.length ; i++) {
            valueToIndex.put(originalArray[i], i);
        }
        while(traverseIndex < arr.length) {
            if (originalArray[traverseIndex] != arr[traverseIndex]) {
                swap(traverseIndex, valueToIndex.get(arr[traverseIndex]), originalArray);
                minSwapCount++;
            }
            traverseIndex++;
        }
        return minSwapCount;
    }

    private static void swap(int index1, int index2, int arr[]) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
