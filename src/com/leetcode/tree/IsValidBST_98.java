package com.leetcode.tree;

public class IsValidBST_98 {
	
	public boolean isValidBST(TreeNode root) {
		TreeNode tmp = root;
		if (null != tmp.left && null != tmp.right) {
			if (tmp.left.val < tmp.val && tmp.right.val > tmp.val) {
				isValidBST(tmp.left);
				isValidBST(tmp.right);
			}else {
				return false;
			}
		}
		if (tmp.left == null) {
			isValidBST(tmp.right);
		}
		if(tmp.right == null)  {
			isValidBST(tmp.left);
		}
		return true;
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
