package com.vaibhav.snippets.codingProblems.dynamicProgramming.knapsack_0_1;

public class MinimumJump {

    /*
    Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.
     */

    public int jump(int[] nums) {
        int[] dp = new int[nums.length+1];
        for(int i = 0 ; i < dp.length ; i++)  {
            dp[i] = -1;
        }
        return minJump(nums, 0, 0,dp);
    }

    private int minJump(int[] nums, int jump, int currentIndex, int[] dp) {
        if (currentIndex >= nums.length-1) {
            return jump;
        }

        if (dp[currentIndex] != -1) {
            return dp[currentIndex];
        }
        int nextJump = nums[currentIndex];
        int min = Integer.MAX_VALUE;
        for(int j = 1 ; j<= nextJump ; j++) {
            min = Math.min(min, minJump(nums, jump+1, currentIndex + j, dp));
        }
        dp[currentIndex]= min;
        return min;
    }
}
