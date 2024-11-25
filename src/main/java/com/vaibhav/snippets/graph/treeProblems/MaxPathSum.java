package com.vaibhav.snippets.graph.treeProblems;

public class MaxPathSum {

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
  }

    public int maxPathSum(TreeNode A) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        calculate(A, max);
        return max[0];
    }
    public int calculate(TreeNode root, int[] max){
        if(root == null){
            return 0;
        }
        int left = calculate(root.left, max);
        int right = calculate(root.right, max);
        int current = Math.max(root.val, Math.max(root.val+left, root.val+right));
        max[0] = Math.max(max[0], Math.max(current, left+root.val+right));
        return current;
    }
}
