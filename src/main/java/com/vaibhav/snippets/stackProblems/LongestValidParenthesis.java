package com.vaibhav.snippets.stackProblems;

import java.util.Stack;

class LongestValidParenthesis {

    /**
     * Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
     * substring
     * Example 1:
     *
     * Input: s = "(()"
     * Output: 2
     * Explanation: The longest valid parentheses substring is "()".
     * Example 2:
     *
     * Input: s = ")()())"
     * Output: 4
     * Explanation: The longest valid parentheses substring is "()()".
     * Example 3:
     *
     * Input: s = ""
     * Output: 0
     * @param s
     * @return
     */

    // Function to find the length of the
    // longest valid parentheses substring
    static int maxLength(String s) {
        Stack<Integer> stack = new Stack<>();

        // Push -1 as the initial index to
        // handle the edge case
        stack.push(-1);
        int maxLen = 0;

        // Traverse the string
        for (int i = 0; i < s.length(); i++) {

            // If we encounter an opening parenthesis,
            // push its index
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {

                // If we encounter a closing parenthesis,
                // pop the stack
                stack.pop();

                // If stack is empty, push the current index
                // as a base for the next valid substring
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {

                    // Update maxLength with the current length
                    // of the valid parentheses substring
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }

    public int longestValidParenthesesWithoutStack(String s) {
        char[] characters = s.toCharArray();
        int open = 0;
        int close = 0;
        int max = 0;

        for(int i = 0; i< characters.length ; i++) {
            if(characters[i] == '(') {
                open++;
            } else if (characters[i] == ')') {
                close++;
            }

            if(close > open) {
                close = 0;
                open = 0;
            }

            if(close == open) {
                max = Math.max(max, 2*open);
            }
        }

        open = 0;
        close = 0;
        for(int i = characters.length-1; i>=0 ; i--) {
            if(characters[i] == ')') {
                open++;
            } else if (characters[i] == '(') {
                close++;
            }

            if(close > open) {
                close = 0;
                open = 0;
            }

            if(close == open) {
                max = Math.max(max, 2*open);
            }
        }
        return max;
    }

    public static void main(String[] args) {
       // String s = ")()())";
        String s = "))))()())";
        System.out.println(maxLength(s));
    }
}
