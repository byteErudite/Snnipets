package com.vaibhav.snippets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo1 {
    public static void main(String[] args) {

       List<Integer> arr1 = Arrays.asList(2, 1, 8, 9, 5);
       List<Integer> arr2 = Arrays.asList(6, 7, 6, 7, 4, 1, 3, 0, 1, 8);
        System.out.println(addArrays(arr1, arr2));

    }

    public static ArrayList<Integer> addArrays(List<Integer> A, List<Integer> B) {
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
            answer.add(A.get(i--));
        }
        while(j >= 0) {
            answer.add(B.get(j--));
        }
        Collections.reverse(answer);
        return answer;
    }

}
