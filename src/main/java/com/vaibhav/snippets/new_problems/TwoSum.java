package com.vaibhav.snippets.new_problems;

import java.util.*;

public class TwoSum {
    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * <p>
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * <p>
     * You can return the answer in any order.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     * Example 2:
     * <p>
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     * Example 3:
     * <p>
     * Input: nums = [3,3], target = 6
     * Output: [0,1]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 2 <= nums.length <= 104
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     * Only one valid answer exists.
     **/

    public static void main(String[] args) {
        int[] nums = new int[] {2,7,11,15};
        int[] result = twoSum_2(nums, 9);
        System.out.println(result[0] + " , " + result[1]);
    }
    public static int[] twoSum_1(int[] nums, int target) {
        // Solution logic : Create a class that can hold both the value and index
        // Create a list of that class and sort it by num values
        // use narrowing window search on the sorted list , and return the index when solution if found
        int[] result = new int[2];
        List<NumAndIndex> data = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            data.add(new NumAndIndex(nums[i], i));
        }

        Comparator<NumAndIndex> byNum = (data1, data2) -> data1.num > data2.num ? 1 : -1;
        data.sort(byNum);

        int start = 0;
        int end = data.size()-1;

        while (start < end) {
            int sum = data.get(start).num + data.get(end).num;
            if (sum < target) {
                start++;
            } else if (sum > target) {
                end--;
            } else {
                result[0] = data.get(start).getIndex();
                result[1] = data.get(end).getIndex();
                return result;
            }
        }
        return result;
    }

    public static int[] twoSum_2(int[] nums, int target) {
        Map<Integer, Integer> numByIndex = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0 ; i< nums.length ; i++) {
            int compliment = target - nums[i];
            if(numByIndex.containsKey(compliment)) {
                result[0] = i;
                result[1] = numByIndex.get(compliment);
                return result;
            } else {
                numByIndex.put(nums[i], i);
            }
        }
        return result;
    }

    static class NumAndIndex {
        private int num;
        private int index;

        public int getNum() {
            return this.num;
        }

        public int getIndex() {
            return this.index;
        }

        NumAndIndex(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }
}
