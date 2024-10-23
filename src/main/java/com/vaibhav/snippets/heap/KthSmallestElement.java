package com.vaibhav.snippets.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElement {

    /**
     * Given an array with n values find the kth smallest value
     *
     */

    public static void main(String[] args) {
        int[] test1 = new int[]{2,9,13,4,7,19,8};
        //2,4,7,8,9,13,19
        System.out.println(findKthGreatest(test1, 3));
        System.out.println(findKthGreatest2(test1, 3));
    }


    // using min heap
    // idea : maintain a min heap of size k , if size exceeds that remove the top
    // This way at the end of processing all elements , we would have removed the n - k smallest values in the array
    // This will mean that the heap top will now be the (n-k)th smallest value or kth largest
    // Time : O(n*log(k))
    public static int findKthGreatest(int[] arr, int k) {
        Queue<Integer> q  = new PriorityQueue<>(Collections.reverseOrder());

        for( int i = 0 ; i < arr.length ; i++) {
            q.add(arr[i]);

            if (q.size() > k) {
                q.poll();
            }
        }
        return q.peek();
    }


    // using max heap
    // idea : maintain a max heap of size n - k , if size exceeds that remove the top
    // This way at the end of processing all elements , we would have removed the n-k greatest values in the array
    // This will mean that the heap top will now be the (n-k)th smallest value or kth largest
    // Time : O(n*log(n-k +1))
    public static int findKthGreatest2(int[] arr, int k) {
        Queue<Integer> q  = new PriorityQueue<>();

        for( int i = 0 ; i < arr.length ; i++) {
            q.add(arr[i]);

            if (q.size() > arr.length - k + 1) {
                q.poll();
            }
        }
        return q.peek();
    }
}
