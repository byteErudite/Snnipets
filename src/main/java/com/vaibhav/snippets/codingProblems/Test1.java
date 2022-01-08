package com.vaibhav.snippets.codingProblems;

import java.util.PriorityQueue;
import java.util.Queue;

public class Test1 {

    public static void main(String[] args) {
        int[] numbers = {4,7,3,1}; //{3,4,7,1}
        // 1 + 3 = 4
        // 4 + 4 + 4 = 12
        // 8 + 7 + 12 = 27
        Queue<Integer> heap = new PriorityQueue<>();
        for( int num : numbers) {
            heap.add(num);
        }
        int minSum = 0;

        while(heap.size() > 2) {
            int first = heap.poll();
            int second = heap.poll();
            int newElement = first + second;
            minSum = minSum + newElement;
            heap.add(newElement);

        }
        for(int val : heap) {
            minSum = minSum + val;
        }
        System.out.println(minSum);
    }
}
