package com.vaibhav.snippets.codingProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

        int[][] queries = {{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}};//
        String testString = "abcda";
        List<Boolean> result = canMakePaliQueries(testString, queries);
        result.stream().forEach(System.out::println);
    }

    private static void copyArr(int[] arr1, int[] arr2) {
        for(int i = 0 ; i< arr1.length ; i++) {
            arr1[i] = arr2[i];
        }
    }

    private static int[][]  getCountOfOddCharacterAtEachIndex(char[] arr) {

        int[][] countAtEachInd = new int[arr.length][26];
        for(int i =0 ; i< arr.length ; i++) {
            for(int j = 0 ; j < 26 ; j++) {
                countAtEachInd[i][j] = 0;
            }
        }
        countAtEachInd[0][((int)arr[0]) - 97] = 1;
        for(int i =1 ; i< arr.length ; i++) {
            copyArr(countAtEachInd[i], countAtEachInd[i-1]);
            countAtEachInd[i][((int)arr[i]) - 97]++;
        }
        return countAtEachInd;
    }

    public static List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        char[] arr = s.toCharArray();
        List<Boolean> result = new ArrayList<>();
        int[][] oddCharacterCountAtIndex = getCountOfOddCharacterAtEachIndex(arr);
        for(int[] query : queries) {
            int begin = query[0];
            int end = query[1];
            int replacableCharacterCount = query[2];
            int[] zeroArr = new int[26];
            for(int i = 0 ; i< 26 ; i++) {
                zeroArr[i] = 0;
            }

            int[] countsAtBegin = begin == 0 ? zeroArr : oddCharacterCountAtIndex[begin-1];
            int[] countAtEnd = oddCharacterCountAtIndex[end];
            int oddCount = 0;
            for(int i = 0 ; i< 26 ; i++) {
               if ((countAtEnd[i] - countsAtBegin[i])  % 2 != 0)  {
                   oddCount++;
               }
            }
            if((Math.ceil(oddCount -1)/2) > replacableCharacterCount) {
                result.add(false);
            } else {
                result.add(true);
            }
        }
        return result;
    }
}
