package com.vaibhav.snippets.codingProblems.dynamicProgramming.knapsack_0_1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SubsetSumVariation {

    /**
     * Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,5,11,5]
     * Output: true
     * Explanation: The array can be partitioned as [1, 5, 5] and [11].
     * Example 2:
     *
     * Input: nums = [1,2,3,5]
     * Output: false
     * Explanation: The array cannot be partitioned into equal sum subsets.
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 200
     * 1 <= nums[i] <= 100
     */

    public static void main(String[] args) {
        String s1 = "value1";
        String s2 = "value1";
        String s3 = new String("value1");
        String s4 = new String("value1");


        System.out.println(s1 == s2);
        System.out.println(s3 == s4);
        System.out.println(s1 == s3);

        int[] testCase1 = new int[]{1,5,11,5}; // expected output : true
        int[] testCase2 = new int[]{1,2,3,5}; // expected output : false
        Boolean result1 = canPartition(testCase1);
        Boolean result2 = canPartition(testCase2);
        System.out.println("Test case 1 : "+((result1.equals(true) ? "pass" : "fail")));
        System.out.println("Test case 1 : "+((result1.equals(true) ? "pass" : "fail")));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0 ;
        for(int i = 0 ; i< nums.length ;i++) {
            sum = sum + nums[i];
        }
        if(sum %2 != 0) return false;
        int target = sum / 2;
        Boolean[][] dp = new Boolean[target + 1][nums.length +  1];
        return isSumExists(nums, target,0, dp);
    }

    public static boolean isSumExists(int[] nums, int target, int currIndex, Boolean[][] dp) {
        if(target == 0) {
            return true;
        }
        if (target < 0 || currIndex > nums.length-1) {
            return false;
        }

        if(dp[target][currIndex] == null) {
            dp[target][currIndex] = isSumExists(nums, target-nums[currIndex], currIndex+1, dp) ||
                    isSumExists(nums, target, currIndex+1,dp);
        }
        return dp[target][currIndex];
    }
}
