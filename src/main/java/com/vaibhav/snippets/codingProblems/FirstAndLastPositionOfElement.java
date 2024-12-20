package com.vaibhav.snippets.codingProblems;

import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FirstAndLastPositionOfElement {

    public static void main(String[] args) {
        /*
        Find the begin and ending of target values index in a sorted array
         */
        FirstAndLastPositionOfElement instance = new FirstAndLastPositionOfElement();
        int[] nums = {5,7,7,7,7,7,7,8,8,10};
        instance.searchRange(nums, 7);
       // List<List<Integer>> finalResult = new ArrayList<>();
      //  finalResult.addAll(IntStream.of(new int[]{}).boxed().collect(Collectors.toCollection(ArrayList::new));)
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = binarySearchLeftMost(nums, target, 0, nums.length-1);
        if (result[0] == -1) {
            result[1] = -1;
        } else {
            result[1] = binarySearchRightMost(nums, target, 0, nums.length-1);
        }
        System.out.println("Begin index : " + result[0]);
        System.out.println("End index : " + result[1]);
        return result;
    }

    private int binarySearchLeftMost(int[] nums, int target, int begin, int end) {
        if (begin <= end) {
            int middle = (end + begin) / 2;
            if (nums[middle] == target) {
                int resultInLeftArray = binarySearchLeftMost(nums, target, begin , middle-1);
                return  resultInLeftArray== -1 ? middle : resultInLeftArray;
            } else if (nums[middle] > target) {
                return binarySearchLeftMost(nums, target, begin , middle-1);
            } else if (nums[middle] < target) {
                return binarySearchLeftMost(nums, target, middle+ 1 , end);
            }
        }
        return -1;
    }

    private int binarySearchRightMost(int[] nums, int target, int begin, int end) {
        if (begin <= end) {
            int middle = (end + begin) / 2;
            if (nums[middle] == target) {
                int resultInRightArray = binarySearchRightMost(nums, target, middle+ 1 , end);
                return  resultInRightArray== -1 ? middle : resultInRightArray;
            } else if (nums[middle] > target) {
                return binarySearchRightMost(nums, target, begin , middle-1);
            } else {
                return binarySearchRightMost(nums, target, middle+ 1 , end);
            }
        }
        return -1;
    }
}
