package com.vaibhav.snippets.interview_exp_questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StringMatching {
    /**
     * Given an input string, s, and an array of n strings, dictionary, find the
     * lexicographically smallest word in the dictionary that is a subsequence of the given
     * string s.
     */

    public static boolean isSubsequence(String parent, String child) {
        int cLen = child.length();
        int pLen = parent.length();

        int i =0;
        int j =0;
        while(i < cLen && j < pLen) {
            if (child.charAt(i) == parent.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == cLen;
    }

    public static void main(String[] args) {
       List<String> arr = new ArrayList<>();
       arr.add("coffee");
       arr.add("coding");
       arr.add("happy");
       arr.add("hello");
       arr.add("hop");

        System.out.println(lexographicallySmallest( "hgferyjkllkop",arr));

    }

    public static String lexographicallySmallest(String s, List<String> dict) {
       List<String> subsequences = dict.stream().filter(str -> isSubsequence(s, str)).collect(Collectors.toList());
       Collections.sort(subsequences);
       return subsequences.get(0);
    }
}
