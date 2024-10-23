package com.vaibhav.snippets.codingProblems;

public class FirstMissingPositive {
    /**
     * Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
     *
     * You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,0]
     * Output: 3
     * Explanation: The numbers in the range [1,2] are all in the array.
     * Example 2:
     *
     * Input: nums = [3,4,-1,1]
     * Output: 2
     * Explanation: 1 is in the array but 2 is missing.
     * Example 3:
     *
     * Input: nums = [7,8,9,11,12]
     * Output: 1
     * Explanation: The smallest positive integer 1 is missing.
     *
     * Constraints:
     *
     * 1 <= nums.length <= 105
     * -231 <= nums[i] <= 231 - 1
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 1) {
            if(nums[0] == 1) {
                return 2;
            }
            return 1;
        }
        for(int i = 0 ; i<nums.length ; i++) {
            if(nums[i] == 0) {
                nums[i] = -1;
            }
        }
        int travelIndex = 0;
        while(travelIndex < nums.length) {
            if (nums[travelIndex] > 0 ) {
                traverse2(nums, travelIndex, false);
            }
            travelIndex++;
        }

        for(int i =0 ; i< nums.length ; i++) {
            if (nums[i] != 0) {
                return i+1;
            }
        }
        return nums.length+1;
    }

    public void traverse2(int[] nums, int ind, boolean flag) {
        if(ind < 0 || ind >= nums.length || nums[ind] == 0) {
            return;
        }
        int nextJump = nums[ind] -1;
        if(flag) {
            nums[ind] = 0;
        }
        flag = true;
        traverse2(nums, nextJump, flag);

    }


    public int firstMissingPositiveLeetcodeSol(int[] nums) {
        int n = 0;
        while (n < nums.length) {
            if (n + 1 == nums[n] || nums[n] > nums.length || nums[n] < 1 || nums[n] == nums[nums[n] - 1]) {
                n++;
            } else {
                swap(nums, n, nums[n] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return nums.length + 1;
    }

    static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
