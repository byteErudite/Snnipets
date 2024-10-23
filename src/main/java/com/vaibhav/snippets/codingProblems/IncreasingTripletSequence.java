package com.vaibhav.snippets.codingProblems;

public class IncreasingTripletSequence {

    public static void main(String[] args) {
        int[] arr = {20,100,10,12,5,13};
        System.out.println(increasingTriplet(arr));
    }

    public static boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) {
            return false;
        }
        int count = 0;
        int i = 0;
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        while(i < nums.length-2) {

            if(nums[i] < nums[i+1]) {
                if(nums[i] > a && nums[i] > b) {
                    return true;
                }
                else if(nums[i] < a ) {
                    a = nums[i];
                    b = nums[i+1];
                    count = 2;
                } else {
                    count++;
                }
            }
            i++;

            if(count == 3) {
                return true;
            }
        }
        if((nums[i] > b && (nums[i+1] > b )) || ((nums[i] > a && nums[i+1]> a)) || (nums[i+1] > a && nums[i+1] > b)) {
            return true;
        }
        return false;
    }
}
