package com.vaibhav.snippets.codingProblems.treeProblems;

import java.util.ArrayList;

public class LowestCommonAncester {

    public static void main(String[] args) {
        LowestCommonAncester instance = new LowestCommonAncester();
        instance.callLca();
    }

    private void callLca() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.left = n2;
        n1.right = n3;
        char r1 = lca(n1, 2,3);
        char r2 = lca(n1, 4,3);
        System.out.println(r1);// expect 1
        System.out.println(r2);// expect *
    }


    // Find paths for finding each element and then return last common value in both paths
    private char lca(Node root, int n1,int n2)
    {

        String firstPath = findPath(root, n1, "");
        String secondPath = findPath(root, n2, "");
        if(firstPath.length() == 0 || secondPath.length() == 0) {
            return '*';
        }
        int i =0;
        while(firstPath.charAt(i) == secondPath.charAt(i)) {
            i++;
        }
        return firstPath.charAt(--i);
    }

    private String findPath(Node root, int n1, String path) {
        if (root == null) {
            return "";
        }
        path = path + root.data;
        if (root.data == n1) {
            return path;
        }
        return findPath(root.left, n1, path) + findPath(root.right, n1, path);
    }
     class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
}
