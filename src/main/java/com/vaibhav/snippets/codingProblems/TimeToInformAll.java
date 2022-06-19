package com.vaibhav.snippets.codingProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeToInformAll {
    public static void main(String[] args) {
        int[] manager = {2, 2, -1, 2, 2, 2};
        int[] informTime = {0, 0, 1, 0, 0, 0};
        System.out.println(numOfMinutes(6, 2, manager, informTime));
    }

    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> managerToEmployees = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] == -1) {
                continue;
            }
            List<Integer> employees = managerToEmployees.containsKey(manager[i]) ? managerToEmployees.get(manager[i]) : new ArrayList<>();
            employees.add(i);
            managerToEmployees.put(manager[i], employees);
        }
        return findMaxInfoTime(0, headID, managerToEmployees, informTime);
    }

    private static int findMaxInfoTime(int timeSpent, int currentEmployee, Map<Integer, List<Integer>> managerToEmployees, int[] informTime) {
        if (!managerToEmployees.containsKey(currentEmployee)) {
            return timeSpent;
        }
        int maxTimeSpent = Integer.MIN_VALUE;
        for (int employee : managerToEmployees.get(currentEmployee)) {
            maxTimeSpent = Math.max(maxTimeSpent, findMaxInfoTime(informTime[currentEmployee] + timeSpent, employee, managerToEmployees, informTime));
        }
        return maxTimeSpent;
    }
}
