package com.vaibhav.snippets.codingProblems.dynamicProgramming.knapsack_0_1;

import java.util.Arrays;

public class NinjaTraining {

    /**
     * Problem statement
     * Ninja is planing this ‘N’ days-long training schedule. Each day, he can perform any one of these three activities. (Running, Fighting Practice or Learning New Moves). Each activity has some merit points on each day. As Ninja has to improve all his skills, he can’t do the same activity in two consecutive days. Can you help Ninja find out the maximum merit points Ninja can earn?
     *
     * You are given a 2D array of size N*3 ‘POINTS’ with the points corresponding to each day and activity. Your task is to calculate the maximum number of merit points that Ninja can earn.
     *
     * For Example
     * If the given ‘POINTS’ array is [[1,2,5], [3 ,1 ,1] ,[3,3,3] ],the answer will be 11 as 5 + 3 + 3.
     * Detailed explanation ( Input/output format, Notes, Images )
     * Constraints:
     * 1 <= T <= 10
     * 1 <= N <= 100000.
     * 1 <= values of POINTS arrays <= 100 .
     *
     * Time limit: 1 sec
     * Sample Input 1:
     * 2
     * 3
     * 1 2 5
     * 3 1 1
     * 3 3 3
     * 3
     * 10 40 70
     * 20 50 80
     * 30 60 90
     * Sample Output 1:
     * 11
     * 210
     * Explanation of sample input 1:
     * For the first test case,
     * One of the answers can be:
     * On the first day, Ninja will learn new moves and earn 5 merit points.
     * On the second day, Ninja will do running and earn 3 merit points.
     * On the third day, Ninja will do fighting and earn 3 merit points.
     * The total merit point is 11 which is the maximum.
     * Hence, the answer is 11.
     *
     * For the second test case:
     * One of the answers can be:
     * On the first day, Ninja will learn new moves and earn 70 merit points.
     * On the second day, Ninja will do fighting and earn 50 merit points.
     * On the third day, Ninja will learn new moves and earn 90 merit points.
     * The total merit point is 210 which is the maximum.
     * Hence, the answer is 210.
     * Sample Input 2:
     * 2
     * 3
     * 18 11 19
     * 4 13 7
     * 1 8 13
     * 2
     * 10 50 1
     * 5 100 11
     * Sample Output 2:
     * 45
     * 110
     */


    public static int ninjaTraining(int n, int points[][]) {
        int[][] dp = new int[n+1][4];
        for(int[] arr: dp) {
            Arrays.fill(arr,-1);
        }
        //return maxPoint(n-1, points, 3, dp);
        return maxPoint2(n-1, points);
    }

    public static int maxPoint(int n, int[][] points, int prev, int[][] dp) {

        if(n == 0) {
            int maxMerit = Integer.MIN_VALUE;
            for (int a =0 ; a < 3 ; a++) {
                if(a != prev) {
                    maxMerit = Math.max(maxMerit, points[0][a]);
                }
            }
            return maxMerit;
        }

        if(n != points.length && dp[n][prev] != -1) {
            return dp[n][prev];
        }

        int maxMerit = Integer.MIN_VALUE;
        for(int a = 0 ; a < 3 ; a++) {
            if (a != prev) {
                maxMerit = Math.max(maxMerit, points[n][a] + maxPoint(n-1, points, a, dp));
            }

        }
        return dp[n][prev] = maxMerit;
    }

    public static int maxPoint2(int n , int[][] points) {

        int maxMerit = Integer.MIN_VALUE;
        for (int a =0 ; a < 3 ; a++) {
            maxMerit = Math.max(maxMerit, points[0][a]);
        }

        if(n == 0) {
            return maxMerit;
        }

        int[][] dp = new int[n+1][3];

        for(int i = 0; i < 3 ; i++) {
            dp[0][i] = points[0][i];
        }

        for(int i = 1 ; i <= n ; i++) {
            for(int j = 0 ; j < 3; j++) {
                dp[i][j] = Integer.MIN_VALUE;
                for(int k = 0 ; k < 3 ; k++) {
                    if(k != j) {
                        dp[i][j] = Math.max(dp[i][j], points[i][j] + dp[i-1][k]);
                    }

                }
            }
        }

        return Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2]));


    }
}
