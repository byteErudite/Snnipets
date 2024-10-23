package com.vaibhav.snippets.codingProblems;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        //int[] test = {1, 9, 3, 10, 4, 20, 2}; // expect 4 (1,3,4,2)
        int[] test =  {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42};// expect 5 (36,35,33,34,32)
        System.out.println(longestConsecutiveSubsequence(test));
    }

    // add all elements to a set
    // for each element v in arr check if v-1 exist to confirm if its starting value of sequence if not then
    // start from that element and count consecutive elements after that


    private static int longestConsecutiveSubsequence(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for(int num:nums) {
            numbers.add(num);
        }

        int maxLength = Integer.MIN_VALUE;

        for(int i = 0 ; i< nums.length ; i++) {
            if(!numbers.contains(nums[i]-1)) {

                int currElement = nums[i] + 1;
                int currLength = 1;

                while(numbers.contains(currElement)) {
                    currElement++;
                    currLength++;
                }

                if (currLength > maxLength) {
                    maxLength = currLength;
                }
            }
        }
        return maxLength;
    }


}
