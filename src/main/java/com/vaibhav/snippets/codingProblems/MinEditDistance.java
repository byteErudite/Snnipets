package com.vaibhav.snippets.codingProblems;

import java.util.Arrays;

public class MinEditDistance {
    /*
    Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)

    You have the following 3 operations permitted on a word:

    Insert a character
    Delete a character
    Replace a character


    Input Format:

    The first argument of input contains a string, A.
    The second argument of input contains a string, B.
    Output Format:

    Return an integer, representing the minimum number of steps required.
    Constraints:

    1 <= length(A), length(B) <= 450
    Examples:

    Input 1:
        A = "abad"
        B = "abac"

    Output 1:
        1

    Explanation 1:
        Operation 1: Replace d with c.

    Input 2:
        A = "Anshuman"
        B = "Antihuman"

    Output 2:2

Explanation 2:
    => Operation 1: Replace s with t.
    => Operation 2: Insert i.
     */

    public static void main(String[] args) {
        System.out.println(minDistance("Anshuman", "Antihuman"));;
    }

    public static int minDistance(String a, String b) {
        memo = new int[a.length()][b.length()];
        for (int[] row : memo) Arrays.fill(row, -1);
        return editDist(a, b, 0, 0);
    }

    static int memo[][];
    public static int editDist(String a, String b, int i, int j) {
        if (i == a.length() && j == b.length()) return 0;
        if (i == a.length()) return b.length() - j;
        if (j == b.length()) return a.length() - i;
        if (memo[i][j] != -1) return memo[i][j];
        int res = Integer.MAX_VALUE;
        if (a.charAt(i) == b.charAt(j)) res = editDist(a, b, i + 1, j + 1);
        res = Math.min(res, 1 + editDist(a, b, i + 1, j + 1));
        res = Math.min(res, 1 + editDist(a, b, i + 1, j));
        res = Math.min(res, 1 + editDist(a, b, i, j + 1));
        return memo[i][j] = res;
    }
}
