package com.vaibhav.snippets.codingProblems.SearchingSorting.binary_search;

public class Search2DMatrix {
    /**
     * You are given an m x n integer matrix matrix with the following two properties:
     *
     * Each row is sorted in non-decreasing order.
     * The first integer of each row is greater than the last integer of the previous row.
     * Given an integer target, return true if target is in matrix or false otherwise.
     *
     * You must write a solution in O(log(m * n)) time complexity.
     * @param args
     */



    public static void main(String[] args) {
        int[][] test1 = new int[][]{{1,3,5,7},{10,11,16,20}, {23,30,34,60}};
        System.out.println(searchMatrix(test1, 13));
        System.out.println(searchMatrix(test1, 16));
    }


    public static boolean searchMatrix(int[][] matrix, int target) {
        int rowToSearch = searchColumnWise(matrix, target, 0, matrix.length-1);
        if (rowToSearch == -1) {
            return false;
        }
        return searchRow(matrix, rowToSearch, target, 0, matrix[0].length-1);
    }

    public static int searchColumnWise(int[][] matrix, int target, int start, int end) {
        int mid = 0;

        while(start <= end ) {
            mid = start + (end-start)/2;

            if (matrix[mid][0] ==  target) {
                return mid;
            } else if (matrix[mid][0] > target) {
                end = mid - 1;
                if (mid - 1 >= 0 && matrix[mid - 1][0] <= target ) {
                    return mid - 1;
                }
            } else {
                start = mid + 1;
                if (mid + 1 < matrix.length && matrix[mid+1][0] >= target) {
                    start = mid +1;
                }
                if(mid + 1 >= matrix.length) {
                    return matrix.length-1;
                }
            }
        }
        return 0;
    }

    public static boolean searchRow(int[][] matrix, int row, int target, int start , int end) {
        int mid = 0;

        while(start <= end ) {
            mid = start + (end-start)/2;

            if (matrix[row][mid] ==  target) {
                return true;
            } else if (matrix[row][mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
