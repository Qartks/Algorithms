package com.algorithms.qartks;


import sun.jvm.hotspot.utilities.RBTree;

/**
 * Created by qartks on 3/1/17.
 */
public class RedBlackTree {

    enum RBColor{
        RED, BLACK
    }

    class RBTreeNode {
        RBTreeNode left;
        RBTreeNode right;
        RBTreeNode parent;
        RBColor color;
        int key;

        public RBTreeNode(RBTreeNode left, RBTreeNode right, RBTreeNode parent, RBColor color, int key) {
            this.left = left;
            this.right = right;
            this.parent = parent;
            this.color = color;
            this.key = key;
        }
    }

    RBTreeNode NIL;
    RBTreeNode ROOT;

    public RedBlackTree() {
        this.NIL = new RBTreeNode(null, null, null, RBColor.BLACK, Integer.MIN_VALUE);
        this.ROOT = NIL;
    }

    public void leftRotate(RBTreeNode x) {
        RBTreeNode y = x.right;

        x.right = y.left;
        if (y.left != NIL) {
            y.left.parent = x;
        }

        y.parent = x.parent;
        if (x.parent == NIL) {
            ROOT = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }

        y.left = x;
        x.parent = y;
    }

    public void rightRotate(RBTreeNode x) {
        RBTreeNode y = x.left;

        x.left = y.right;
        if (y.right != NIL) {
            y.right.parent = x;
        }

        y.parent = x.parent;
        if (x.parent == NIL) {
            ROOT = y;
        } else if (x.parent == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }

        y.right = x;
        x.parent = y;
    }

    public void insert(int val) {
        RBTreeNode z = new RBTreeNode(NIL, NIL, NIL, RBColor.RED, val);
        RBTreeNode y = NIL;
        RBTreeNode x = ROOT;

        while (x != NIL) {
            y = x;
            if (z.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;
        if (y == NIL) {
            ROOT = z;
        } else if (z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }

        RGInsertFixup(z);
    }

    private void RGInsertFixup(RBTreeNode z) {
        while(z.parent.color== RBColor.RED){

            if(z.parent==z.parent.parent.left) {
                RBTreeNode y = z.parent.parent.right;
                if(y.color == RBColor.RED ){
                    z.parent.color = RBColor.BLACK;
                    y.color = RBColor.BLACK;
                    z.parent.parent.color = RBColor.RED;
                    z = z.parent.parent;
                }
                else if(z==z.parent.right){
                    z = z.parent;
                    leftRotate(z);

                    z.parent.color = RBColor.BLACK;
                    z.parent.parent.color = RBColor.RED;
                    rightRotate(z.parent.parent);
                }
                else{
                    z.parent.color = RBColor.BLACK;
                    z.parent.parent.color = RBColor.RED;
                    rightRotate(z.parent.parent);
                }
            }
            else {
                RBTreeNode y = z.parent.parent.left;
                if(y.color == RBColor.RED){
                    z.parent.color = RBColor.BLACK;
                    y.color = RBColor.BLACK;
                    z.parent.parent.color = RBColor.RED;
                    z = z.parent.parent;
                }
                else if(z==z.parent.left){
                    z=z.parent;
                    rightRotate(z);

                    z.parent.color = RBColor.BLACK;
                    z.parent.parent.color=RBColor.RED;
                    leftRotate(z.parent.parent);
                }
                else{
                    z.parent.color=RBColor.BLACK;
                    z.parent.parent.color=RBColor.RED;
                    leftRotate(z.parent.parent);
                }
            }
        }

        ROOT.color = RBColor.BLACK;
    }

    public void printInOrder(RBTreeNode node) {
        if (node == NIL) return;

        printInOrder(node.left);
        System.out.println(node.key + " " + node.color);
        printInOrder(node.right);
    }

    public static void main(String[] args) {
        RedBlackTree rb = new RedBlackTree();

        rb.insert(5);
        rb.insert(1);
        rb.insert(6);
        rb.insert(3);
        rb.insert(0);
        rb.insert(2);

        rb.printInOrder(rb.ROOT);
    }
}
