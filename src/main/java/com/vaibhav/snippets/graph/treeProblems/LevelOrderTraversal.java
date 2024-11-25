package com.vaibhav.snippets.graph.treeProblems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class LevelOrderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode a) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (a == null) return res;

        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(a);

        while (!queue.isEmpty()) {
            int n = queue.size();
            ArrayList<Integer> al = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                a = queue.poll();
                al.add(a.val);
                if (a.left != null) queue.add(a.left);
                if (a.right != null) queue.add(a.right);
            }
            res.add(al);
        }
        return res;
    }

}
