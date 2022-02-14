package com.vaibhav.snippets.codingProblems.treeProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CopyNryGraph {

    public static void main(String[] args) {
        UndirectedGraphNode node_0 = new UndirectedGraphNode(1);
        UndirectedGraphNode node_1 = new UndirectedGraphNode(2);
        UndirectedGraphNode node_2 = new UndirectedGraphNode(3);
        UndirectedGraphNode node_3 = new UndirectedGraphNode(4);
        List<UndirectedGraphNode> level1Children = new ArrayList<>();
        level1Children.add(node_1);
        level1Children.add(node_2);
        node_0.neighbors = level1Children;
        node_2.neighbors = List.of(node_3);

        UndirectedGraphNode result = cloneGraph(node_0);
        System.out.println(result.label);
        System.out.println(result.neighbors.get(0).label);
        System.out.println(result.neighbors.get(1).label);
        System.out.println(result.neighbors.get(1).neighbors.get(0).label);// output should be 1,2,3,4
    }

    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        UndirectedGraphNode head = node;
        Map<UndirectedGraphNode, UndirectedGraphNode> oldToNew = new HashMap<>();
        bfsAndPopulateCopyOfEachNode(node, oldToNew);
        node = head;
        traverseBfsAndRecreateGraph(node, oldToNew);
        return oldToNew.get(head);
    }

    private static void bfsAndPopulateCopyOfEachNode(UndirectedGraphNode root, Map<UndirectedGraphNode, UndirectedGraphNode> oldToNew) {
        if (root == null) {
            return;
        }
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        Set<UndirectedGraphNode> visited = new HashSet<>();
        q.add(root);

        while(!q.isEmpty()) {
            UndirectedGraphNode node = q.poll();
            if(!visited.contains(node)) {
                visited.add(node);
                oldToNew.put(node, new UndirectedGraphNode(node.label));
                List<UndirectedGraphNode> neighbors = node.neighbors;
                for (UndirectedGraphNode neighbour : neighbors) {
                    q.add(neighbour);
                }
            }

        }
    }

    private static void traverseBfsAndRecreateGraph(UndirectedGraphNode root, Map<UndirectedGraphNode, UndirectedGraphNode> oldToNew) {
        if (root == null) {
            return;
        }
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.add(root);
        Set<UndirectedGraphNode> visited = new HashSet<>();
        while(!q.isEmpty()) {
            UndirectedGraphNode node = q.poll();
            if(!visited.contains(node)) {
                visited.add(node);
                List<UndirectedGraphNode> neighbors = node.neighbors;
                UndirectedGraphNode copyNode = oldToNew.get(node);
                List<UndirectedGraphNode> copyNeighbours = new ArrayList<>();
                for (UndirectedGraphNode neighbour : neighbors) {
                    copyNeighbours.add(oldToNew.get(neighbour));
                    q.add(neighbour);
                }
                copyNode.neighbors = copyNeighbours;
            }

        }
    }
}

class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  }
