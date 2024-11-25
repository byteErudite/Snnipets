package com.vaibhav.snippets.graph.treeProblems;

import java.util.Objects;

public class BST {
    TreeNode root;

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void insertNode(int val) {
        if (Objects.isNull(root)) {
            root = new TreeNode(val);
            return;
        }
        TreeNode traverser = root;
        while (traverser != null) {
            if (traverser.val >= val) {
                if (traverser.left == null) {
                    traverser.left = new TreeNode(val);
                    return;
                }
                traverser = traverser.left;
            } else if (traverser.val < val) {
                if (traverser.right == null) {
                    traverser.right = new TreeNode(val);
                    return;
                }
                traverser = traverser.right;
            }
        }
    }

    public static void preOrderTraversal(TreeNode root) {
        if (root == null)
        {
            return;
        }
        System.out.println(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insertNode(5);
        bst.insertNode(10);
        bst.insertNode(4);
        preOrderTraversal(bst.root);
        int val = 10;
    }

}
