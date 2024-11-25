package com.vaibhav.snippets.greedy;

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
     * @param nums
     * @return
     */

    public int jump(int[] nums) {
        if(nums.length == 0 || nums.length == 1) {
            return 0;
        }

        int[] dp = new int[nums.length];
        //    Arrays.fill(dp, -1);
        //    return jump(nums, 0, dp);
        int max_reach = 0;
        int jump = 0;
        int left=0;
        int right=0;

        while(right < nums.length -1) {
            for(int i = left ; i <= right ; i++) {

                if (i + nums[i] > max_reach) {
                    max_reach = i + nums[i];

                }
                if (max_reach >= nums.length) {
                    return jump + 1;
                }
            }
            left = right +1;
            right = max_reach;
            jump++;
        }
        return jump;
    }

    public int jump(int[] nums, int ind, int[] dp) {
        if (ind >= nums.length-1) {
            return 0;
        }

        if (nums[ind] == 0) {
            return Integer.MAX_VALUE-10000;
        }

        if (dp[ind] != -1) {
            return dp[ind];
        }

        int minJump = Integer.MAX_VALUE-1000;
        for(int i = 1 ; i <= nums[ind] ; i++) {
            minJump = Math.min(minJump, 1 + jump(nums, ind+i, dp));
        }
        dp[ind] = minJump;
        return dp[ind];
    }

}
