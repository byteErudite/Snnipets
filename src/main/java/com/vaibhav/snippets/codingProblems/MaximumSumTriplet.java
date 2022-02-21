package com.vaibhav.snippets.codingProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumSumTriplet {
    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(18468, 6335, 26501, 19170, 15725, 11479, 29359, 26963, 24465, 5706, 28146, 23282, 16828, 9962, 492, 2996, 11943, 4828, 5437, 32392, 14605);
        System.out.println(solve(A));
    }
    public static int solve(List<Integer> A) {
        Map<Integer, Integer> v = new HashMap<>();
        int[] maxInRight = new int[A.size()];
        maxInRight[A.size()-1] = A.get(A.size()-1);
        //for each index store maxValueInRight side of it
        for(int i = A.size()-2; i >=0 ; i--) {
            if(A.get(i) > maxInRight[i+1]) {
                maxInRight[i] = A.get(i);
            } else {
                maxInRight[i] = maxInRight[i+1];
            }
        }
        int maxSum = Integer.MIN_VALUE;
        int sum=0;
        //for each possible pair where value at j index is greater than value at index i, find max in j's right and all three
        for(int i = 0; i < A.size()-2 ; i++) {
            for(int j = i+1; j < A.size()-1 ; j++) {
                if(A.get(i) < A.get(j) && maxInRight[j+1] > A.get(i) && maxInRight[j+1] > A.get(j)) {
                    sum = A.get(i) + A.get(j) + maxInRight[j+1];
                    if (sum > maxSum) {
                        maxSum = sum;
                    }
                }
            }
        }
        return maxSum;
    }
}
