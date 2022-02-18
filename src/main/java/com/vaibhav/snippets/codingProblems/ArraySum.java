package com.vaibhav.snippets.codingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArraySum {

    /*
    You are given two numbers represented as integer arrays A and B, where each digit is an element.
    You have to return an array which representing the sum of the two given numbers.
    The last element denotes the least significant bit, and the first element denotes the most significant bit.

    Example Input
    Input 1:           Output 1:
    A = [1, 2, 3]      [3, 7, 8]
    B = [2, 5, 5]
    Input 2:
    A = [9, 9, 1]      [1, 1, 1, 2]
    B = [1, 2, 1]

     */

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(2, 5, 5));
        System.out.println(addArrays(A,B));// expect [3, 7, 8]
    }
    public static ArrayList<Integer> addArrays(ArrayList<Integer> A, ArrayList<Integer> B) {
        int carr =0;
        int i = A.size()-1;
        int j = B.size()-1;
        ArrayList<Integer> answer = new ArrayList<>();
        do {
            int num = A.get(i) + B.get(j) + carr;
            carr = num/ 10;
            int val = num %10;
            answer.add(val);
            i--;
            j--;
        }while(i >= 0 && j >= 0) ;

        while(i >=0) {
            int num = A.get(i) + carr;
            carr = num/ 10;
            int val = num %10;
            answer.add(val);
            i--;
        }
        while(j >= 0) {
            int num = B.get(j) + carr;
            carr = num/ 10;
            int val = num %10;
            answer.add(val);
            j--;
        }
        if(carr == 1) {
            answer.add(1);
        }
        Collections.reverse(answer);
        return answer;
    }
}
