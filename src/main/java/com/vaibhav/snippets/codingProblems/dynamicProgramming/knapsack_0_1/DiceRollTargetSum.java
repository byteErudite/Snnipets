package com.vaibhav.snippets.codingProblems.dynamicProgramming.knapsack_0_1;

public class DiceRollTargetSum {

    /**
     * Number of Dice Rolls With Target Sum
     * You have n dice, and each dice has k faces numbered from 1 to k.
     *
     * Given three integers n, k, and target, return the number of possible ways (out of the kn total ways) to roll the dice, so the sum of the face-up numbers equals target. Since the answer may be too large, return it modulo 109 + 7.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 1, k = 6, target = 3
     * Output: 1
     * Explanation: You throw one die with 6 faces.
     * There is only one way to get a sum of 3.
     * Example 2:
     *
     * Input: n = 2, k = 6, target = 7
     * Output: 6
     * Explanation: You throw two dice, each with 6 faces.
     * There are 6 ways to get a sum of 7: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
     * Example 3:
     *
     * Input: n = 30, k = 30, target = 500
     * Output: 222616187
     * Explanation: The answer must be returned modulo 109 + 7.
     */

    public static void main(String[] args ) {
        System.out.println(numRollsToTarget(2, 6, 7));
        System.out.println(numRollsToTarget(30, 30, 500));
    }

    static final long modulo = (long)(Math.pow(10,9) + 7);

    public static int numRollsToTarget(int n, int k, int target) {
        //    long numberOfPossibleOutcomes = Math.pow(k, n);
        int[] arr = new int[k];
        for(int i = 1 ; i<= k ; i++) {
            arr[i-1] = i;
        }

        long solution = numberOfSubsets(arr, 1 , n, 0, target) % modulo;
        return (int)solution;
    }

    public static long numberOfSubsets(int[] arr ,int diceNumber, int len, int currLen, int target) {

        if (target < 0 || currLen > len || diceNumber > len +1) {
            return 0;
        }

        if (target == 0) {
            return 1;
        }

        long solution = 0;
        for(int i = 0 ; i< arr.length ; i++) {
            solution = solution + numberOfSubsets(arr, diceNumber + 1, len, currLen , target) + numberOfSubsets(arr, diceNumber +1,  len, currLen+1, target - arr[i]);
        }

        return solution % modulo;
    }
}
