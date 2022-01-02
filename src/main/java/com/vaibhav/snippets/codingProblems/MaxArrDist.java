package com.vaibhav.snippets.codingProblems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class MaxArrDist {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static int maximumGap(final List<Integer> input) {
        int n = input.size();
        ArrayDeque<Integer> A = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            if(A.isEmpty()||input.get(A.peekLast())>=input.get(i)){
                A.add(i);
            }
        }
        int ans = 0;
        for(int i= n-1; i >= 0; i--){
            while(!A.isEmpty()&&input.get(i)>=input.get(A.peekLast())){
                ans = Math.max(ans,i-A.pollLast());
            }
        }
        return ans;
    }

    public int maximumGap2(final List<Integer> A) {
        int maxDiff;
        int i, j;

        int n = A.size();
        int RMax[] = new int[n];
        int LMin[] = new int[n];

        LMin[0] = A.get(0);

        for (i = 1; i < n; ++i) {
            LMin[i] = Math.min(A.get(i), LMin[i - 1]);
        }

        RMax[n - 1] = A.get(n - 1);
        for (j = n - 2; j >= 0; --j) {
            RMax[j] = Math.max(A.get(j), RMax[j + 1]);
        }

        i = 0; j = 0; maxDiff = 0;
        while (j < n && i < n) {
            if (LMin[i] <= RMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            }
            else {
                i++;
            }
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 5, 4, 2};
        System.out.println(maximumGap(Arrays.asList(arr))); // expect 2
    }
}
