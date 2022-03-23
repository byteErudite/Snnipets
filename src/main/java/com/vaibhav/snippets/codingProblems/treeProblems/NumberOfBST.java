package com.vaibhav.snippets.codingProblems.treeProblems;

public class NumberOfBST {
    /*
    Given an integer A, how many structurally unique BST’s (binary search trees) exist that can store values 1…A?
    Input Format:

    The first and the only argument of input contains the integer, A.
    Output Format:

    Return an integer, representing the answer asked in problem statement.
    Constraints:
    Input 1: A = 3
    Output 1: 5

Explanation 1:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
     */
    /*
    Approach :
    Lets say you know the answer for values i which ranges from 0 <= i <= n - 1.
    How do you calculate the answer for n.

    Lets consider the number [1, n]
    We have n options of choosing the root.
    If we choose the number j as the root, j - 1 numbers fall in the left subtree, n - j numbers fall in the right subtree. We already know how many ways there are to forming j - 1 trees using j - 1 numbers and n -j numbers.
    So we add number(j - 1) * number(n - j) to our solution.
     */

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
    public static int numTrees(int A) {

        if(A<=2) return A;

        int[] dp = new int[A+1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3;i<=A;i++){
            int sum =0;
            for(int j=1;j<=i;j++){
                int n1 = dp[j-1];
                int n2 = dp[i-j];
                sum += n1*n2;
            }
            dp[i] = sum;
        }

        return dp[A];
    }
}
