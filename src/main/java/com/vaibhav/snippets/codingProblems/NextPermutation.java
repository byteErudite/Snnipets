package com.vaibhav.snippets.codingProblems;

import java.util.ArrayList;
import java.util.Collections;

public class NextPermutation {
    /*
        Algorithm
        Step-1 : Start from the end and find the first element that satisfies a[i] < a[i-1]
        Step-2 : Start from end and find first element greater than element found in step-1
        Step-3 : Swap elements found in step-1 &  step-2
        Step-4 : Reverse all sequence after element of step-1

        e.g-> input : 13542  output : 14235
        Step-1 : element found -> 3 at index 1 (if no element found => highest permutation => sort list  and return it)
        Step-2 : element found -> 4 at index 3
        Step-3 : Swap elements at index 1 & 3 -> 14532
        Step-4 : Reverse all sequence after index 1 : 14'532' -> 14235
         */
    public void nextPermutation(ArrayList<Integer> a) {

        int n = a.size();
        int index = -1;

        //Step-1
        for (int i = n-1; i > 0; i--) {
            if (a.get(i) > a.get(i-1)) {
                index = i-1;
                break;
            }
        }

        if (index == -1) {
            Collections.sort(a);
        }
        else {
            //Step-2
            int swapWithIndex = -1;
            for(int j = n-1; j >index; j--) {
                if (a.get(j) > a.get(index)) {
                    swapWithIndex = j;
                    break;
                }
            }

            //Step-1
            int temp = a.get(index);
            a.set(index, a.get(swapWithIndex));
            a.set(swapWithIndex, temp);
            //Step-4
            Collections.sort(a.subList(index+1, n));
        }
    }



    //brute force
    public void nextPermutation(int[] nums) {
        StringBuilder s = new StringBuilder();
        for(int num : nums) {
            s.append(num);
        }
        ArrayList<String> permutations = new  ArrayList<>();
        permute(s.toString(), 0, s.toString().length()-1, permutations);
        Collections.sort(permutations);
        int i=0;
        int resultIndex = 0;
        for(String p : permutations) {
            if (p.equals(s.toString())) {
                resultIndex = i;
            }
            i++;
        }

        resultIndex = (resultIndex == permutations.size() -1) ? 0 : resultIndex + 1;
        char[] result = permutations.get(resultIndex).toCharArray();
        for(int k = 0; k < result.length; k++) {
            nums[k] = Character.getNumericValue(result[k]);
        }
    }

    private void permute(String str, int l, int r, ArrayList<String> permutations)
    {
        if (l == r)
            permutations.add(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r, permutations);
                str = swap(str,l,i);
            }
        }
    }

    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
