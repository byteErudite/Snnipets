package com.vaibhav.snippets.codingProblems.treeProblems;

import java.util.LinkedList;
import java.util.Queue;

public class BFSImpl {
    public static void main (String[] args) {
        Graph g = new Graph(5);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(4,1);
        g.addEdge(1,5);


        System.out.println("BFS: ");
        bfs(g, 4);
        System.out.println("DFS: ");
        dfs(g, 3);
    }

    static void  bfs(Graph g, int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        boolean[] visited = new boolean[g.size+1];

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            visited[curr] = true;
            System.out.println(curr);
            for(int i =1; i<= g.size ; i++) {
                if(!visited[i]  && g.g[curr][i] == 1) {
                    queue.add(i);
                }
            }
        }
    }

    static void dfs(Graph g, int startNode) {
        boolean[] visited = new boolean[g.size+1];
        dfs_re(visited, g, startNode);
    }
    static void dfs_re(boolean[] visited, Graph g, int curr) {
        if(!visited[curr]) {
            System.out.println(curr);
            visited[curr] = true;
            for(int i = 1; i <= g.size ; i++) {
                if (g.g[curr][i] == 1) {
                    dfs_re(visited, g, i);
                }
            }
        }


    }

}

class Graph {
    int[][] g;
    int size;

    Graph(int size) {
        this.size = size;
        g = new int[size+1][size+1];
    }

    void addEdge(int source, int target) {
        if(source <= size && target <= size) {
            g[source][target] = 1;
        }

    }

    void removeEdge(int source, int target) {
        if(source < size && target < size) {
            g[source][target] = 0;
        }
    }





}
