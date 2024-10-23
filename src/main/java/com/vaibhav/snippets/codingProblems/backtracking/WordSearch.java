package com.vaibhav.snippets.codingProblems.backtracking;

public class WordSearch {
    /**
     * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
     *
     * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
     * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * Output: true
     *
     * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
     * Output: true
     *
     * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
     * Output: false
     *
     *
     *
     * Main thing to in this question is , marking a block as visited by changing its value
     * before going to its neighbours to explore the path , like in code assignment to '#'
     * This value will again be assigned to original board value once the code backtrack from the neighbours and is not successfull
     */



    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i =0 ; i<board.length ;i++) {
            for(int j =0; j < board[0].length ; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                if (isExist(board, words, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isExist(char[][] board, char[] word, int currIndex, int i, int j, boolean[][] visited) {
        if (i >= board.length || j >= board[0].length || i < 0 || j <0 || currIndex >= word.length || board[i][j] != word[currIndex] ) {
            return false;
        }
        char t = board[i][j];
        board[i][j] = '#';
        if (currIndex >= word.length-1 ) {
            return true;
        }

        if(isExist(board, word, currIndex+1, i-1, j, visited) ||
                isExist(board, word, currIndex+1, i+1, j, visited) ||
                isExist(board, word, currIndex+1, i, j-1, visited) ||
                isExist(board, word, currIndex+1, i, j+1, visited)) {
            return true;
        }
        board[i][j] = t;
        return false;

    }
}
