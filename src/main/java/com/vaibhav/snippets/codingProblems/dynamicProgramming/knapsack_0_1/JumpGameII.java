package com.vaibhav.snippets.codingProblems.dynamicProgramming.knapsack_0_1;

public class JumpGameII {

    /**
     * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
     *
     * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
     *
     * 0 <= j <= nums[i] and
     * i + j < n
     * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,3,1,1,4]
     * Output: 2
     * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * Example 2:
     *
     * Input: nums = [2,3,0,1,4]
     * Output: 2
     *
     */

    public static void main(String[] args) {
        int[] nums1 = {1,2,1,1,1};
        int[] nums2 = {1,5,11,1,1,1,1,1,1,4};
        System.out.println("TEST CASE 1 : "+jumpMy(nums1));
        //System.out.println("TEST CASE 2 : "+jump(nums2));

    }

    public static int jump(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int maxReach = 0, steps = 0, end = 0;
        for (int i = 0; i < n - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (i == end) {
                end = maxReach;
                steps++;
            }
        }
        return steps;
    }
    public static int jumpMy(int[] nums) {
        int[] dp = new int[nums.length+1];
        for(int i =0; i < nums.length +1 ; i++) {
            dp[i] = -1;
        }
        return jumpMy(nums, 0,0, dp);

    }

    public static int jumpMy(int[] nums, int currPos, int jumpCount, int[] dp) {
        if (currPos >= nums.length-1) {
            return 0;
        }

        if(dp[currPos] != -1) {
            return dp[currPos];
        }
        int minimumJumps = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[currPos] ; i++) {
            minimumJumps = Math.min(jumpMy(nums, currPos + i,jumpCount + 1, dp) + 1 , minimumJumps);
        }
        dp[currPos] = minimumJumps == Integer.MAX_VALUE ? 10000 : minimumJumps;
        return dp[currPos];
    }

}
