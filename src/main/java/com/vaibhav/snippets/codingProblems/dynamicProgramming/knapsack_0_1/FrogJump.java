package com.vaibhav.snippets.codingProblems.dynamicProgramming.knapsack_0_1;

import java.util.Arrays;

public class FrogJump {
    /**
     * There is a frog on the '1st' step of an 'N' stairs long staircase. The frog wants to reach the 'Nth' stair. 'HEIGHT[i]' is the height of the '(i+1)th' stair.If Frog jumps from 'ith' to 'jth' stair, the energy lost in the jump is given by absolute value of ( HEIGHT[i-1] - HEIGHT[j-1] ). If the Frog is on 'ith' staircase, he can jump either to '(i+1)th' stair or to '(i+2)th' stair. Your task is to find the minimum total energy used by the frog to reach from '1st' stair to 'Nth' stair.
     *
     * For Example
     * If the given ‘HEIGHT’ array is [10,20,30,10], the answer 20 as the frog can jump from 1st stair to 2nd stair (|20-10| = 10 energy lost) and then a jump from 2nd stair to last stair (|10-20| = 10 energy lost). So, the total energy lost is 20.
     * Detailed explanation ( Input/output format, Notes, Images )
     * Constraints:
     * 1 <= T <= 10
     * 1 <= N <= 100000.
     * 1 <= HEIGHTS[i] <= 1000 .
     *
     * Time limit: 1 sec
     * Sample Input 1:
     * 2
     * 4
     * 10 20 30 10
     * 3
     * 10 50 10
     * Sample Output 1:
     * 20
     * 0
     * Explanation of sample input 1:
     * For the first test case,
     * The frog can jump from 1st stair to 2nd stair (|20-10| = 10 energy lost).
     * Then a jump from the 2nd stair to the last stair (|10-20| = 10 energy lost).
     * So, the total energy lost is 20 which is the minimum.
     * Hence, the answer is 20.
     *
     * For the second test case:
     * The frog can jump from 1st stair to 3rd stair (|10-10| = 0 energy lost).
     * So, the total energy lost is 0 which is the minimum.
     * Hence, the answer is 0.
     * Sample Input 2:
     * 2
     * 8
     * 7 4 4 2 6 6 3 4
     * 6
     * 4 8 3 10 4 4
     * Sample Output 2:
     * 7
     * 2
     */

    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return frogJump2(n-1, heights, dp);
    }

    public static int frogJump(int n, int heights[], int[] dp) {
        if(n < 0) return Integer.MAX_VALUE;
        if(n == 0) return 0;
        if (n == 1) return Math.abs(heights[1] - heights[0]);
        if (n == 2) return Math.abs(heights[2] - heights[0]);

        if(dp[n] != -1) return dp[n];

        int oneJump = Math.abs(heights[n] - heights[n-1]) + frogJump(n-1, heights, dp);
        int twoJump = Math.abs(heights[n] - heights[n-2]) + frogJump(n-2, heights,dp);

        return dp[n] = Math.min(oneJump, twoJump);
    }

    public static int frogJump2(int n, int heights[], int[] dp) {
        dp[0] = 0;
        dp[1] = Math.abs(heights[1] - heights[0]);
        dp[2] = Math.abs(heights[2] - heights[0]);

        if(n < 3) {
            return dp[n];
        }

        for (int i = 3 ; i <= n ; i++) {
            dp[i] = Math.min(dp[i-1] + Math.abs(heights[i-1]-heights[i]),
                    dp[i-2] + Math.abs(heights[i-2]-heights[i]));
        }

        return dp[n];
    }
}
