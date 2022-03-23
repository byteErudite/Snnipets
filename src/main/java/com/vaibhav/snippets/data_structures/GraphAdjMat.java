package com.vaibhav.snippets.data_structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphAdjMat {
    public static void main(String[] args) {
        AdjGraph graph = new AdjGraph(7);
        graph.addEdge(1,2, 5);
        graph.addEdge(2,3, 7);
        graph.addEdge(3,4, 2);
        graph.addEdge(2,5, 8);
        graph.addEdge(5,6, 9);
        graph.addEdge(4, 6, 55);
        graph.traverseBfs(1);
        graph.traverseDfs(1);
        System.out.println(graph.findPath(1,6));
        System.out.println(graph.findMinPath(1,6));
    }
}

class AdjGraph {
    private int[][] nodes;
    private int vertices;

    AdjGraph(int vertices) {
        this.vertices = vertices;
        nodes = new int[vertices+1][vertices+1];
        for(int i = 0 ; i<vertices+1 ; i++) {
            Arrays.fill(nodes[i], -1);
        }
    }

    public void addEdge(int u , int v, int w) {
        nodes[u][v] = w;
        nodes[v][u] = w;
    }

    public void traverseBfs(int startNode) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);
        boolean[] visited = new boolean[vertices+1];
        while(!q.isEmpty()) {
            int node = q.poll();
            if (!visited[node]) {
                visited[node] = true;
                System.out.println(node);
                for (int i =0; i< vertices; i++) {
                    if (nodes[node][i] != -1) {
                       q.add(i);
                    }
                }
            }
        }
    }

    public void traverseDfs(int start) {
        boolean[] visited = new boolean[vertices+1];
        dfs(start, visited);
    }

    public void dfs(int start, boolean[] visited) {
        if (visited[start]) {
            return;
        }
        visited[start] = true;
        System.out.println(start);
        for(int i = 0 ; i< vertices+1; i++) {
            if (nodes[start][i] != -1) {
                dfs(i, visited);
            }
        }
    }


    public List<String> findPath(int start, int target) {
        List<String> paths = new ArrayList<>();
        findPathUtil(start, new boolean[vertices+1], target, String.valueOf(start), paths);
        return paths;
    }
    public void findPathUtil(int start, boolean[] visited, int target, String path, List<String> paths) {
        if (visited[start]) {
            return;
        }
        visited[start] = true;
        if (start == target) {
            paths.add(path);
            return;
        }

        for(int i = 0 ; i< vertices+1; i++) {
            if (nodes[start][i] != -1) {
                String newPath = path + i;
                boolean[] vis = Arrays.copyOf(visited, visited.length);
                findPathUtil(i, vis, target, newPath, paths);
            }
        }
    }

    public int findMinPath(int start, int target) {
        return findMinPathUtil(start, new boolean[vertices+1], target, 0);
    }

    public int findMinPathUtil(int start, boolean[] visited, int target,  int value) {
        if (visited[start]) {
            return Integer.MAX_VALUE;
        }
        visited[start] = true;
        if (start == target) {
            return value;
        }

        int minPath = Integer.MAX_VALUE;
        for(int i = 0 ; i< vertices+1; i++) {
            if (nodes[start][i] != -1) {
                boolean[] vis = Arrays.copyOf(visited, visited.length);
                minPath = Math.min(minPath, findMinPathUtil(i, vis, target, value + nodes[start][i]));
            }
        }
        return minPath;
    }

}
