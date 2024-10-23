package com.vaibhav.snippets.codingProblems.SearchingSorting;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1,7,9,14,21,99,107,677};
        System.out.println(binarySearch(arr, 0 , arr.length-1, 99));
        System.out.println(binarySearch(arr, 0 , arr.length-1, 107));
        System.out.println(binarySearch(arr, 0 , arr.length-1, 677));
    }

    public static int binarySearch(int[] arr , int start , int end, int target) {
        int mid = 0;
        while(start  <= end){
            mid = start + (end - start)/2 ;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid]> target) {
                end = mid  -1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


}
