package com.vaibhav.snippets.codingProblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {2,3,5};
        System.out.println(combinationSum(arr, 8));
    }

    public static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        result.clear();
        Set<Integer> candidateSet = new HashSet<>();
        populateCombinationSum(candidates, target, new ArrayList<Integer>(), candidates.length-1, candidateSet);
        return result;
    }

    private static void populateCombinationSum(int[] candidates, int target, List<Integer> values, int currentLen, Set<Integer> candidateSet)      {
        if (target < 0 || currentLen < 0) {
            return;
        }
        if (target  == 0) {
            result.add(values);
            return;
        }
        if (!candidateSet.contains(target)) {
            List<Integer> producibleCandidates = getProducibleCandidates(candidates, target);
            if (producibleCandidates.size() > 0) {
                for(int producibleCandidate : producibleCandidates) {
                    candidateSet.add(target);
                    int occurencesOfProducibleCandidate = target / producibleCandidate;
                    List<Integer> resultSet = new ArrayList<>(values);
                    while(occurencesOfProducibleCandidate-- > 0) {
                        resultSet.add(producibleCandidate);
                    }
                    result.add(resultSet);
                }
            }
        }



        List<Integer> valuesWithoutSelection = new ArrayList<>(values);
        populateCombinationSum(candidates, target,valuesWithoutSelection, currentLen-1, candidateSet);
        List<Integer> valuesWithSelection = new ArrayList<>(values);
        valuesWithSelection.add(candidates[currentLen]);
        populateCombinationSum(candidates, target - candidates[currentLen], valuesWithSelection, currentLen-1, candidateSet);
    }

    private static List<Integer> getProducibleCandidates(int[] candidates, int target) {
        List<Integer> solutions = new ArrayList<>();
        for(int candidate : candidates) {
            if (target % candidate == 0) {
                solutions.add(candidate);
            }
        }
        return solutions;
    }
}
