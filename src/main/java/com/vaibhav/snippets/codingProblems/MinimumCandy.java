package com.vaibhav.snippets.codingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumCandy {
    /*
    There are N children standing in a line. Each child is assigned a rating value.
    You are giving candies to these children subjected to the following requirements:
    1. Each child must have at least one candy.
    2. Children with a higher rating get more candies than their neighbors.
    What is the minimum candies you must give?

    Input Format: The first and the only argument contains N integers in an array A.
    Output Format: Return an integer, representing the minimum candies to be given.

    Example:
    Input: [1, 2]           Output:3
    Input: [1, 5, 2, 1]     Output:7
     */

    public static void main(String[] args) {
        List<Integer> test1 = Arrays.asList(1, 2);
        List<Integer> test2 = Arrays.asList(1, 5, 2, 1);
        System.out.println(candy(test1));
        System.out.println(candy(test2));
    }
    public static int candy(List<Integer> A) {
        int n=A.size();
        int[] candies=new int[n];
        Arrays.fill(candies,1);
        for(int i=0;i<n-1;i++){
            if(A.get(i+1)>A.get(i))
                candies[i+1]=candies[i]+1;
        }
        for(int i=n-1;i>0;i--){
            if(A.get(i-1)>A.get(i) && candies[i-1]<=candies[i])
                candies[i-1]=candies[i]+1;
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=candies[i];
        }
        return sum;
    }
}
