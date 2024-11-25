package com.vaibhav.snippets.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LargestString {

    /*
    Given a list of non negative integers, arrange them such that they form the largest number.

    For example:

    Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

    Note: The result may be very large, so you need to return a string instead of an integer.
     */

    public static void main(String[] args) {
        Integer[] arr = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(Arrays.asList(arr)));
    }

    private static int compare(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return (s1).compareTo(s2)*(-1);
        } else {
            return (s1 + s2).compareTo(s2 + s1)*(-1);
        }
    }

    public static String largestNumber(final List<Integer> A) {
        List<String> AS = new ArrayList<>();
        for(int val : A) {
            AS.add(String.valueOf(val));
        }
        Comparator<String> sorter = (String s1, String s2) -> compare(s1, s2);
        AS.sort(sorter);
        StringBuilder result = new StringBuilder();
        AS.stream().forEach(s-> result.append(s));
        return removeStartingZeroes(result.toString());
    }

    private static String removeStartingZeroes(String s) {
        if (s.length() == 1) return s;
        int firstNonZeroIndex = 0;
        while(firstNonZeroIndex < s.length() && s.charAt(firstNonZeroIndex) == '0') {
            firstNonZeroIndex++;
        }
        return firstNonZeroIndex == s.length() ? "0" : s.substring(firstNonZeroIndex);
    }
}
