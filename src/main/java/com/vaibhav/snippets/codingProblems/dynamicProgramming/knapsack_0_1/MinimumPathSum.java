package com.vaibhav.snippets.codingProblems.dynamicProgramming.knapsack_0_1;

public class MinimumPathSum {

    /**
     * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
     *
     * Note: You can only move either down or right at any point in time.
     *
     *
     */

    public static void main(String[] args) {
        int[][] nums1 = {{1,2,3}, {4,5,6}};
        //int[][] nums2 = {{1,5,11,1,1,1,1,1,1,4}};
        System.out.println(minPathSum(nums1));
    }
    public static int minPathSum(int[][] grid) {
        int n = grid.length;
        int [][] dp = new int[n+1][n+1];
        for(int i =0; i<= n ; i++) {
            for (int j =0; j<= n ;j ++) {
                dp[i][j] = -1;
            }
        }
        return minPathSum(grid, 0,0,0, dp);
    }

    public static int minPathSum(int[][] grid, int x, int y, int currSum, int[][] dp) {
        if (x >= grid.length || y >= grid[0].length ) {
            return Integer.MAX_VALUE;
        }

        int sum = currSum + grid[x][y];

        if (x == grid.length -1 && y == grid[0].length -1) {
            dp[x][y] = sum;
            return dp[x][y];
        }

        if (dp[x][y] == -1) {
            dp[x][y] = Math.min(minPathSum(grid, x+1, y, sum, dp), minPathSum(grid, x, y+1, sum, dp));

        } else {
            dp[x][y] = Math.min(dp[x][y], Math.min(minPathSum(grid, x+1, y, sum, dp), minPathSum(grid, x, y+1, sum, dp)));
        }
        return dp[x][y];

    }
}
