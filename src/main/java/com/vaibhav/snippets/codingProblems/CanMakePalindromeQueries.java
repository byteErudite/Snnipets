package com.vaibhav.snippets.codingProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class CanMakePalindromeQueries {
    /*
    You are given a string s and array queries where queries[i] = [lefti, righti, ki]. We may rearrange the substring
     s[lefti...righti] for each query and then choose up to ki of them to replace with any lowercase English letter.

    If the substring is possible to be a palindrome string after the operations above, the result of the query is true.
     Otherwise, the result is false.
    Return a boolean array answer where answer[i] is the result of the ith query queries[i].
    Note that each letter is counted individually for replacement, so if, for example s[lefti...righti] = "aaa",
     and ki = 2, we can only replace two of the letters. Also, note that no query modifies the initial string s.
----------------------------------------------------------------------------------------------------------------------------
    Example :

    Input: s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
    Output: [true,false,false,true,true]
    Explanation:
    queries[0]: substring = "d", is palidrome.
    queries[1]: substring = "bc", is not palidrome.
    queries[2]: substring = "abcd", is not palidrome after replacing only 1 character.
    queries[3]: substring = "abcd", could be changed to "abba" which is palidrome.
     Also this can be changed to "baab" first rearrange it "bacd" then replace "cd" with "ab".
    queries[4]: substring = "abcda", could be changed to "abcba" which is palidrome.
     */
    public static void main(String[] args) {
        int[][] queries = {{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}};//
        String testString = "abcda";
        List<Boolean> result = isPalindromePossible(testString, queries);
        result.stream().forEach(System.out::println);
    }

    private static void copyArr(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr2[i];
        }
    }

    private static int[][] getCountOfOddCharacterAtEachIndex(char[] arr) {

        int[][] countAtEachInd = new int[arr.length][26];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 26; j++) {
                countAtEachInd[i][j] = 0;
            }
        }
        countAtEachInd[0][((int) arr[0]) - 97] = 1;
        for (int i = 1; i < arr.length; i++) {
            copyArr(countAtEachInd[i], countAtEachInd[i - 1]);
            countAtEachInd[i][((int) arr[i]) - 97]++;
        }
        return countAtEachInd;
    }

    private static int[] getOddCharCountAtEachIndex(char[] arr) {
        Map<Character,Integer> charToCount = new HashMap<>();
        int[] oddCount = new int[arr.length];
        oddCount[0] = 1;
        for(int i =1; i< arr.length; i++) {
            char val = arr[i];
            charToCount.put(val, charToCount.getOrDefault(val, 0)+1);

            if (isOdd.test(charToCount.get(val))) {
                oddCount[i] = oddCount[i-1] + 1;
            } else {
                oddCount[i] = oddCount[i-1] - 1;
            }
        }
        return oddCount;
    }

    public static List<Boolean> isPalindromePossible(String s, int[][] queries) {
        char[] arr = s.toCharArray();
        List<Boolean> result = new ArrayList<>();
        int[][] oddCharacterCountAtIndex = getCountOfOddCharacterAtEachIndex(arr);
        for (int[] query : queries) {
            int begin = query[0];
            int end = query[1];
            int replaceableCharacterCount = query[2];
            int[] zeroArr = new int[26];
            for (int i = 0; i < 26; i++) {
                zeroArr[i] = 0;
            }

            int[] countsAtBegin = begin == 0 ? zeroArr : oddCharacterCountAtIndex[begin - 1];
            int[] countAtEnd = oddCharacterCountAtIndex[end];
            int oddCount = 0;
            for (int i = 0; i < 26; i++) {
                int countOfCurrChar = countAtEnd[i] - countsAtBegin[i];
                if (isOdd.test(countOfCurrChar)) {
                    oddCount++;
                }
            }
            if ((Math.ceil(oddCount - 1) / 2) > replaceableCharacterCount) {
                result.add(false);
            } else {
                result.add(true);
            }
        }
        return result;
    }

    static Predicate<Integer> isOdd = val -> val % 2 != 0;
}
