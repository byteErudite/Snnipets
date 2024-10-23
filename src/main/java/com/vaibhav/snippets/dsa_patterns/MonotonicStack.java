package com.vaibhav.snippets.dsa_patterns;

import java.util.Stack;

public class MonotonicStack {
    /**
     * A Monotonic Stack is a stack whose elements are monotonically
     * increasing or decreasing. It contains all qualities that a typical
     * stack has and its elements are all monotonically decreasing or
     * increasing.
     * Some features of a monotonic stack:
     *
     * It is a range of queries in an array of situation
     * The minima/maxima elements
     * When an element is popped from the monotonic stack, it will never be utilized again.
     */

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 4, 5, 11, 9, 20};
        int[] res = greatestToRight(arr);
        for(int i = 0 ; i < res.length; i++) {
            System.out.println(arr[i]+" -> "+res[i]);
        }
    }


    // greatest integer to the right
    public static  int[] greatestToRight(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];

        for(int i = 0 ; i < arr.length; i++) {
            if (st.isEmpty()) {
                st.push(i);
            }

            while(!st.isEmpty() && arr[i] > arr[st.peek()]) {
                res[st.pop()] = arr[i];
            }

            st.push(i);
        }

        return  res;
    }
}
