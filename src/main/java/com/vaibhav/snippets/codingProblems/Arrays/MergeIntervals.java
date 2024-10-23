package com.vaibhav.snippets.codingProblems.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    /**
     * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
     *
     *
     *
     * Example 1:
     *
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
     * Example 2:
     *
     * Input: intervals = [[1,4],[4,5]]
     * Output: [[1,5]]
     * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     *
     */

    public static void main(String[] args) {

    }

    Comparator<Pair> compareByFirst = (Pair first, Pair second) -> comparePair(first,second);

    public int comparePair(Pair first, Pair second) {
        if(first.a > second.a) {
            return 1;
        } else if(first.a == second.a) {
            return first.b <= second.b ? 1 : -1;
        } else {
            return -1;
        }
    }


    // logic : sort the intervals using start point
    //         if start is same for two intervals , the one with greater end will be later in sorted result
    //         take first interval from sorted result as current result and compare with rest
    //         three cases are possible :
    //            1) Complete intersection : No action is required as the new interval wont change boundaries
    //            2) Partial overlap : only end boundary will be affected , assign end of new interval to curr interval end
    //            3) Complete disjoint : Need a new interval in result , add the current to result and create new current with values of the interval

    public int[][] merge(int[][] intervals) {
        List<Pair> intvls = new ArrayList<>();
        for(int[] p : intervals) {
            intvls.add(new Pair(p[0], p[1]));
        }

        Collections.sort(intvls, compareByFirst);

        Pair curr = new Pair(intvls.get(0).a,intvls.get(0).b);
        List<Pair> result = new ArrayList<>();
        for(int i = 1 ; i < intvls.size() ; i++) {
            Pair next = intvls.get(i);
            if (curr.b < next.b && curr.b >= next.a) {
                curr.b = next.b;
            } else if(curr.b < next.a) {
                result.add(curr);
                curr = new Pair(next.a, next.b);
            }
        }
        result.add(curr);

        int[][] arrRes = new int[result.size()][2];

        int i = 0;
        for(Pair p : result) {
            arrRes[i][0] = p.a;
            arrRes[i][1] = p.b;
            i++;
        }
        return arrRes;
    }




    class Pair {
        int a;
        int b;
        Pair(int a , int b) {
            this.a= a;
            this.b=b;
        }
    }
}
