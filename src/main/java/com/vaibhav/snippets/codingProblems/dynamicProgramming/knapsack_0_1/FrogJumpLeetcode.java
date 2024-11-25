package com.vaibhav.snippets.codingProblems.dynamicProgramming.knapsack_0_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FrogJumpLeetcode {

    /**
     * A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
     *
     * Given a list of stones positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.
     *
     * If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.
     *
     *
     *
     * Example 1:
     *
     * Input: stones = [0,1,3,5,6,8,12,17]
     * Output: true
     * Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.
     * Example 2:
     *
     * Input: stones = [0,1,2,3,4,8,9,11]
     * Output: false
     * Explanation: There is no way to jump to the last stone as the gap between the 5th and 6th stone is too large.
     */

    public boolean canCross(int[] stones) {
        int maxStone = Integer.MIN_VALUE;
        for(int stone : stones) {
            if (stone > maxStone) {
                maxStone = stone;
            }
        }
        Boolean[][] dp = new Boolean[stones.length + 1][2000];

        Map<Integer, Integer> stoneToIndex = new HashMap<>();
        for(int i = 0 ; i< stones.length ; i++) {
            stoneToIndex.put(stones[i], i);
        }
        return canCross(stones, 0, 0, dp, stoneToIndex);
    }

    public boolean canCross(int[] stones, int ind, int jump, Boolean[][] dp, Map<Integer, Integer> map) {

        if (ind >= stones.length) {
            return false;
        }

        if (ind == stones.length -1) {
            return  true;
        }

        if(dp[ind][jump] != null) {
            return dp[ind][jump];
        }

        boolean isJumpPossible = false;
        for(int i = jump -1 ; i <= jump + 1; i++) {
            if (i > 0 && map.containsKey(stones[ind] + i) && map.get(stones[ind] + i) > ind) {
                isJumpPossible = isJumpPossible || canCross(stones, map.get(stones[ind] + i), i, dp, map);
            }
        }

        return dp[ind][jump] = isJumpPossible;

    }
}
