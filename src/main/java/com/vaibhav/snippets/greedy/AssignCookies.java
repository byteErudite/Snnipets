package com.vaibhav.snippets.greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class AssignCookies {
    /**
     *  You are given two arrays
     *  greed : {1, 3, 3, 4, 5}
     *  cookie: {1, 1, 2, 2, 3, 4}
     *
     *  ith value represents ith child's greed and ith cookie size
     *  each child can only be given one cookie
     *
     *  return maximum number of children that can be fed
     */

    public static void main(String[] args) {
        int[] greed = {1, 3, 3, 4, 5};
        int[] cookie = {1, 1, 2, 2, 3, 4};
        System.out.println(maxChildren(greed, cookie));
    }

    public static int maxChildren(int[] greed, int[] cookie) {
        Arrays.sort(greed);
        Arrays.sort(cookie);

        int i =0;
        int j= 0;

        while(i < cookie.length && j < greed.length) {
            if(cookie[i] >= greed[j]) {
                j++;
            }
            i++;
        }
        return j;
    }
}
