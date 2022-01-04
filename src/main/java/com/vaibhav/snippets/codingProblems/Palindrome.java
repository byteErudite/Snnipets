package com.vaibhav.snippets.codingProblems;

public class Palindrome {

    public static  void main(String[] args) {
        //String input = "abscabbaqwertyuiabcfddfcba";
        String input = "aba";
        System.out.println(longestPalindromicSubstring(input));
        System.out.println(countPalindromes(input));
    }

    public static int longestPalindromicSubstring(String str) {
        int longestSubstringLength = Integer.MIN_VALUE;
        for(int i =0; i< str.length() ; i++) {
            int firstResult = iteratePalindrome(i, i, str);
            int secondResult = iteratePalindrome(i, i+1, str);
            firstResult = firstResult > secondResult ? firstResult : secondResult;
            if (longestSubstringLength < firstResult) {
                longestSubstringLength = firstResult;
            }
        }
        return  longestSubstringLength;
    }

    private static int iteratePalindrome(int start, int end, String str) {
        while (start >= 0  && end < str.length() && str.charAt(start) == str.charAt(end)) {
            start--;
            end++;
        }

        return end - start -1;
    }

    private static int countPalindromes(String str) {
        int longest = Integer.MIN_VALUE;
        int length=str.length();
        int count=0;
        boolean[][] isPalindrome = new boolean[length+1][length+1];
        for(int i =0; i<length ; i++) {
            for (int j =i; j<str.length() ; j++) {
                if(i==0) {
                    isPalindrome[i][j] = true;
                } else if(i ==1) {
                    isPalindrome[i][j] = (str.charAt(i) == str.charAt(j));
                } else {
                    isPalindrome[i][j] = (str.charAt(i) == str.charAt(j)  && isPalindrome[i+1][j-1]);
                }

                if (isPalindrome[i][j]) {
                    if(longest < j-i+1) {
                        longest = j-i+1;
                    }
                    count++;
                }
            }
        }
        System.out.println(longest);
        return count;
    }
}
