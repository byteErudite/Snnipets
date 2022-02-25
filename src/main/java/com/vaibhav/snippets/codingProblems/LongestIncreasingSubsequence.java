package com.vaibhav.snippets.codingProblems;

import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    /*
    A = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]

    Output 2:
    6

    The sequence : [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]
     */

    public static void main(String[] args) {
        //System.out.println(lis(Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15)));

        System.out.println(maxProfit(Arrays.asList(1,2)));
    }

    public static int maxProfit(final List<Integer> A) {
        if (A.size() == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int diffSum = 0;
        for(int i = 1 ; i <A.size() ; i++) {
            diffSum = diffSum + A.get(i) - A.get(i-1);
            if(max > diffSum) {
                max = diffSum;
            }
        }
        if(max < 0) {
            return 0;
        }
        return max;
    }

    public static int lis(final List<Integer> A) {

        int n = A.size();

        if(n == 0) return 0;

        int [] dp = new int[n];
        dp[0] = 1;
        int maxLen = 1;

        for(int i=1; i<n; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(A.get(i) > A.get(j)){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }
        return maxLen;

    }
}
