package com.vaibhav.snippets.codingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArrayWithGivenOddNumbers {
    /*
    Problem Description

Given an array of integers A and an integer B.

Find the total number of subarrays having exactly B odd numbers.



Problem Constraints
1 <= length of the array <= 105

1 <= A[i] <= 109

0 <= B <= A



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the total number of subarrays having exactly B odd numbers.



Example Input
Input 1:

 A = [4, 3, 2, 3, 4]
 B = 2
Input 2:

 A = [5, 6, 7, 8, 9]
 B = 3


Example Output
Output 1:

 4
Output 2:

 1


Example Explanation
Explanation 1:

 The subarrays having exactly B odd numbers are:
 [4, 3, 2, 3], [4, 3, 2, 3, 4], [3, 2, 3], [3, 2, 3, 4]
Explanation 2:

 The subarrays having exactly B odd numbers is [5, 6, 7, 8, 9]
     */

    /*
    keep the count of odd numbers at each index , traverse the array and put the oddCount value as key and
    keep incrementing the value when you find another a[i] for which oddCount is same.
    while traversing the array when we are at
    i index, all indices from 0 to i which have oddCount as (oddCountTilli - B) that is stored in
     the map , will be added to result.

     */
    public static void main(String[] args) {
        Integer[] arr = {4, 3, 2, 3, 4};
        //Integer[] arr = {68, 35};
        //System.out.println(solve(Arrays.asList(arr), 2));
        //System.out.println(solve(Arrays.asList(arr), 2));
        ArrayList<ArrayList<Integer>> test = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(2);
        row1.add(2);
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(3);
        row2.add(4);
        row2.add(4);
        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(3);
        row3.add(4);
        row3.add(4);
        test.add(row1);
        test.add(row2);
        test.add(row3);
        rotate(test);
        System.out.println(test);
    }
    public static int solve(List<Integer> A, int B) {
        int oddCount = 0;
        int totalSubarraysWithOddSum = 0;
        Map<Integer, Integer> numberOfArraysWithOddCount = new HashMap<>();
        for(int i = 0 ; i< A.size() ; i++) {
            if (A.get(i) % 2 != 0) {
                oddCount++;
            }
            numberOfArraysWithOddCount.put(oddCount, numberOfArraysWithOddCount.getOrDefault(oddCount, 0));
            totalSubarraysWithOddSum += numberOfArraysWithOddCount.getOrDefault(oddCount - B, 0);
        }
        return totalSubarraysWithOddSum;
    }

    public static void rotate(ArrayList<ArrayList<Integer>> a) {
        int l = a.get(0).size();
        int[][] copy = new int[l][l];
        for(int i = 0; i< l; i++) {
            for(int j = 0; j< l; j++) {
                copy[i][l-j-1] = a.get(i).get(j);
            }
        }
        a.clear();
        for(int i = 0; i< l; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for(int j = 0; j< l; j++) {
                row.add(copy[i][j]);
            }
            a.add(row);
        }
    }
}
