package com.vaibhav.snippets.data_structures;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
     int vertices;
     LinkedList<Integer>[] nodes;

    Graph(int vertices) {
       this.vertices = vertices + 1;
       nodes = new LinkedList[Integer.valueOf(this.vertices)];
       for(int vertex = 1 ; vertex < this.vertices ; vertex++) {
           nodes[vertex] = new LinkedList<>();
       }
    }

    private void addEdge(int u, int v) {
        nodes[u].add(v);
    }

    private void traverseDFS(int startingVertex, boolean[] visited) {
        LinkedList<Integer> neighboursOfStartingNode = nodes[startingVertex];
        visited[startingVertex] = true;
        System.out.println(startingVertex+" ");

        Iterator<Integer> traverser = neighboursOfStartingNode.iterator();
        while (traverser.hasNext()) {
            int currentVertexValue = traverser.next();
            if(!visited[currentVertexValue]) {
                visited[currentVertexValue] = true;
                traverseDFS(currentVertexValue, visited);
            }
        }
    }

    private void dfs(int startingVertex) {
        boolean[] visited = new boolean[vertices];
        traverseDFS(startingVertex, visited);
    }

    private void bfs(int startingVertex) {
        LinkedList<Integer> visitedQueue = new LinkedList<>();
        boolean[] visited = new boolean[vertices];
        visitedQueue.add(startingVertex);
        while (!visitedQueue.isEmpty()) {
            int currentVertex = visitedQueue.poll();
            if (!visited[currentVertex]) {
                System.out.println(currentVertex+" ");
                visited[currentVertex] = true;
                for(int neighbourNode : nodes[currentVertex]) {
                        visitedQueue.add(neighbourNode);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(1,2);
        graph.addEdge(5,3);
        graph.addEdge(5,1);
        graph.addEdge(3,5);
        graph.addEdge(3,1);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(1,5);
        System.out.println("-----DFS-----");
        graph.dfs(1);
        System.out.println("-----BFS-----");
        graph.bfs(1);
    }
}
