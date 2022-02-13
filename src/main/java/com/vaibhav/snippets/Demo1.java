package com.vaibhav.snippets;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo1 {
    public static void main(String[] args) {
        Integer a = null;
        System.out.println(String.valueOf(a));
        System.out.println(String.format("I am trying to print value : %b",null));

        ArrayList<String> r = new ArrayList<>();
        r.add("OOOXOOO");
        r.add("OOXXOXO");
        r.add("OXOOOXO");
        System.out.println(black(r));
    }

    public static int black(ArrayList<String> A) {
        char[][] input = new char[A.size()][A.get(0).length()];
        int row = 0;
        for(String s : A) {
            char[] arr = s.toCharArray();
            for(int col = 0 ; col < arr.length; col++) {
                input[row][col] = arr[col];
            }
            row++;
        }
        boolean[][] visited = new boolean[A.size()][A.get(0).length()];
        int count =0;
        for(int i = 0 ; i < input.length; i++) {
            for (int j = 0 ; j< input[0].length ; j++) {
                if(!visited[i][j] && input[i][j] == 'X') {
                    count++;
                    traverseBlack(input, visited, i, j, input.length, input[0].length);
                }
            }
        }
        return  count;
    }

    public static void traverseBlack(char[][] input, boolean[][] visited, int i, int j, int rowSize, int colSize) {
        visited[i][j] = true;
        if (i+1 < rowSize && !visited[i+1][j] &&  input[i+1][j] == 'X') {
            traverseBlack(input, visited, i+1, j, rowSize, colSize);
        }
        if (i-1 >= 0 && !visited[i-1][j] &&  input[i-1][j] == 'X') {
            traverseBlack(input, visited, i-1, j, rowSize, colSize);
        }
        if (j+1 < colSize && !visited[i][j+1] &&  input[i][j+1] == 'X') {
            traverseBlack(input, visited, i, j+1, rowSize, colSize);
        }
        if (j-1 >= 0 && !visited[i][j-1] &&  input[i][j-1] == 'X') {
            traverseBlack(input, visited, i, j-1, rowSize, colSize);
        }
    }
}
