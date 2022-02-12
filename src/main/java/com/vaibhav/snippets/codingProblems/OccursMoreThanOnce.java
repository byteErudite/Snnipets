package com.vaibhav.snippets.codingProblems;

public class OccursMoreThanOnce {

    /*
    Given an array where every element occurs three times, except one element which occurs only once.
     Find the element that occurs once. The expected time complexity is O(n) and O(1) extra space.
     */

    public static void main(String[] args) {
        int[] arr = {5,2,4,2,5,2,5};
        System.out.println("unique element ="+findOnceOccurringElement(arr) );
    }
    private static int findOnceOccurringElement(int[] B) {
        int ones =0,twos=0;
        int not_threes;
        for(int i=0; i< B.length; i++ )
        {
            int x =  B[i];
            twos |= ones & x ;
            ones ^= x ;
            not_threes = ~(ones & twos) ;
            ones &= not_threes ;
            twos &= not_threes ;
        }
        return ones;
    }
}
