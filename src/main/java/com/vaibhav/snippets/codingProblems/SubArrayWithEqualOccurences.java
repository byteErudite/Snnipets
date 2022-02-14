package com.vaibhav.snippets.codingProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArrayWithEqualOccurences {
    /*
    Given an integer array A and two integers B and C.

    You need to find the number of sub-arrays in which the number of occurrences of B is equal to number of occurrences of C.

    Input 1: A = [1, 2, 1]
         B = 1
         C = 2
        Output 1:
        2
     */
    public static void main(String[] args) {
       ArrayList<Integer> arr = new ArrayList<>();
       arr.add(1);
       arr.add(2);
       arr.add(1);
        System.out.println(solve(arr, 1, 2));
    }
    public static int solve(ArrayList<Integer> A, int B, int C)
    {
        int N=A.size();

        int []countB=new int[N];
        int []countC=new int[N];

        if(A.get(0)==B)
            countB[0]=1;

        if(A.get(0)==C)
            countC[0]=1;

        for(int i=1;i<N;i++)
        {
            if(A.get(i)==B)
                countB[i]=countB[i-1]+1;
            else
                countB[i]=countB[i-1];

            if(A.get(i)==C)
                countC[i]=countC[i-1]+1;
            else
                countC[i]=countC[i-1];
        }

        int result=0;

        for(int i=0;i<N;i++)
        {
            int c1=countB[i],c2=countC[i];

            for(int j=0;j<=i;j++)
            {
                if(c1==c2)
                    result++;

                if(A.get(j)==B)
                    c1--;

                if(A.get(j)==C)
                    c2--;
            }
        }

        return result;
    }
}
