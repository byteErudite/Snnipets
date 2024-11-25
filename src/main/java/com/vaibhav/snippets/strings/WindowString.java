package com.vaibhav.snippets.strings;


public class WindowString {

    /*
    Given a string S and a string T, find the minimum window in S which will contain all the characters in T in linear time complexity.

Note that when the count of a character C in T is N, then the count of C in minimum window in S should be at least N.

Example :

S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC"
     */

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String A, String B) {
        int p[] = new int[256];
        int s[] = new int[256];
        String res = "";

        for (int i = 0; i < B.length(); i++)
            p[B.charAt(i)]++;

        int start = 0,  min = Integer.MAX_VALUE;
        int count = 0;
        for (int j = 0; j < A.length(); j++){
            s[A.charAt(j)]++;

            if (s[A.charAt(j)] <= p[A.charAt(j)] )
                count++;

            if (count == B.length()){
                while ( s[A.charAt(start)] > p[A.charAt(start)]){
                    s[A.charAt(start)]--;
                    start++;
                }
                if(j - start + 1 < min){
                    min = j - start + 1;
                    res = A.substring(start, j+1);
                }
                min = Math.min(min, j - start + 1);
            }
        }
        return res;
    }
}
