package com.vaibhav.snippets.codingProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinCostToSitAllTogether {
    final static int mod = 10000003;
    public static void main(String[] args) {
        String test1 = "....x..xx...x..";//5
        String test2 = "x.x.xx.x.xxx.......x..x.xxx..x.xxx";//102;
//        System.out.println(seats(test2));
        System.out.println(seatsEditorial(test2));

    }
    public static int seats(String A) {

        char[] arr = A.toCharArray();
        int startingPerson = Integer.MAX_VALUE;
        int endingPerson = Integer.MIN_VALUE;
        List<Integer> indexWithPeople = new ArrayList<>();

        //find median index around which we will move all other 'x'
        for(int i =0; i< arr.length ; i++) {
            if(arr[i] == 'x') {
                if(i < startingPerson) {
                    startingPerson = i;
                }
                if(i > endingPerson) {
                    endingPerson = i;
                }
                indexWithPeople.add(i);
            }
        }
        int median = (indexWithPeople.size())/ 2;
        int medianIndex = indexWithPeople.get(median);
        int cost = 0;
        cost  = cost + countCostLeft(medianIndex, startingPerson, arr);
        cost = cost + countCostRight(medianIndex, endingPerson, arr);
        return cost;
    }

    private static int countCostLeft(int gatherIndex, int leftMostPerson, char[] arr) {
        int i = leftMostPerson;
        int j = gatherIndex-1;
        int cost = 0;
        while(i < j && i>=0 && j <arr.length) {
            if (arr[i] == 'x' && arr[j] == '.') {
                cost = (cost + (j-i))%mod;
                i++;
                j--;
            } else if(arr[j] == 'x') {
                j--;
            }
            else if(arr[i] == '.' && arr[j] == '.') {
                i++;
            }
            int b=10;
        }
        return cost;
    }

    private static int countCostRight(int gatherIndex, int rightMostPerson, char[] arr) {
        int i = gatherIndex + 1;
        int j = rightMostPerson;
        int cost =0;
        while(i < j && i>=0 && j <arr.length) {
            if (arr[i] == '.' && arr[j] == 'x') {
                cost = cost + (j-i);
                i++;
                j--;
            } else if(arr[i] == 'x' && arr[j] == 'x') {
                i++;
            }
            else if(arr[j] == '.') {
                j--;
            }
            int b=10;
        }
        return cost;
    }

    public static int seatsEditorial(String A) {
        int i = 0, j = A.length()-1;
        int count = 0;
        int MOD = 10000003;
        int n = 0;
        int diffi = 0, diffj = 0;
        while(i <= j){
            while(i <= j && A.charAt(i) != 'x')
                i++;
            //System.out.println(i + " " + diffi);
            if(n != 0){
                count += ((i-diffi)*n)%MOD;
                count %=MOD;
            }
            i++;
            while(i <= j && A.charAt(j) != 'x')
                j--;
            // System.out.println(j + " " + diffj);
            if(n != 0){
                count += ((diffj-j)*n)%MOD;
                count %=MOD;
            }
            j--;
            n++;
            diffi = i;
            diffj = j;
        }
        return count;
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        Set<Integer> setC = new HashSet<>();
        Set<Integer> wholeSet = new HashSet<>();
        for(int val : A) {
            setA.add(val);
            wholeSet.add(val);
        }
        for(int val : B) {
            setB.add(val);
            wholeSet.add(val);
        }
        for(int val : C) {
            setC.add(val);
            wholeSet.add(val);
        }
        ArrayList<Integer> finalValues = new ArrayList<>();

        for(int val : wholeSet) {
            if((setA.contains(val) && setB.contains(val)) ||
                    (setB.contains(val) && setC.contains(val)) ||
                    (setA.contains(val) && setC.contains(val))) {
                finalValues.add(val);
            }
        }
        Collections.sort(finalValues);
        return finalValues;
    }
}
