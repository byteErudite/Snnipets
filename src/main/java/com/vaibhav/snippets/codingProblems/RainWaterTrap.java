package com.vaibhav.snippets.codingProblems;

import java.util.List;

public class RainWaterTrap {

    public static void main(String[] args) {
        int[] A = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(A, 12));
    }

    static int trap(int A[], int n) {
        int left = 0; int right = n - 1;
        int res = 0;
        int maxleft = 0, maxright = 0;
        while(left <= right){
            if(A[left] <= A[right]){
                if(A[left] >= maxleft) maxleft = A[left];
                else res += maxleft-A[left];
                left++;
            }
            else{
                if(A[right] >= maxright) maxright = A[right];
                else res += maxright - A[right];
                right--;
            }
        }
        return res;
    }

    public int trap(final List<Integer> A) {
        int ans = 0;
        int left = 0;
        int right = A.size() - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            if (A.get(left) < A.get(right)) {
                if (A.get(left) > leftMax) {
                    leftMax = A.get(left);
                }
                else {
                    ans += leftMax - A.get(left);
                }
                left++;
            }
            else {
                if (A.get(right) > rightMax) {
                    rightMax = A.get(right);
                }
                else {
                    ans += rightMax - A.get(right);
                }
                right--;
            }
        }
        return ans;
    }
}
