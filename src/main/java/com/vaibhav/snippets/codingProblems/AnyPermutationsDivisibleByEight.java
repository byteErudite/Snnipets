package com.vaibhav.snippets.codingProblems;

import java.util.HashMap;
import java.util.Map;

public class AnyPermutationsDivisibleByEight {
    /*
    Given an array consisting of numbers in the form of string. For each number,
     find if any of its permutation is divisible by 8.
     */

    public static void main(String[] args) {
        String testString = "1354277";
        System.out.println(hasPermuatationDivisibleBy8(testString));
    }

    private static boolean hasPermuatationDivisibleBy8(String str) {
        char[] arr = str.toCharArray();
        Map<String, Integer> charToFreq = new HashMap<>();
        for(char c : arr) {
            charToFreq.put(String.valueOf(c), charToFreq.getOrDefault(c, 0)+1);
        }
        //any number ending with 000 is divisible by 8
        if (charToFreq.getOrDefault('0',0) >= 3) {
            return true;
        }


        for(int i= 8; i <=992; i=i+8) {
            int num = i;
            Map<String,Integer> charToFreqLocal = new HashMap<>(charToFreq);
            boolean result = true;
            while(num >= 1) {
                int r = num%10;
                num = num/10;
                if (charToFreqLocal.getOrDefault(String.valueOf(r), 0) > 0) {
                    charToFreqLocal.put(String.valueOf(r), charToFreqLocal.get(String.valueOf(r))-1);
                } else {
                    result = false;
                    break;
                }
            }

            if (result) {
                System.out.println(i);
                return result;
            }
        }
        return false;
    }
}
