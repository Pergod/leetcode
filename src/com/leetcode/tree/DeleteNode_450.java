package com.leetcode.tree;


public class DeleteNode_450 {
	
	public TreeNode deleteNode(TreeNode root, int key) {
        if (root != null) {
			TreeNode cur = root;
			// ��ǰ�ڵ�ĸ��ڵ�
			TreeNode curP = null;
			// �Ȳ��ң���ɾ��
			while (cur != null) {
				if (cur.val > key) {
					// 
					if (cur.left == null) {
						return root;
					}
					// ��ǰ�ڵ�����ڵ�
					curP = cur;
					// ��ǰ�ڵ�����������
					cur = cur.left;
				} else if (cur.val < key) {
					if (cur.right == null) {
						return root;
					}
					// ���ڵ�
					curP = cur;
					// ��ǰ�ڵ�����������
					cur = cur.right;
				} else {
					// ���Ҫɾ���Ľڵ�û���ӽڵ�
					if (cur.left == null && cur.right == null) {
						// ɾ�����Ǹ��ڵ�
						if (curP == null) {
							return null;
						}
						// �ж�ɾ���Ľڵ����ڸ��ڵ���Ŀ�������
						if (curP.left == cur) {
							curP.left = null;
						} else {
							curP.right = null;
						}
						// ���Ҫɾ���Ľڵ��������ӽڵ�
					} else if (cur.left != null && cur.right != null) {
						// ������Ҫ�ҵ�����ڵ���������е���С�ڵ�
						TreeNode minP = cur;
						TreeNode min = cur.right;
						while (min.left != null) {
							minP = min;
							min = min.left;
						}
						// ������ֵ�滻��Ҫɾ���Ľڵ�
						cur.val = min.val;
						// Ȼ����ɾ���������С�ڵ�
						// ����С�ڵ�������������ӵ����ڵ���
						if (minP.left == min) {
							minP.left = min.right;
						}else {
							minP.right = min.right;
						}
					} else {
						// ɾ���Ľڵ�û��������
						if (cur.left == null) {
							// ɾ�����Ǹ��ڵ�
							if (curP == null) {
								cur = cur.right;
								return cur;
							}
							// �ж�ɾ���Ľڵ����ڸ��ڵ���Ŀ�������
							if (curP.left == cur) {
								curP.left = cur.right;
							}else {
								curP.right = cur.right;
							}
						// ɾ���Ľڵ�û��������
						} else {
							// ɾ�����Ǹ��ڵ�
							if (curP == null) {
								cur = cur.left;
								return cur;
							}
							// �ж�ɾ���Ľڵ����ڸ��ڵ���Ŀ�������
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
