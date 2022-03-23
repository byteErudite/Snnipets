package com.vaibhav.snippets.codingProblems;

import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class SmallestSubstring {

    // find the smallest substring length which contains all the characters from a given string

    public static void main(String[] args) {
        System.out.println(smallestSubstringLength("geeksforgeeks", "ork"));
        System.out.println(smallestSubstringLength("this is a test string", "tist"));
    }

    private static int smallestSubstringLength(String input, String searchStr) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for(char c : searchStr.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0)+1);
        }
        int i =0,j=0;
        int minLength= Integer.MAX_VALUE;
        while(i< input.length() && j< input.length()) {
            if (hasAllChars(input.substring(i,j), frequencyMap)) {
                i++;
                if (j-i+1 < minLength) {
                    minLength = j-i+1;
                }
            } else {
                j++;
            }
        }

        return minLength;
    }

    private static boolean hasAllChars(String str, HashMap<Character, Integer> targetCharFrequency) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(char key : targetCharFrequency.keySet()) {
            Integer value = map.get(key);
            if (Objects.isNull(value) || value < targetCharFrequency.get(key)) {
                return false;
            }
        }
        return true;
    }
}
