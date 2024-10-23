package com.vaibhav.snippets.codingProblems.SearchingSorting.binary_search;

public class SearchInRotatedSortedArray {

    /**
     * There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
     *
     * Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
     *
     * Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
     *
     * You must decrease the overall operation steps as much as possible.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,5,6,0,0,1,2], target = 0
     * Output: true
     * Example 2:
     *
     * Input: nums = [2,5,6,0,0,1,2], target = 3
     * Output: false
     */

    public static void main(String[] args) {
        int[] test1 = new int[]{2,5,6,0,0,1,2};
        int[] test2 = new int[]{2,5,6,0,0,1,2};
        System.out.println(search(test1, 0));
        System.out.println(search(test2, 3));
    }


    public static boolean search(int[] nums, int target) {
        int pivot = findRotationPoint(nums);
        return bSearchInPivotedArray(nums, pivot,  0, nums.length-1, target);
    }

    public static int findRotationPoint(int[] nums) {
        for(int i = 0 ; i < nums.length -1 ; i++) {
            if(nums[i] > nums[i+1]) {
                return i+1;
            }
        }
        return 0;
    }

    public static boolean bSearchInPivotedArray(int[] nums, int pivot, int start , int end , int target) {
        int mid;

        while(start <= end ) {
            mid = start + ( end - start ) / 2 ;
            int pivotIndex = ( mid + pivot ) % nums.length;

            if (nums[pivotIndex] == target) {
                return true;
            } else if (nums[pivotIndex] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
