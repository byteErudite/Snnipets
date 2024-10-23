package com.vaibhav.snippets;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String testSource = "ADOBECODEBANC";
        String target = "ABC";
        System.out.println(minWindow(testSource, target));

        String testSource2 = "A";
        String target2 = "A";
        System.out.println(minWindow(testSource2, target2));

        String testSource3 = "A";
        String target3 = "AA";
        System.out.println(minWindow(testSource3, target3));
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> sourceFrequency = new HashMap<>();
        Map<Character, Integer> targetFrequency = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetFrequency.put(c, targetFrequency.getOrDefault(c, 0) + 1);
        }

        int minWindow = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        char[] characters = s.toCharArray();
        String minWindowString = "";
        sourceFrequency.put(characters[0], 1);
        while (end < characters.length && start < characters.length) {
            if (isASubset(targetFrequency, sourceFrequency)) {
                if (minWindow > end - start) {
                    minWindow = end - start;
                    minWindowString = s.substring(start, end + 1);
                }
                sourceFrequency.put(characters[start], sourceFrequency.get(characters[start]) - 1);
                start++;
            } else {
                end++;
                if (end < characters.length) {
                    sourceFrequency.put(characters[end], sourceFrequency.getOrDefault(characters[end], 0) + 1);
                }
            }
        }
        return minWindowString;
    }

    public static boolean isASubset(Map<Character, Integer> source, Map<Character, Integer> target) {
        for (char c : source.keySet()) {
            if (target.getOrDefault(c, 0) < source.get(c)) {
                return false;
            }
        }
        return true;
    }
}
