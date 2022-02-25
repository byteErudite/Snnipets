package com.vaibhav.snippets.codingProblems;

public class WaysToDecodeString {

    /*
    A message containing letters from A-Z is being encoded to numbers using the following mapping:

    'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26
    Given an encoded message A containing digits, determine the total number of ways to decode it modulo 109 + 7.
     */
    public int numDecodings(String str) {
        int n=str.length();
        if(str==null||n==0)
            return 0;
        int dp[]=new int[n+1];
        dp[0]=1;
        if(str.charAt(0)!='0')
            dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            int first=Integer.parseInt(str.substring(i-1,i));
            int second=Integer.parseInt(str.substring(i-2,i));
            if(first>=1&&first<=9)
                dp[i]+=dp[i-1];
            if(second>=10&&second<=26)
                dp[i]+=dp[i-2];
        }
        return dp[n];
    }
}
