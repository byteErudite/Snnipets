package com.vaibhav.snippets.codingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
//        Integer[] firstArray = {2,9,10,19,20,54};
//        Integer[] secondArray = {3,8,11,15,20,88};
//        System.out.println(findCommon(Arrays.asList(firstArray), Arrays.asList(secondArray)));
        String test1 = "Assadrfa";
        String test2 = "";
        String test3 = "assgaregre";
        System.out.println(test1+"->"+canFormPalindrome(test1));
        System.out.println(test2+"->"+canFormPalindrome(test2));
        System.out.println(test3+"->"+canFormPalindrome(test3));
        Test tt = new Test();
       tt.t();
    }

    public void t() {
        A a1 = new A();

        A a2 = new A();

        System.out.println("a1 ->"+a1.hashCode() +"     a2 -> "+a2.hashCode());
        a2=a1;
        System.out.println("a1 ->"+a1.hashCode() +"     a2 -> "+a2.hashCode());
    }

    public static boolean canFormPalindrome(String str) {
        char[] characters = str.toCharArray();
        HashMap<Character,Integer> characterCount = new HashMap<>();
        for(char c : characters) {
            characterCount.put(c, characterCount.getOrDefault(c, 0)+1);
        }
        int oddOccurences = 0;
        for(int occurences : characterCount.values()) {
            if (occurences % 2 != 0) {
                oddOccurences++;
            }
        }
        return oddOccurences <= 1 ;
    }

    public static List<Integer> findCommon(List<Integer> A, List<Integer> B) {
        if (A.size() == 0 || B.size() ==0) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> count = new HashMap<>();
        for(int value : A) {
            count.put(value, count.getOrDefault(value, 0)+1);
        }
        for (int value : B) {
            if(count.containsKey(value)) {
                if(count.get(value) >= 1) {
                    result.add(value);
                    count.put(value,count.get(value)-1);
                }
            }

        }
        return result;
    }
    class   A {
        int a;
    }

    class  B extends  A {


    }
}


