package com.vaibhav.snippets.codingProblems;

import java.util.HashMap;
import java.util.Map;

public class VowelPermutation {

    /*
    Given an integer n, your task is to count how many strings of length n can be formed under the following rules:

    Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
    Each vowel 'a' may only be followed by an 'e'.
    Each vowel 'e' may only be followed by an 'a' or an 'i'.
    Each vowel 'i' may not be followed by another 'i'.
    Each vowel 'o' may only be followed by an 'i' or a 'u'.
    Each vowel 'u' may only be followed by an 'a'.
    Since the answer may be too large, return it modulo 10^9 + 7.
     */

    Map<String, Integer> startingCharToLenRemaining = new HashMap<>();

    public char[] getAllowedFollowVowels(char cha){

        switch(cha){
            case 'a' :
                char[] sa1 = {'e'};
                return sa1;
            case 'e':
                char[] sa2 = {'a', 'i'};
                return sa2;
            case 'i' :
                char[] sa3 = {'a', 'e', 'o', 'u'};
                return sa3;
            case 'o':
                char[] sa4 = {'i', 'u'};
                return sa4;
            case 'u':
                char[] sa5 =  {'a'};
                return sa5;
        }
        return null;
    }

    int combinationsStartingWithVowel(char st, int n){
        if(n==0){
            return 1;
        }
        String key = st+"-"+n;

        if(startingCharToLenRemaining.containsKey(key))
            return startingCharToLenRemaining.get(key);
        int res = 0;
        for(char v: getAllowedFollowVowels(st))
            res = (res + combinationsStartingWithVowel(v, n-1)) % 1000000007;
        startingCharToLenRemaining.put(key, res);
        return res;
    }
    public int countVowelPermutation(int n) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int res = 0;
        for(char v : vowels)
            res = (res + combinationsStartingWithVowel(v, n-1)) % 1000000007;
        return res;
    }
}
