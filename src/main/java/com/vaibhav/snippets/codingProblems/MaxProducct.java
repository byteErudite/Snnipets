package com.vaibhav.snippets.codingProblems;

import java.util.Arrays;
import java.util.List;

public class MaxProducct {
    /*
    Find the contiguous subarray within an array (containing at least one number) which has the largest product.

    Return an integer corresponding to the maximum product possible.
    Input : [2, 3, -2, 4]
    Return : 6
     */

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(2,3,-2,4);
        System.out.println(maxProduct(arr));
    }

    public static  int maxProduct(final List<Integer> A) {
        if (A.size() == 0) {
            return 0;
        }
        int[] posProduct = new int[A.size()];
        int[] negProduct = new int[A.size()];
        int[] maxProduct = new int[A.size()];
        posProduct[0] = negProduct[0] = maxProduct[0] = A.get(0);
        for (int i = 1;i < A.size();i++) {
            int a = posProduct[i-1] * A.get(i);
            int b = negProduct[i-1] * A.get(i);
            posProduct[i] = Math.max(Math.max(a, b), A.get(i));
            negProduct[i] = Math.min(Math.min(a, b), A.get(i));
            maxProduct[i] = Math.max(posProduct[i], maxProduct[i-1]);
        }
        return maxProduct[A.size()-1];
    }
}
