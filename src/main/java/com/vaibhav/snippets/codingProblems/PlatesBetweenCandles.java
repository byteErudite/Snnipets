package com.vaibhav.snippets.codingProblems;

public class PlatesBetweenCandles {
    public static void main(String[] args) {
        int[][] queries = {{2,5}, {5,9}};
        int[] result = platesBetweenCandles_("**|**|***|", queries);
        for(int queryResult : result) {
            System.out.println(queryResult);
        }
    }

    public static int[] platesBetweenCandles_(String s, int[][] queries) {
        char[] arr  = s.toCharArray();
        int length = arr.length;
        int[] result = new int[queries.length];
        int[] rightMostNearestCandle = new int[arr.length];
        populateRightMostNearestCandleIndex(rightMostNearestCandle, arr, length);
        int[] leftMostNearestCandle = new int[arr.length];
        populateLeftMostNearestCandleIndex(leftMostNearestCandle, arr, length);
        int[] plateSum = new int[length];
        populatePlateSum(plateSum, arr, length);
        for(int t = 0 ; t < queries.length ; t++) {
            int[] query = queries[t];
            if (query[0] == query[1] || rightMostNearestCandle[query[0]] > query[1]) {
                result[t] = 0;
                continue;
            }
            int firstCandleIndex = rightMostNearestCandle[query[0]];
            int lastCandleIndex = leftMostNearestCandle[query[1]];

            if (firstCandleIndex == lastCandleIndex || firstCandleIndex == -1 || lastCandleIndex == -1) {
                result[t] = 0;
                continue;
            }
            result[t] = plateSum[lastCandleIndex] - plateSum[firstCandleIndex];
        }
        return  result;
    }


    private static void populateLeftMostNearestCandleIndex(int[] leftMostNearestCandle, char[] arr, int length) {
        leftMostNearestCandle[0] = arr[0] == '|' ? 0 : -1;
        if(length > 2) {

            for (int i = 1; i <= arr.length - 1; i++) {
                if (arr[i] == '*') {
                    leftMostNearestCandle[i] = leftMostNearestCandle[i - 1];
                } else {
                    leftMostNearestCandle[i] = i;
                }
            }
        }
    }
    private static void populateRightMostNearestCandleIndex(int[] rightMostNearestCandle, char[] arr, int length) {
        rightMostNearestCandle[length -1] = arr[length-1] == '|' ? length -1 : -1;
        if (length > 2) {
            for (int i = arr.length - 2; i >= 0; i--) {
                if (arr[i] == '*') {
                    rightMostNearestCandle[i] = rightMostNearestCandle[i + 1];
                } else {
                    rightMostNearestCandle[i] = i;
                }
            }
        }
    }
    private static void populatePlateSum(int[] plateSum, char[] arr, int length) {
        plateSum[0] = arr[0] == '*' ? 1 : 0;
        for(int i = 1 ; i <= arr.length -1 ; i++) {
            plateSum[i] = arr[i] == '*' ? plateSum[i-1] +1 : plateSum[i-1];
        }
    }
}
