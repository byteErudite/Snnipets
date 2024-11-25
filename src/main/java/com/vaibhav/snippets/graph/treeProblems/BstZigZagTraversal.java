package com.vaibhav.snippets.graph.treeProblems;

import java.util.*;

public class BstZigZagTraversal {
    /**
     * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
     *
     *
     */

    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }


        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            bfsZigZag(root, result);
            return result;
        }

        public void bfsZigZag(TreeNode root, List<List<Integer>> result) {
            if (root == null) {
                return;
            }

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            boolean startFromLeft = true;

            while(!q.isEmpty()) {
                int levelSize = q.size();
                List<Integer> level = new ArrayList<>();

                for(int i = 0 ; i< levelSize ; i++) {
                    TreeNode n = q.remove();
                    if(n.left != null) q.add(n.left);
                    if(n.right != null) q.add(n.right);

                    level.add(n.val);
                }

                if (!startFromLeft) {
                    Collections.reverse(level);
                }

                result.add(level);
                startFromLeft = !startFromLeft;
            }
        }
}
