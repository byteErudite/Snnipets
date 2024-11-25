package com.vaibhav.snippets.codingProblems.dynamicProgramming.knapsack_0_1;

public class PatternMatching {

    /**
     * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
     *
     * '.' Matches any single character.​​​​
     * '*' Matches zero or more of the preceding element.
     * The matching should cover the entire input string (not partial).
     *
     *
     *
     * Example 1:
     *
     * Input: s = "aa", p = "a"
     * Output: false
     * Explanation: "a" does not match the entire string "aa".
     * Example 2:
     *
     * Input: s = "aa", p = "a*"
     * Output: true
     * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
     * Example 3:
     *
     * Input: s = "ab", p = ".*"
     * Output: true
     * Explanation: ".*" means "zero or more (*) of any character (.)".
     * @param
     * @param
     * @return
     */

    public static  void main(String[] args) {
        System.out.println(isMatch("abaserfjoldef", "ab*def" ));
        System.out.println(isMatch("azbcc", "a.b.c" ));
        System.out.println(isMatch("aaaabcd", "a*bcd" ));
    }
    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] dp = new Boolean[m+1][n+1];
        return isMatch(s, p , m-1, n-1, dp);

    }

    public boolean isMatch(String s, String p, int m, int n) {
        if(m < 0 && n < 0) {
            return true;
        }
        if(n < 0 && m >= 0) {
            while(m >= 0) {
                if (p.charAt(m) != '*') {
                    return false;
                }
                m--;
            }
            return true;
        }
        if(m < 0 && n >=0) {
            return false;
        }

        if (p.charAt(m) == s.charAt(n) || p.charAt(m) == '.' ) {
            return isMatch(s, p, m-1, n-1);
        }
        if (p.charAt(m) == '*') {
            return isMatch(s, p, m, n-1) || isMatch(s, p, m-1, n);
        }

        return false;

    }

    public static boolean isMatch(String s, String p, int m, int n, Boolean[][] dp) {

        if(m == 0 && n == 0) {
            return true;
        }
        if(n < 0 && m >= 0) {
            while(m >= 0) {
                if (p.charAt(m) != '*') {
                    return false;
                }
                m--;
            }
            return true;
        }
        if (m < 0 && n >=0) {
            return false;
        }

        if (dp[m][n] == null) {

            if (p.charAt(m) == s.charAt(n) || p.charAt(m) == '.' ) {
                dp[m][n] =  isMatch(s, p, m-1, n-1, dp);
            }
            else if (p.charAt(m) == '*') {
                dp[m][n] = isMatch(s, p, m, n-1, dp) || isMatch(s, p, m-1, n, dp);
            } else {
                dp[m][n] = false;
            }
        }

        return dp[m][n];

    }
}
