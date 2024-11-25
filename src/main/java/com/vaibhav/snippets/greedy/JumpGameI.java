package com.vaibhav.snippets.greedy;

public class JumpGameI {
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
     */

    public static void main(String[] args) {

    }

    public boolean canJump(int[] nums) {
        if(nums.length == 1) {
            return true;
        }
        int max_reach = 0;
        for(int i = 0 ; i <nums.length ; i++) {
            if (i > max_reach) {
                return false;
            }
            if (i + nums[i] > max_reach ) {
                max_reach = i + nums[i];
            }

        }
        return true;
    }

    public boolean canJumpDp(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];

        canJump(nums, 0, dp);
        return dp[nums.length-1] == null ? false : dp[nums.length-1];
    }

    public boolean canJump(int[] nums, int ind, Boolean[] dp) {
        if(ind >= nums.length) {
            return false;
        }

        if(ind == nums.length -1) {
            dp[ind] = true;
            return true;
        }

        if(nums[ind] == 0) {
            return false;
        }


        if(dp[ind] != null) {
            return dp[ind];
        }

        boolean isJumpPossible = false;
        for(int i = 1 ; i<= nums[ind] ; i++) {
            if (ind + i < nums.length && dp[ind+i] == null) {
                dp[ind + i] = canJump(nums, ind +i, dp);
                if(dp[ind + i]) {
                    return true;
                }
            }
            isJumpPossible = isJumpPossible || dp[ind + i];
        }
        return isJumpPossible;
    }
}
