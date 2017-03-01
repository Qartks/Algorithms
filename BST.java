package com.algorithms.qartks;

/**
 * Created by qartks on 2/28/17.
 */
public class BST {

    class BSTNode {
        int data;
        BSTNode left;
        BSTNode right;
        BSTNode parent;

        public BSTNode(int d) {
            left = null;
            right = null;
            data = d;
        }
    }

    private BSTNode root;
    int max = Integer.MAX_VALUE;
    int min = Integer.MIN_VALUE;

    public BST() { }

    public BSTNode add (int x) {
        if (root == null) {
            return root = new BSTNode(x);
        }
        return add(root, x);
    }

    private BSTNode add(BSTNode node, int x) {
        if (node == null) return new BSTNode(x);

        if (node.data < x) {
            node.right = add(node.right, x);
        } else {
            node.left = add(node.left, x);
        }
        return node;
    }

    public void printBST() {
        printBST(root);
    }

    private void printBST(BSTNode node) {
        if (node == null) return;
        printBST(node.left);
        System.out.print(node.data + " ");
        printBST(node.right);
    }

    public boolean checkBST() {
        if (root == null) return true;
        return checkBST(root, min, max);
    }

    private boolean checkBST(BSTNode node, int min, int max) {
        if (node == null) return true;

        if (node.data < min || node.data >= max) {
            return false;
        }
        return checkBST(node.left, min, node.data) && checkBST(node.right, node.data + 1, max);
    }

    public int getMax() {
        return getMax(root);
    }

    private int getMax(BSTNode node) {
        if (node == null) return Integer.MIN_VALUE;
        BSTNode curr = node;

        while (node.right != null) {
            node = node.right;
        }
        return node.data;
    }

    public int inOrderSuccessor(int x) {
        return inOrderSuccessor(root, x);
    }

    private int inOrderSuccessor(BSTNode node, int x) {
        if (node == null) return Integer.MAX_VALUE;

        if (node.right != null) {
            return getMax(node.right);
        }
        BSTNode curr = node.parent;
        while (curr != null && curr.right != node ) {
            node = curr;
            curr = curr.parent;
        }
        return curr.data;
    }

    public BSTNode commonAncestor(int a, int b) {
        return commonAncestor(root, a, b);
    }

    private BSTNode commonAncestor(BSTNode node, int a, int b) {
        while (node != null) {
            if (node.data > a && node.data > b)
                node = node.left;
            else if (node.data <= a && node.data <= b)
                node = node.right;
            else
                break;
        }
        return node;
    }


    public int getMin() {
        return getMin(root);
    }

    private int getMin(BSTNode node) {
        if (node == null) return Integer.MIN_VALUE;
        BSTNode curr = node;

        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    public static void main(String[] args) {
        BST bst = new BST();

        bst.add(6);
        bst.add(3);
        bst.add(7);
        bst.add(2);
        bst.add(8);
        bst.add(1);
        bst.add(4);

        bst.printBST();
        System.out.println();
        System.out.println(bst.checkBST());
        System.out.println(bst.getMax());
        System.out.println(bst.getMin());
        System.out.println(bst.commonAncestor(1, 4).data);

    }
}
