package com.vaibhav.snippets.graph.treeProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalBinaryTree {
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



    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        bfs_my_solution(root, result);
        return result;
    }

    class N {
        TreeNode node;
        int level;
        N(TreeNode n, int level) {
            this.node = n;
            this.level = level;
        }
    }

    public void bfs_my_solution(TreeNode root, List<List<Integer>> result) {
        if(root == null) {
            return;
        }

        Queue<N> q = new LinkedList<>();
        q.add(new N(root,0));
        int currLevel = 0;
        List<Integer> levelResult = new ArrayList<>();
        while(!q.isEmpty()) {
            N curr = q.remove();

            if (currLevel == curr.level) {
                levelResult.add(curr.node.val);
            } else {
                result.add(levelResult);
                levelResult = new ArrayList<>();
                levelResult.add(curr.node.val);
                currLevel++;
            }

            if (curr.node.left!= null) q.add(new N(curr.node.left, currLevel + 1));
            if (curr.node.right != null) q.add(new N(curr.node.right, currLevel + 1));
        }

        if (!levelResult.isEmpty()) {
            result.add(levelResult);
        }

    }


    public List<List<Integer>> levelOrderLeetcodeSoluion(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            ans.add(level);
        }

        return ans;
    }
}
