package com.vaibhav.snippets.codingProblems;

import java.util.ArrayList;
import java.util.HashMap;

public class CollinearPoints {
    /*
    Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

    Sample Input :

    (1, 1)
    (2, 2)
    Sample Output :

    2
    You will be given 2 arrays X and Y. Each point is represented by (X[i], Y[i])
     */

    public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        if(a.size() == 0){
            return 0;
        }
        if(a.size() == 1 && b.size() == 1){
            return 1;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<a.size(); i++) {
            int x1 = a.get(i) ;
            int y1 = b.get(i) ;
            // not global because we want to avoid extra addition.
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            int samePoint = 1;
            int infValue = 0;
            for(int j = i+1; j<a.size(); j++) {
                int x2 = a.get(j) ;
                int y2 = b.get(j) ;
                if((x1 == x2)&&(y1==y2)) {
                    samePoint += 1;
                } else if(x2 - x1 == 0) {
                    infValue++;
                } else {
                    double slope = 0.0;
                    if(y1 != y2) {
                        slope = (double)(y2-y1)/(double)(x2-x1);
                    }
                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                }
            }
            if((infValue + samePoint)  > max) {
                max = infValue+samePoint;
            }

            for(Integer value : map.values() ){
                max = Math.max(value+samePoint, max);
            }
        }
        return max;
    }
}
