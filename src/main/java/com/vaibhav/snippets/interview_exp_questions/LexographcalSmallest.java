package com.vaibhav.snippets.interview_exp_questions;

import java.util.*;

public class LexographcalSmallest {

    /**
     * Given a string s, repeat this operation zero or more times to create the
     * lexicographically smallest string possible.
     *
     * Select two characters that exist in the string, c1, and c2.
     *
     * Replace all occurrences of c1 with c2 and all occurrences of c2 with c1.
     */

    public static void main(String[] args) {
        System.out.println(makeLexicographicallySmallest("bbcacad"));
    }

    public static String makeLexicographicallySmallest(String s) {
        Set<Character> set = new LinkedHashSet<>();
        for(char c : s.toCharArray()) {
            if(!set.contains(c)) {
                set.add(c);
            }
        }

        List<Character> chars = new ArrayList<>(set);
        List<Character> sortedChars = new ArrayList<>(set);
        Collections.sort(sortedChars);

        int i = 0 ;
        Set<Character> swapped = new HashSet<>();
        while(i < set.size()) {
            if (sortedChars.get(i) != chars.get(i) && !swapped.contains(chars.get(i))) {
                swapped.add(sortedChars.get(i));
                s = replaceAll(sortedChars.get(i), chars.get(i), s);
            }
            i++;
        }
        return s;
    }

    public static String replaceAll( char a , char b, String s) {
        StringBuilder res = new StringBuilder();
        for(char c : s.toCharArray()) {
            if (c == a) {
                res.append(b);
            } else if (c == b) {
                res.append(a);
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
