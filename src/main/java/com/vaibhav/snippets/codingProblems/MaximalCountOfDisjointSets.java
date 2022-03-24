package com.vaibhav.snippets.codingProblems;

import java.util.Arrays;

public class MaximalCountOfDisjointSets {

    /*
    Given a set of N intervals denoted by 2D array A of size N x 2, the task is to find the length of maximal set of
     mutually disjoint intervals.
    Two intervals [x, y] & [p, q] are said to be disjoint if they do not have any point in common.
    Return a integer denoting the length of maximal set of mutually disjoint intervals.

    Input Format : First and only argument is a 2D array A of size N x 2 denoting the N intervals.
    Output Format : Return a integer denoting the length of maximal set of mutually disjoint intervals.

    Input 1:A = [[1, 4],  [2, 3],  [4, 6],  [8, 9]]
    Output 1:   3

    Input 2: A = [[1, 9],  [2, 3],  [5, 7]]
    Output 2: 2

    Example Explanation
    Explanation 1:
        Intervals: [ [1, 4], [2, 3], [4, 6], [8, 9] ]
        Intervals [2, 3] and [1, 4] overlap.
        We must include [2, 3] because if [1, 4] is included then we cannot include [4, 6].
        We can include at max three disjoint intervals: [[2, 3], [4, 6], [8, 9]]

        Explanation 2:
        Intervals: [ [1, 9], [2, 3], [5, 7] ]
        We can include at max two disjoint intervals: [[2, 3], [5, 7]]
     */

    public static void main(String[] args) {
        int[][] input = {{1,4},{2,3},{4,6},{8,9}};
        System.out.println(solve(input));// expect 3
    }

    /*
    Solution approach
    -> Sort the intervals, with respect to their end points.
    -> Now, traverse through all the intervals, if we get two overlapping intervals, then greedily choose the interval
       with lower end point since, choosing it will ensure that intervals further can be accommodated without any overlap.
    -> Apply the same procedure for all the intervals and return the count of intervals which satisfy the above criteria.
     */

    static class Pair {
        int start,end;
        public Pair(int s, int e){
            start = s;
            end = e;
        }
    }

    public static int solve(int[][] A) {

        int length = A.length;
        if (length<=1) return length;
        Pair[] pairs = new Pair[length];

        for(int i=0; i < length; i++){
            pairs[i] = new Pair(A[i][0],A[i][1]);
        }

        //sort by end time
        Arrays.sort(pairs, (s1, s2) -> {
            if(s1.end>s2.end) return 1;
            else if(s1.end<s2.end) return -1;
            else return 0;
        });


        //pick the one which finished first
        int count=1, endTime = pairs[0].end;

        // keep picking next possible- having startTime <= endtime
        for(int i=1;i<length;i++){
            if (pairs[i].start>endTime){
                count++;
                endTime = pairs[i].end;
            }
        }
        return count;
    }
}
