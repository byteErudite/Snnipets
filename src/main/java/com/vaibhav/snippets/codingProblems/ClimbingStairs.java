package com.vaibhav.snippets.codingProblems;

public class ClimbingStairs {
    /*
    Given N non-negative integers which signifies the cost of the moving from each stair.
     Paying the cost at i-th step, you can either climb one or two steps.
      Given that one can start from the 0-the step or 1-the step, the task is to find the minimum cost
       to reach the top of the floor(N+1) by climbing N stairs.

       Examples:

        Input: a[] = { 16, 19, 10, 12, 18 }
        Output: 31
        Start from 19 and then move to 12.

        Input: a[] = {2, 5, 3, 1, 7, 3, 4}
        Output: 9
        2->3->1->3
     */
    public static void main(String[] args) {

        int[] testArr = { 16, 19, 10, 12, 18 };
        int[] testArr2 = {2, 5, 3, 1, 7, 3, 4};

        System.out.println(min(findMinimumCost( testArr.length-1, 0,0, testArr),
                findMinimumCost( testArr.length-1, 1,0, testArr)));

        System.out.println(min(findMinimumCost( testArr2.length-1, 0,0, testArr2),
                findMinimumCost( testArr2.length-1, 1,0, testArr2)));


        System.out.println(min(findMinimumCostMemoized( testArr.length-1, 0,0, testArr, initializedArray(testArr.length)),
                findMinimumCostMemoized( testArr.length-1, 1,0, testArr, initializedArray(testArr.length))));
        System.out.println(min(findMinimumCostMemoized( testArr2.length-1, 0,0, testArr2, initializedArray(testArr2.length)),
                findMinimumCostMemoized( testArr2.length-1, 1,0, testArr2, initializedArray(testArr2.length))));
    }

    private static int[] initializedArray(int size) {
        int[] arr = new int[size];
        for(int i = 0 ; i < size ; i++) {
            arr[i] = -1;
        }
        return arr;
    }

    private static int min(int a, int b) {
        return a < b ? a : b;
    }
    private static int findMinimumCost(int max, int currentStep, int cost, int costArr[]) {
        if (currentStep > max) {
            return cost;
        }
        cost = cost + costArr[currentStep];
        if (currentStep == max) {
            return cost;
        }
       return min(findMinimumCost(max, currentStep + 1, cost , costArr), findMinimumCost(max, currentStep + 2, cost , costArr));

    }

    private static int findMinimumCostMemoized(int max, int currentStep, int cost, int costArr[], int[] results) {
        if (currentStep > max) {
            return results[max] = cost;
        }
        cost = cost + costArr[currentStep];
        if (currentStep == max) {
            return results[max] = cost;
        }
        if (results[currentStep] == -1) {
            results[currentStep] = min(findMinimumCostMemoized(max, currentStep + 1, cost, costArr, results), findMinimumCostMemoized(max, currentStep + 2, cost , costArr, results));
        }
        return results[currentStep];
    }
}
