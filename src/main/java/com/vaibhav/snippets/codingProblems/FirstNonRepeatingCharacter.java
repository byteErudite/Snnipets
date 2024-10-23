package com.vaibhav.snippets.codingProblems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FirstNonRepeatingCharacter {

    /**
     * First Time meeting the wizard
     * You are travelling through a wizard town hoggsmeed on a secret mission from dumbledoore
     * You will be fighting off other wizards in the process , once you beat a wizard you will know how to
     *
     * @param args
     */
    /*
    Given a string A denoting a stream of lowercase alphabets. You have to make new string B.

    B is formed such that we have to find first non-repeating character each time a character is inserted to the stream
    and append it at the end to B. If no non-repeating character is found then append '#' at the end of B.

    Input 1  = "abadbc"
    Output 1 = "aabbdd"

    Input 2 = "abcabc"
    Output 2 = "aaabc#"
     */

    public static void main(String[] args) {
        String test1 = "abadbc";
        String test1ExpectedOutput = "aabbdd";
        String test2 = "abcabc";
        String test2ExpectedOutput = "aaabc#";

        System.out.println("Expectation on test case 1 : "+(test1ExpectedOutput.equalsIgnoreCase(solve(test1))));
        System.out.println("Expectation on test case 2 : "+(test2ExpectedOutput.equalsIgnoreCase(solve(test2))));
    }

    public static String solve(String A) {
        char[] arr = A.toCharArray();
        Queue<Character> q = new LinkedList<>();
        Set<Character> s = new HashSet<>();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            // if character has already appeared remove from queue , else add character to queue and append top of queue
            // in result
            if (s.contains(arr[i])) {
                q.remove(arr[i]);
            } else {
                q.add(arr[i]);
                s.add(arr[i]);
            }

            // if no non repeatind characters present up till now i.e queue is empty then append '#' else append queue top
            if (q.isEmpty()) {
                result.append('#');
            } else {
                result.append(q.peek());
            }
        }
        return result.toString();
    }
}
