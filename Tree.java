package com.algorithms.qartks;

import java.util.Stack;

public class Tree {
	TreeNode root;

	class Wrapper {
	    int min;
	    int max;
	    boolean isBST;
	    int size;
    }

	public int largestSubBST(TreeNode root)
    {
	    Wrapper result = largestSubBSTUtil(root);
	    return result.size;
    }

    private Wrapper largestSubBSTUtil(TreeNode node)
    {
	    Wrapper curr = new Wrapper();
        if (node == null) {
            curr.isBST = true;
            curr.size = 0;
            return curr;
        }

        Wrapper leftChild = largestSubBSTUtil(node.left);
        Wrapper rightChild = largestSubBSTUtil(node.right);

        curr.min = Math.min(node.data, leftChild.min);
        curr.max = Math.max(node.data, rightChild.max);

        if (leftChild.isBST && rightChild.isBST && leftChild.min<=node.data && rightChild.max > node.data) {
            curr.isBST = true;
            curr.size = 1 + leftChild.size + rightChild.size;
        } else {
            curr.isBST = false;
            curr.size = Math.max(leftChild.size, rightChild.size);
        }

        System.gc();

	    return curr;
    }

    public void InOrder(TreeNode root) {
	    if (root == null) {
	        return;
        }

        Stack<TreeNode> s = new Stack<>();
	    TreeNode curr = root;

	    while (curr != null) {
	        s.push(curr);
	        curr = curr.left;
        }

        while (!s.isEmpty()) {
	        TreeNode node = s.pop();
            System.out.print(node.data + " ");
            if (node.right != null) {
                node = node.right;

                while (node != null) {
                    s.push(node);
                    node = node.left;
                }
            }
        }
    }

    public Tree() {
		this.root = new TreeNode();
	}
	
	public Tree(int d) {
		this.root = new TreeNode(d);
	}
}
