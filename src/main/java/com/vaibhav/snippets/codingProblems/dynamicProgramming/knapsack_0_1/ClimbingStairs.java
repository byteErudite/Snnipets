package com.vaibhav.snippets.codingProblems.dynamicProgramming.knapsack_0_1;

import java.util.Arrays;

public class ClimbingStairs {
    /**
     * You are climbing a staircase. It takes n steps to reach the top.
     *
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     *
     *
     *
     * Example 1:
     *
     * Input: n = 2
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     * 1. 1 step + 1 step
     * 2. 2 steps
     * Example 2:
     *
     * Input: n = 3
     * Output: 3
     * Explanation: There are three ways to climb to the top.
     * 1. 1 step + 1 step + 1 step
     * 2. 1 step + 2 steps
     * 3. 2 steps + 1 step
     *
     *
     * Constraints:
     *
     * 1 <= n <= 45
     */

    public static void main(String[] args) {
        System.out.println(climbStairsIterative(3));
        System.out.println(climbStairs(3));
    }

    public static int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return climbStairs(n, dp);
    }

    static int climbStairs(int ind, int[] dp) {
        if (ind == 0) {
            return 1;
        }
        if (ind < 0) {
            return 0;
        }

        if(dp[ind] != -1) {
            return dp[ind];
        }
        return dp[ind] = climbStairs(ind-1, dp) + climbStairs(ind -2 ,dp);
    }

    static int climbStairsIterative(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n+1];
        dp[2] = 2;
        dp[1] = 1;
        for(int i = 3; i <= n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
