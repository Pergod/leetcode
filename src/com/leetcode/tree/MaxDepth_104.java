package com.leetcode.tree;

public class MaxDepth_104 {

	public int maxDepth(TreeNode root) {
		if (root != null) {
			// 获取左子树的高度
			int maxLeft = maxDepth(root.left);
			// 获取右子树的高度
			int maxRight = maxDepth(root.right);
			// 取两个高度的最大值
			return Math.max(maxLeft, maxRight) + 1;
		} else {
			return 0;
		}
	}
}
