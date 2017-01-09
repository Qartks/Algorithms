package com.algorithms.qartks;

public class MainTree {
	
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
		
		if (heightDiff == -1) {
			return -1;
		}
		
		return heightDiff + 1;
	}



	public static void main(String[] args) {
		Tree tree = new Tree(1);
		
	}

}
