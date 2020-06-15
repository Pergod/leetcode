package com.leetcode.tree;

public class MaxDepth_104 {

	public int maxDepth(TreeNode root) {
		if (root != null) {
			// ��ȡ�������ĸ߶�
			int maxLeft = maxDepth(root.left);
			// ��ȡ�������ĸ߶�
			int maxRight = maxDepth(root.right);
			// ȡ�����߶ȵ����ֵ
			return Math.max(maxLeft, maxRight) + 1;
		} else {
			return 0;
		}
	}
}
