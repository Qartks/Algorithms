package com.algorithms.qartks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainTree {

	class NTreeNode {
		int data;
		List<NTreeNode> nNodes;

		NTreeNode() {
			data = Integer.MIN_VALUE;
			nNodes = new ArrayList<>();
		}
	}
	
	public static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		int checkRoot = checkBalance(root);
		if (checkRoot == -1) {
			return false;
		}
		
		return true;
	}

	private static int checkBalance(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int leftHeight = checkBalance(root.left);
		if (leftHeight == -1) {
			return -1;
		}
		int rightHeight = checkBalance(root.right);
		if (rightHeight == -1) {
			return -1;
		}
		
		int heightDiff = Math.abs(leftHeight - rightHeight);
		
		if (heightDiff > 1) {
			return -1;
		}
		
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public static int diameterBTree(TreeNode root) {
		if	(root == null) {
			return 0;
		}

		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);

		int leftDiameter = diameterBTree(root.left);
		int rightDiameter = diameterBTree(root.right);

		return Math.max(1 + leftHeight + rightHeight, Math.max(leftDiameter, rightDiameter));
	}

	private static int getHeight(TreeNode node) {
		if (node == null)
			return 0;
		return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}

	public static int diameterNTree(NTreeNode root) {
		if (root == null) {
			return 0;
		}

		Iterator<NTreeNode> it = root.nNodes.iterator();
		int max1 = 0, max2 = 0;
		while (it.hasNext()) {
			NTreeNode curr = it.next();

			int depp = depthNTree(curr);

			if (depp > max1) {
				max1 = depp;
			} else if (depp > max2) {
				max2 = depp;
			}
		}

		it = root.nNodes.iterator();
		int maxDiaOfChild = 0;
		while (it.hasNext()) {
			NTreeNode curr = it.next();
			maxDiaOfChild = Math.max(maxDiaOfChild, diameterNTree(curr));
		}

		return Math.max(1 + max1 + max2, maxDiaOfChild);
	}

	private static int depthNTree(NTreeNode node) {
		if (node == null)
			return 0;

		int maxHeight = 0;
		Iterator<NTreeNode> it = node.nNodes.iterator();
		while (it.hasNext()) {
			NTreeNode curr = it.next();
			maxHeight = Math.max(maxHeight, depthNTree(curr));
		}
		return 1 + maxHeight;
	}


	public static void main(String[] args) {
		Tree tree = new Tree(1);
		
	}

}
