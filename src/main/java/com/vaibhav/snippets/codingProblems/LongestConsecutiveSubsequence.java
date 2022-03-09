package com.vaibhav.snippets.codingProblems;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        //int[] test = {1, 9, 3, 10, 4, 20, 2}; // expect 4 (1,3,4,2)
        int[] test =  {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42};// expect 5 (36,35,33,34,32)
        System.out.println(lis(test));
    }

    // add all elements to a set
    // for each element v in arr check if v-1 exist to confirm if its starting value of sequence if not then
    // start from that element and count consecutive elements after that
    private static int lis(int[] arr) {
        Set<Integer> elements = new HashSet<>();
        for(int i = 0 ; i < arr.length ; i++) elements.add(arr[i]);// add all elements to set

        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length ; i++) {
            int consequtiveElementsLength = 0;
            int currentElement = arr[i];
            if (!elements.contains(currentElement-1)) {
                while(elements.contains(currentElement++)) {consequtiveElementsLength++;}

                if (consequtiveElementsLength > max) {
                    max = consequtiveElementsLength;
                }
            }
        }
        return max;
    }


}
