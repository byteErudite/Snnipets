package com.vaibhav.snippets.codingProblems;

import java.util.*;

public class KthSmallestElement {

    public static void main(String[] args) {
        int[] arr = {9, 2, 7, 4, 5, 1, 3, 8, 6};
        System.out.println(getKthSmallestElement(arr, 5));
        System.out.println(getKthSmallestElement(arr, 7));

        System.out.println(getKthSmallest2(arr, 5));
        System.out.println(getKthSmallest2(arr, 7));

        String s = "A";
        for(char c : s.toCharArray()) {
            if( c == 'A') {
                System.out.println("test");
            }
        }

        Set<Character> set = new HashSet<>(Arrays.asList('A', 'B', 'C'));

    }

    // O(n + kLogn).
    private static int getKthSmallestElement(int[] numbers, int k) {
        char c = '0';
        Integer.parseInt(String.valueOf(c));
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
