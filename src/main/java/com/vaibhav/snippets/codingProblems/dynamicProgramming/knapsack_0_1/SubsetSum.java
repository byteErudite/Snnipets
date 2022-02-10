package com.vaibhav.snippets.codingProblems.dynamicProgramming.knapsack_0_1;

public class SubsetSum {
    public static void main(String[] args) {
        int target = 36;
        int[] arr = {7,9,4,8,23};
        System.out.println(subsetSumExists(arr, target, arr.length-1));

        Boolean[][] cash = Utility.get2DArrayInitialized(arr.length, target+1);
        System.out.println(subsetSumExistsMemoized(arr, target, arr.length-1, cash));
    }

    private static boolean subsetSumExists(int[] arr, int target, int currLen) {
        if (currLen < 0 ) {
            return  false;
        }
        if (target ==0) {
            return true;
        }
        if (arr[currLen] <= target) {
            return subsetSumExists(arr, target - arr[currLen], currLen-1)
                    || subsetSumExists(arr, target, currLen-1);
        } else {
            return subsetSumExists(arr, target, currLen-1);
        }
    }

    private static boolean subsetSumExistsMemoized(int[] arr, int target, int currLen, Boolean[][] cash) {
        if (currLen < 0 ) {
            return  false;
        }
        if (target ==0) {
            return true;
        }
        if (cash[currLen][target] != null) {
            return cash[currLen][target];
        } else {
            if (arr[currLen] <= target) {
                cash[currLen][target] = subsetSumExists(arr, target - arr[currLen], currLen-1)
                        || subsetSumExists(arr, target, currLen-1);
                return cash[currLen][target];
            } else {
                cash[currLen][target] = subsetSumExists(arr, target, currLen-1);
                return cash[currLen][target];
            }
        }
    }
}

class Utility {
    public static void get2DArrayInitialized(int len, int brdth, int value) {
        int[][] arr = new int[len][brdth];
        for (int i = 0 ; i < len ; i++ ) {
            for (int j = 0 ; j < brdth ; j++ ) {
                arr[i][j] = value;
            }
        }
    }

    public static Boolean[][] get2DArrayInitialized(int len, int brdth) {
        Boolean[][] arr = new Boolean[len][brdth];
        for (int i = 0 ; i < len ; i++ ) {
            for (int j = 0 ; j < brdth ; j++ ) {
                arr[i][j] = null;
            }
        }
        return arr;
    }
}
