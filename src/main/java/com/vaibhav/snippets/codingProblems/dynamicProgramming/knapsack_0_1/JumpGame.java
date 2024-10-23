package com.vaibhav.snippets.codingProblems.dynamicProgramming.knapsack_0_1;

public class JumpGame {
    /**
     * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
     *
     * Return true if you can reach the last index, or false otherwise.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * Example 2:
     *
     * Input: nums = [3,2,1,0,4]
     * Output: false
     * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 104
     * 0 <= nums[i] <= 105
     */

    public static void main(String[] args) {
        int[] nums1 = {2,3,1,1,4};
        int[] nums2 = {3,2,1,0,4};
        System.out.println("TEST CASE 1 : "+(canJump(nums1) == true ? "PASS" : "FAIL"));
        System.out.println("TEST CASE 2 : "+(canJump(nums2) == false ? "PASS" : "FAIL"));

    }
    public static boolean canJump(int[] nums) {
        int i = 0;
        for (int reach = 0; i < nums.length && i <= reach; ++i)
            reach = Math.max(i + nums[i], reach);
        return i == nums.length;
    }
}
