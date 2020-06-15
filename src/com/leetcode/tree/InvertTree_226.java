package com.leetcode.tree;

public class InvertTree_226 {
	
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		// 以下三行是left,right节点互换
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		// 递归处理左节点
		invertTree(root.left);
		// 递归处理右节点
		invertTree(root.right);
		return root;
	}
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
