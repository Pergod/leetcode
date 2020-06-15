package com.leetcode.tree;

public class InvertTree_226 {
	
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		// ����������left,right�ڵ㻥��
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		// �ݹ鴦����ڵ�
		invertTree(root.left);
		// �ݹ鴦���ҽڵ�
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
