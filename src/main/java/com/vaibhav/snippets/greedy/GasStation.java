package com.vaibhav.snippets.greedy;

import java.util.Arrays;
import java.util.List;

public class GasStation {

    /*
    Given two integer arrays A and B of size N.

    There are N gas stations along a circular route, where the amount of gas at station i is A[i].

    You have a car with an unlimited gas tank and it costs B[i] of gas to travel from station i

    to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

    Return the minimum starting gas station’s index if you can travel around the circuit once, otherwise return -1.

    You can only travel in one direction. i to i+1, i+2, … n-1, 0, 1, 2.. Completing the circuit means starting at i and

    ending up at i again.




    Input Format

    The first argument given is the integer array A.
    The second argument given is the integer array B.
    Output Format

    Return the minimum starting gas station's index if you can travel around the circuit once, otherwise return -1.
    For Example

    Input 1:
        A =  [1, 2]
        B =  [2, 1]
    Output 1:
        1
        Explanation 1:
            If you start from index 0, you can fill in A[0] = 1 amount of gas. Now your tank has 1 unit of gas. But you need B[0] = 2 gas to travel to station 1.
            If you start from index 1, you can fill in A[1] = 2 amount of gas. Now your tank has 2 units of gas. You need B[1] = 1 gas to get to station 0. So, you travel to station 0 and still have 1 unit of gas left over. You fill in A[0] = 1 unit of additional gas, making your current gas = 2. It costs you B[0] = 2 to get to station 1, which you do and complete the circuit.
     */

    public static void main(String[] args) {
        Integer[] gasArray = {1, 2};
        Integer[] costArray = {2, 1};
        System.out.println(canCompleteCircuit(Arrays.asList(gasArray), Arrays.asList(costArray)));
        System.out.println(canCompleteCircuit_MySolution(Arrays.asList(gasArray), Arrays.asList(costArray)));
    }

    public static int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
        int currentFuel = 0;
        int remaining = 0;
        int total = 0;
        int start = 0;
        for(int i = 0; i < gas.size(); i++){
            remaining = gas.get(i) - cost.get(i);
            if(currentFuel >= 0)
                currentFuel += remaining;
            else{
                currentFuel = remaining;
                start = i;
            }
            total += remaining;
        }
        return total >= 0 ? start : -1;
    }

    public static int canCompleteCircuit_MySolution(final List<Integer> A, final List<Integer> B) {
        int minFuelRequired = 0;
        int fuelSum = 0;
        int[] surplus = new int[A.size()];
        for(int i = 0 ; i< A.size() ; i++) {
            int currentStationFuel = A.get(i);
            int fuelRequiredForNext = B.get(i);
            if (currentStationFuel - fuelRequiredForNext >= 0) {
                if(canBeAStartingPoint(i, A, B)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static boolean canBeAStartingPoint(int currentIndex, List<Integer> A, List<Integer> B) {
        int trev = 0;
        int fuelSum = 0;
        while(trev < A.size() ) {
            int ind = (currentIndex >= A.size()) ?  currentIndex % A.size() : currentIndex;
            fuelSum = fuelSum + A.get(ind) - B.get(ind);
            if (fuelSum < 0) {
                return false;
            }
            currentIndex++;
            trev++;
        }
        return true;
    }
}
