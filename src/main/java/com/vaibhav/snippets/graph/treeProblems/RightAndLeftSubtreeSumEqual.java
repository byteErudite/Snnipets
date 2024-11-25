package com.vaibhav.snippets.graph.treeProblems;

public class RightAndLeftSubtreeSumEqual {

    public static void main(String[] args) {
        RightAndLeftSubtreeSumEqual instance = new RightAndLeftSubtreeSumEqual();
        instance.callisSumEqual();
    }

    private void callisSumEqual() {
        Node n1 = new Node(3);
        Node n2 = new Node(1);
        Node n3 = new Node(2);
        n1.left = n2;
        n1.right = n3;
        System.out.println(isSumEqual(n1));// expect 1

    }
    int isSumEqual(Node node)
    {
        if(node == null || (node.left == null && node.right == null))
        {
            return 1;
        }

        int ls = sum(node.left);
        int rs = sum(node.right);

        if ((node.data == ls + rs) && isSumEqual(node.left) != 0 && isSumEqual(node.right) != 0)
        {
            return 1;
        }
        return 0;
    }

    static int sum(Node node)
    {
        if(node == null)
        {
            return 0;
        }
        return (sum(node.left) + node.data+sum(node.right));
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
