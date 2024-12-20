package com.vaibhav.snippets.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class HotelBookingPossible {
    /*
    A hotel manager has to process N advance bookings of rooms for the next season. His hotel has C rooms.
     Bookings contain an arrival date and a departure date. He wants to find out whether there are enough rooms
      in the hotel to satisfy the demand. Write a program that solves this problem in time O(N log N) .

    Input Format
    First argument is an integer array A containing arrival time of booking.
    Second argument is an integer array B containing departure time of booking.
    Third argument is an integer C denoting the count of rooms.

    Output Format
    Return True if there are enough rooms for N bookings else return False.
    Return 0/1 for C programs.



    Example Input  A = [1, 3, 5]   Output : 0 (At day = 5, there are 2 guests in the hotel. But I have only one room)
                   B = [2, 6, 8]
                   C = 1
     */

    public static void main(String[] args) {
        hotel(null, null, 5);
    }
    public static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        TreeSet<Integer> set = new TreeSet<>();
        int sum = 0;

        for(int i = 0 ; i < 5 ; i++) {
            sum += 5;
        }
        System.out.println(sum);
        Collections.sort(arrive);
        Collections.sort(depart);
        int roomsRequired=0,i=0,j=0;
        // we will increase roomRequired whenever a guest arrives and decrease whenever he leaves
        // if at any point in between roomRequired exceeds available number of rooms then return false
        while(i<arrive.size()  && j<arrive.size() && roomsRequired<=K){
            if(arrive.get(i)<depart.get(j) ){
                i++;
                roomsRequired++;
            }else{
                j++;
                roomsRequired--;
            }
        }
        if(roomsRequired<=K){
            return true;
        }else{
            return false;
        }
    }
}
