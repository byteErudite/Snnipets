package com.vaibhav.snippets.codingProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnyPermutationsDivisibleByEight {
    /*
    Given an array consisting of numbers in the form of string. For each number,
     find if any of its permutation is divisible by 8.
     */

    public static void main(String[] args) {
        String testString = "1354277";
        System.out.println(hasPermuatationDivisibleBy8(testString));
    }

    private static boolean hasPermuatationDivisibleBy8(String str) {
        char[] arr = str.toCharArray();
        Map<String, Integer> charToFreq = new HashMap<>();
        for(char c : arr) {
            charToFreq.put(String.valueOf(c), charToFreq.getOrDefault(c, 0)+1);
        }
        //any number ending with 000 is divisible by 8
        if (charToFreq.getOrDefault('0',0) >= 3) {
            return true;
        }


        for(int i= 8; i <=1000; i=i+8) {
            int num = i;
            Map<String,Integer> charToFreqLocal = new HashMap<>(charToFreq);
            boolean result = true;
            while(num >= 1) {
                int r = num%10;
                num = num/10;
                if (charToFreqLocal.getOrDefault(String.valueOf(r), 0) > 0) {
                    charToFreqLocal.put(String.valueOf(r), charToFreqLocal.get(String.valueOf(r))-1);
                } else {
                    result = false;
                    break;
                }
            }

            if (result) {
                System.out.println(i);
                return result;
            }
        }
        return false;
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<Pair> all = new ArrayList<>();

        g(A, 0, all);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int l = 0;
        while(true) {
            ArrayList<Integer> r = (ArrayList<Integer>) all.stream().filter(p -> p.level==l).map(p->p.val).collect(Collectors.toList());
            if(r.isEmpty()) {
                break;
            }
            result.add(r);
        }
        return result;
    }

    private void g(TreeNode A, int level, ArrayList<Pair> arr) {
        if(A== null) {
            return;
        }
        if(A.left != null) {
            arr.add(new Pair(A.left.val, level+1));
            g(A.left, level+1, arr);
        }
        if(A.right != null) {
            arr.add(new Pair(A.right.val, level+1));
            g(A.left, level+1, arr);
        }
    }

    class Pair {
        int val;
        int level;
        Pair(int val, int level) {
            this.val=val;
            this.level=level;
        }
    }
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
  }
}
