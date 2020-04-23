package com.leetcode.tree;


public class DeleteNode_450 {
	
	public TreeNode deleteNode(TreeNode root, int key) {
        if (root != null) {
			TreeNode cur = root;
			// 当前节点的父节点
			TreeNode curP = null;
			// 先查找，后删除
			while (cur != null) {
				if (cur.val > key) {
					// 
					if (cur.left == null) {
						return root;
					}
					// 当前节点给父节点
					curP = cur;
					// 当前节点跳到左子树
					cur = cur.left;
				} else if (cur.val < key) {
					if (cur.right == null) {
						return root;
					}
					// 父节点
					curP = cur;
					// 当前节点跳到右子树
					cur = cur.right;
				} else {
					// 如果要删除的节点没有子节点
					if (cur.left == null && cur.right == null) {
						// 删除的是根节点
						if (curP == null) {
							return null;
						}
						// 判断删除的节点是在父节点的哪棵子树上
						if (curP.left == cur) {
							curP.left = null;
						} else {
							curP.right = null;
						}
						// 如果要删除的节点有两个子节点
					} else if (cur.left != null && cur.right != null) {
						// 我们需要找到这个节点的右子树中的最小节点
						TreeNode minP = cur;
						TreeNode min = cur.right;
						while (min.left != null) {
							minP = min;
							min = min.left;
						}
						// 把它的值替换到要删除的节点
						cur.val = min.val;
						// 然后再删除掉这个最小节点
						// 把最小节点的右子树，链接到父节点上
						if (minP.left == min) {
							minP.left = min.right;
						}else {
							minP.right = min.right;
						}
					} else {
						// 删除的节点没有左子树
						if (cur.left == null) {
							// 删除的是根节点
							if (curP == null) {
								cur = cur.right;
								return cur;
							}
							// 判断删除的节点是在父节点的哪棵子树上
							if (curP.left == cur) {
								curP.left = cur.right;
							}else {
								curP.right = cur.right;
							}
						// 删除的节点没有右子树
						} else {
							// 删除的是根节点
							if (curP == null) {
								cur = cur.left;
								return cur;
							}
							// 判断删除的节点是在父节点的哪棵子树上
							if (curP.left == cur) {
								curP.left = cur.left;
							}else {
								curP.right = cur.left;
							}
						}
						
					}
					return root;
				}
			}
		}
		return root;
    }
}
