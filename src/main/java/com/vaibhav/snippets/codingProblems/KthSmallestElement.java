package com.vaibhav.snippets.codingProblems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElement {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(getKthSmallestElement(arr, 5));
        System.out.println(getKthSmallestElement(arr, 7));

        System.out.println(getKthSmallest2(arr, 5));
        System.out.println(getKthSmallest2(arr, 7));
    }

    // O(n + kLogn).
    private static int getKthSmallestElement(int[] numbers, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(numbers.length);
        for (int val : numbers) {
            minHeap.add(val);
        }
        int result = 0;
        while (k-- > 0) {
            result = minHeap.poll();
        }
        return result;
    }

    // O(k + (n-k)*Logk)
    private static int getKthSmallest2(int[] numbers, int k) {
        Comparator<Integer> reverse = (Integer v1, Integer v2) -> v1 > v2 ? -1 : 1;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(numbers.length, reverse);

        for (int i = 0; i < k; i++) {
            maxHeap.add(numbers[i]);
        }
        for (int i = k; i < numbers.length; i++) {
            int top = maxHeap.peek();
            if (top > numbers[i]) {
                maxHeap.add(numbers[i]);
                maxHeap.poll();
            }
        }
        return maxHeap.poll();
    }
}
