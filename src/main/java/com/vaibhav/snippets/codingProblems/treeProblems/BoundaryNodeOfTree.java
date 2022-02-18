package com.vaibhav.snippets.codingProblems.treeProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class BoundaryNodeOfTree {

    public static void main(String[] args) {
        BoundaryNodeOfTree instance = new BoundaryNodeOfTree();
        instance.callisSumEqual();
    }

    private void callisSumEqual() {
        Node n1 = new Node(3);
        Node n2 = new Node(1);
        Node n3 = new Node(2);
        n1.left = n2;
        n1.right = n3;
        System.out.println(boundary(n1).stream().map(String::valueOf).collect(Collectors.toList()));// expect 1

    }

    ArrayList <Integer> boundary(Node node)
    {
        ArrayList <Integer> solution = new ArrayList <>();
        solution.add(node.data);
        addLeftSubTree(node.left, solution);
        addLeafNodes(node, solution);
        addRightSubTree(node.right, solution);
        return solution;
    }

    private void addLeftSubTree(Node root, ArrayList<Integer> list) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 1; i <= n; i++) {
                Node temp = queue.poll();

                if (i == 1 && !(temp.left == null && temp.right == null)) {
                    list.add(temp.data);
                }
                if (temp.left != null)
                    queue.add(temp.left);

                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
    }

    private void addRightSubTree(Node root, ArrayList<Integer> list) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 1; i <= n; i++) {
                Node temp = queue.poll();

                if (i == n-1 && !(temp.left == null && temp.right == null)) {
                    list.add(temp.data);
                }
                if (temp.left != null)
                    queue.add(temp.left);

                if (temp.right != null)
                    queue.add(temp.right);
            }
        }

    }

    private void addLeafNodes(Node root, ArrayList<Integer> list) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int count = 0;
        while(!q.isEmpty()) {
            Node nod = q.poll();
            if(nod.right == null && nod.left == null && count!= 0) {
                list.add(nod.data);
            }
            if(null != nod.left) {
                q.add(nod.left);
            }
            if(null != nod.right) {
                q.add(nod.right);
            }
            count++;
        }
    }
//    ArrayList<Integer> boundary(Node node)
//    {
//        Queue<Node> q = new LinkedList<>();
//        q.add(node);
//        ArrayList<Integer> boundary = new ArrayList<>();
//        Stack<Integer> st = new Stack<>();
//        while(!q.isEmpty()) {
//            int n = q.size();
//            for(int i = 0 ; i< n ; i++) {
//                Node nod = q.poll();
//                if(i == 0) {
//                    boundary.add(nod.data);
//                }
//                if(n != 1 && i == n-1 ) {
//                    st.push(nod.data);
//                }
//                if(null != nod.left) {
//                    q.add(nod.left);
//                }
//                if(null != nod.right) {
//                    q.add(nod.right);
//                }
//
//            }
//        }
//        while(!st.isEmpty()) {
//            boundary.add(st.pop());
//        }
//        return boundary;
//    }

     class Node
 {
     int data;
     Node left, right;

     public Node(int d)
     {
         data = d;
         left = right = null;
     }
 }
}
