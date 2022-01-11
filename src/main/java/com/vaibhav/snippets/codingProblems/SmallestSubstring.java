package com.vaibhav.snippets.codingProblems;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class SmallestSubstring {

    // find the smallest substring length which contains all the characters from a given string

    public static void main(String[] args) {
        System.out.println(smallestSubstringLength("geeksforgeeks", "ork"));
        System.out.println(smallestSubstringLength("this is a test string", "tist"));
    }

    private static int smallestSubstringLength(String originalString, String str) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for(char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0)+1);
        }
        HashMap<Character, Integer> charactersMap = new HashMap<>();
        int i =0,j=0;
        int minLength= Integer.MAX_VALUE;
        while(i< originalString.length() && j< originalString.length()) {
            if(hasAllChars(originalString.substring(i,j), frequencyMap)) {
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

    private static boolean hasAllChars(String str, HashMap<Character, Integer> frequencyMap) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        AtomicBoolean result = new AtomicBoolean(true);
        frequencyMap.forEach((key,value)-> {
            if (map.getOrDefault(key, 0) < value) {
                result.set(false);
            }
        });
        return result.get();
    }
}
