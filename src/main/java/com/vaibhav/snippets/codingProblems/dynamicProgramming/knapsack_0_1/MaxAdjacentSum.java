package com.vaibhav.snippets.codingProblems.dynamicProgramming.knapsack_0_1;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxAdjacentSum {

    /**
     * You are given an array/list of ‘N’ integers. You are supposed to return the maximum sum of the
     * subsequence with the constraint that no two elements are adjacent in the given array/list.
     *
     * Note:
     * A subsequence of an array/list is obtained by deleting some number of elements (can be zero)
     * from the array/list, leaving the remaining elements in their original order.
     */

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int sum = 0;

        int[] dp = new int[nums.size()+1];
        Arrays.fill(dp, -1);
        return maxAdj2(nums, dp);
    }

    public static int maxAdj(ArrayList<Integer> nums, int ind, int[] dp) {
        if (ind == 0) {
            return nums.get(0);
        }

        if(ind < 0) {
            return 0;
        }

        if(dp[ind] != -1) {
            return dp[ind];
        }

        int includedSum = nums.get(ind) + maxAdj(nums, ind - 2, dp);
        int notIncludedSum = maxAdj(nums, ind - 1, dp);

        dp[ind] = Math.max(includedSum, notIncludedSum);
        return dp[ind];
    }


    public static int maxAdj2(ArrayList<Integer> nums, int[] dp) {
        if(nums.size() == 1) {
            return nums.get(0);
        }

        if (nums.size() == 2) {
            return Math.max(nums.get(0), nums.get(1));
        }

        dp[0] = nums.get(0);

        for(int i = 1; i < nums.size(); i++) {
            int take = nums.get(i);
            if(i > 1) take = take + dp[i-2];
            int notTake = dp[i-1];
            dp[i] = Math.max(take, notTake);
        }

        return dp[nums.size()-1];
    }
}
