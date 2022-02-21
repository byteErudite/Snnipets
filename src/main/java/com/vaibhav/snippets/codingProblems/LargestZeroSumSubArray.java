package com.vaibhav.snippets.codingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestZeroSumSubArray {
    /*
    Find the largest continuous sequence in a array which sums to zero.
    Example:
    Input:  {1 ,2 ,-2 ,4 ,-4}
    Output: {2 ,-2 ,4 ,-4}
     */
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(-14, -10, -1, 2, 12, -19, 27, -20, 0, 11);
        System.out.println(lszero(input));
    }

    public static List<Integer> lszero(List<Integer> A) {
        Map<Integer, Integer> sumToIndices = new HashMap<>();
        int sum = 0;
        int start = 0;
        int end = A.size()-1;
        int diff = Integer.MIN_VALUE;
        boolean found = false;
        sumToIndices.put(0, -1);
        for(int i = 0; i< A.size() ; i++) {
            sum = sum + A.get(i);
            if(sumToIndices.containsKey(sum)) {
                int prevInd = sumToIndices.get(sum);
                if(i-prevInd+1 > diff) {
                    diff = i - prevInd +1;
                    start = prevInd;
                    end = i;
                }
                found=true;
            } else {
                sumToIndices.put(sum, i);
            }
        }
        if(!found) {
            return new ArrayList<>();
        }
        return new ArrayList<>(A.subList(start+1, end+1));


    }
}
