package com.vaibhav.snippets.codingProblems;

import java.util.LinkedList;
import java.util.Queue;

public class KnightOnChessBoard {
    public static void main(String[] args) {
        System.out.println(knight(8, 8, 1, 1, 8, 8));

    }

    public int knight_scaler(int N, int M, int x1, int y1, int x2, int y2) {
        // The 8 positions a knight could move to for the current position.
        int[] dx = {-1, -2, -1, -2, 1, 2, 1, 2};
        int[] dy = {-2, -1, 2, 1, -2, -1, 2, 1};
        boolean[][] isVisited = new boolean[N + 1][M + 1];
        Queue<Coordinate> queue = new LinkedList<Coordinate>();
        queue.add(new Coordinate(x1, y1));
        isVisited[x1][y1] = true;
        int moveCount = 0;

        // BFS to find the minimum number of steps.
        while (!queue.isEmpty()) {
            int nodesAtCurrentBreadth = queue.size();
            // Iterate over the coordinates at current breadth, as moveCount would be
            // incremented by 1 per breadth level.
            for (int count = 0; count < nodesAtCurrentBreadth; count++) {
                Coordinate currPos = queue.remove();
                if (currPos.x == x2 && currPos.y == y2) {
                    return moveCount;
                }

                for (int i = 0; i < dx.length; i++) {
                    if (isValid(currPos.x + dx[i], currPos.y + dy[i], N, M) && isVisited[currPos.x + dx[i]][currPos.y + dy[i]] == false) {
                        queue.add(new Coordinate(currPos.x + dx[i], currPos.y + dy[i]));
                        isVisited[currPos.x + dx[i]][currPos.y + dy[i]] = true;
                    }
                }
            }
            moveCount++;
        }

        return -1;
    }

    private boolean isValid(int x, int y, int N, int M) {
        if (x <= 0 || y <= 0 || x > N || y > M) {
            return false;
        }
        return true;
    }



    public static int knight(int A, int B, int C, int D, int E, int F) {
        boolean[][] visited = new boolean[A + 1][B + 1];
        int steps = canReachPoint(C, D, E, F, A, B, visited, 0);
        if (steps == Integer.MAX_VALUE) {
            return -1;
        }
        return steps;
    }

    private static int canReachPoint(int x, int y, int m, int n, int rowMax, int colMax, boolean[][] visited, int step) {
        if (x > rowMax || y > colMax || x < 0 || y < 0 || visited[x][y]) {
            return Integer.MAX_VALUE;
        }

        visited[x][y] = true;
        if (x == m && y == n) {
            return step;
        }

        return min(canReachPoint(x + 2, y + 1, m, n, rowMax, colMax, visited, step + 1),
                canReachPoint(x + 2, y - 1, m, n, rowMax, colMax, visited, step + 1),
                canReachPoint(x - 2, y + 1, m, n, rowMax, colMax, visited, step + 1),
                canReachPoint(x - 2, y - 1, m, n, rowMax, colMax, visited, step + 1),
                canReachPoint(x + 1, y + 2, m, n, rowMax, colMax, visited, step + 1),
                canReachPoint(x - 1, y + 2, m, n, rowMax, colMax, visited, step + 1),
                canReachPoint(x + 1, y - 2, m, n, rowMax, colMax, visited, step + 1),
                canReachPoint(x - 1, y - 2, m, n, rowMax, colMax, visited, step + 1));
    }

    private static int min(int a, int b, int c, int d, int e, int f, int g, int h) {
        int r1 = a < b ? a : b;
        int r2 = c < d ? c : d;
        int r3 = e < f ? e : f;
        int r4 = g < h ? g : h;
        int r12 = r1 < r2 ? r1 : r2;
        int r34 = r3 < r4 ? r3 : r4;
        return r12 < r34 ? r12 : r34;
    }
}

class Coordinate {
    int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
