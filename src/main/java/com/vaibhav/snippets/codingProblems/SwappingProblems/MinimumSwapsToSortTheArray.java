package com.vaibhav.snippets.codingProblems.SwappingProblems;

public class MinimumSwapsToSortTheArray {

    /**You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates. You are allowed to swap any two elements. Find the minimum number of swaps required to sort the array in ascending order.

     Example


     Perform the following steps:

     i   arr                         swap (indices)
     0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
     1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
     2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
     3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
     4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
     5   [1, 2, 3, 4, 5, 6, 7]
     It took  swaps to sort the array.

     Function Description

     Complete the function minimumSwaps in the editor below.

     minimumSwaps has the following parameter(s):

     int arr[n]: an unordered array of integers
     Returns

     int: the minimum number of swaps to sort the array
     Input Format

     The first line contains an integer, , the size of .
     The second line contains  space-separated integers .

     Constraints

     Sample Input 0

     4
     4 3 1 2
     Sample Output 0

     3
     *
     * @param arr
     * @return
     */
    static int minimumSwaps(int[] arr) {
        boolean[] visited = new boolean[arr.length];
        int swaps = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            if(!visited[i] && arr[i] != i+1) {
                int j = arr[i];
                visited[i] = true;
                while(!visited[j-1]) {
                    swaps++;
                    visited[j-1] = true;
                    j = arr[j-1];

                }
            }
        }
        return swaps;

    }
}
