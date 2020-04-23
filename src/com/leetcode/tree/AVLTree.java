package com.leetcode.tree;

/**
 * ƽ����棨��������
 * @author Flystar
 *
 */
public class AVLTree {
	int val;
	// ����
	int height;
	AVLTree left;
	AVLTree right;

	AVLTree(int x) {
		val = x;
	}
	
	/**
	 * ����
	 * 1.�жϲ��뵽�ĸ�����
	 * 2.�ж�����
	 * 3.�ж���������ת
	 * @param val
	 * @return
	 */
	public AVLTree insert(AVLTree root,int val){
		// ���뵽����
		if (root == null) {
			root = new AVLTree(val);
			root.left = null;
			root.right = null;
			return root;
		}
		// ������������
		if (root.val > val) {
			root.left = insert(root.left, val);
			// �ж�����,�Ƿ����ﵽ2
			if (Math.abs(getHeight(root.left) - getHeight(root.right)) == 2) {
				// �ж���������ת
				// ������뵽�����������
				if (root.left.val > val) {
					// ��-����
					singleLeftRotate(root.left);
				// ������뵽���������Ҳ�
				}else {
					// ��-��˫��
					doubleLeftRightRotation(root.left);
				}
			}
		// ������������
		}else {
			root.right =insert(root.right, val);
			// �ж�����,�Ƿ����ﵽ2
			if (Math.abs(getHeight(root.left) - getHeight(root.right)) == 2) {
				// �ж���������ת
				// ������뵽���������Ҳ�
				if (root.right.val < val) {
					// ��-�ҵ���
					singleRightRotate(root.right);
				}else {
					// ��-��˫��
					doubleRightLeftRotation(root.right);
				}
			}
		}
		// ��������
		root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
		return root;
	}
	
	/**
	 * ��ȡ����
	 * @return
	 */
	public int getHeight(AVLTree tree){
		if (tree == null) {
			return 0;
		}
		// ��ȡ�������ĸ߶�
		int left = getHeight(tree.left);
		// ��ȡ�������ĸ߶�
		int right = getHeight(tree.right);
		return Math.max(left, right) + 1;
	}
	
	/**
	 * ��-����
	 * �鷳�ڵ㣬�ڷ��ֽڵ������������ߣ�!����һ�����������ϣ�
	 * @return
	 */
	public AVLTree singleLeftRotate(AVLTree A){
		// ���ο�ͼʾ���
		AVLTree B = A.left;
		// ��B�ڵ���������ƶ���A�ڵ����������
		A.left = B.right;
		// ��A�ڵ����ӵ�B�ڵ����������
		B.right = A;
		int AHeight = Math.max(getHeight(A.left),getHeight(A.right))+1;
		int BHeight = Math.max(getHeight(B.left), AHeight) + 1;
		// ���� A,B����
		A.height = AHeight;
		B.height = BHeight;
		// ��ʱB��Ϊ"��"�ڵ㣬������B�ڵ�
		return B;
	}
	
	/**
	 * ��-�ҵ���
	 * �鷳�ڵ㣬�ڷ��ֽڵ�����������ұߣ�!����һ�����������ϣ�
	 * @return
	 */
	public AVLTree singleRightRotate(AVLTree A){
		AVLTree B = A.right;
		A.right = B.left;
		A = B.left;
		int AHeight = Math.max(getHeight(A.left), getHeight(A.right)) + 1;
		int BHeight = Math.max(getHeight(B.right), AHeight) + 1;
		// ��������
		A.height = AHeight;
		B.height = BHeight;
		// ����B�ڵ�
		return B;
	}
	
	/**
	 * ��-��˫��
	 * �鷳�ڵ㣬�ڷ��ֽڵ�����������ұ�
	 * @return
	 */
	public AVLTree doubleLeftRightRotation(AVLTree A){
		// ���ͼʾ���A,B,C�ڵ�
		AVLTree B = A.left;
		// ��B�ڵ�����-�ҵ���,���������ӵ�C�ڵ���
		AVLTree C = singleRightRotate(B);
		// ��C�ڵ����ӵ�A�ڵ����������
		A.left = C;
		// ��A�ڵ�����-����
		return singleLeftRotate(A);
	}
	
	/**
	 * ��-��˫��
	 * �鷳�ڵ㣬�ڷ��ֽڵ�������������
	 * @return
	 */
	public AVLTree doubleRightLeftRotation(AVLTree A){
		// ���ͼʾ���A,B,C�ڵ�
		AVLTree B = A.right;
		// �ȶ�B�ڵ�����-����,�������ӵ�C�ڵ���
		AVLTree C = singleLeftRotate(B);
		// ��C���ӵ�A����������
		A.right = C;
		// ��A����-�ҵ���
		return singleRightRotate(A);
	}
}
