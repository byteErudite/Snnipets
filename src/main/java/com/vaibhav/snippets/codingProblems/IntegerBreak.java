package com.vaibhav.snippets.codingProblems;

public class IntegerBreak {
    /**
     * Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.
     *
     * Return the maximum product you can get.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 2
     * Output: 1
     * Explanation: 2 = 1 + 1, 1 × 1 = 1.
     * Example 2:
     *
     * Input: n = 10
     * Output: 36
     * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
     */

    public static void main(String[] args) {
        int result1 = integerBreak(10);
        int result2 = integerBreak(5);
        System.out.println("Test case 1 : "+((result1==36) ? "pass" : "fail"));
        System.out.println("Test case 2 : "+((result2==6) ? "pass" : "fail"));

    }
    public static int integerBreak(int n) {
        if(n ==2) {
            return 1;
        } else if (n==3) {
            return 2;
        }
        else if (n%3 == 0){
            return (int)Math.pow(3, n/3);
        }
        else {
            int dis  = n % 3;
            int multiplier = ((dis == 1) ? 4 : 2);
            int multiple = n/3 - ((multiplier == 4) ? 1 : 0);
            return (int)( multiplier*Math.pow(3,multiple));
        }
    }


}
