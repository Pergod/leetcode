package com.leetcode.tree;

/**
 * 平衡二叉（搜索）树
 * @author Flystar
 *
 */
public class AVLTree {
	int val;
	// 树高
	int height;
	AVLTree left;
	AVLTree right;

	AVLTree(int x) {
		val = x;
	}
	
	/**
	 * 插入
	 * 1.判断插入到哪个子树
	 * 2.判断树高
	 * 3.判断做哪种旋转
	 * @param val
	 * @return
	 */
	public AVLTree insert(AVLTree root,int val){
		// 插入到空树
		if (root == null) {
			root = new AVLTree(val);
			root.left = null;
			root.right = null;
			return root;
		}
		// 往左子树插入
		if (root.val > val) {
			root.left = insert(root.left, val);
			// 判断树高,是否相差达到2
			if (Math.abs(getHeight(root.left) - getHeight(root.right)) == 2) {
				// 判断做何种旋转
				// 如果插入到左子树的左侧
				if (root.left.val > val) {
					// 左-左单旋
					singleLeftRotate(root.left);
				// 如果插入到左子树的右侧
				}else {
					// 左-右双旋
					doubleLeftRightRotation(root.left);
				}
			}
		// 往右子树插入
		}else {
			root.right =insert(root.right, val);
			// 判断树高,是否相差达到2
			if (Math.abs(getHeight(root.left) - getHeight(root.right)) == 2) {
				// 判断做何种旋转
				// 如果插入到右子树的右侧
				if (root.right.val < val) {
					// 右-右单旋
					singleRightRotate(root.right);
				}else {
					// 右-左双旋
					doubleRightLeftRotation(root.right);
				}
			}
		}
		// 更新树高
		root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
		return root;
	}
	
	/**
	 * 获取树高
	 * @return
	 */
	public int getHeight(AVLTree tree){
		if (tree == null) {
			return 0;
		}
		// 获取左子树的高度
		int left = getHeight(tree.left);
		// 获取右子树的高度
		int right = getHeight(tree.right);
		return Math.max(left, right) + 1;
	}
	
	/**
	 * 左-左单旋
	 * 麻烦节点，在发现节点的左子树的左边（!并不一定是左子树上）
	 * @return
	 */
	public AVLTree singleLeftRotate(AVLTree A){
		// 看参考图示理解
		AVLTree B = A.left;
		// 将B节点的右子树移动至A节点的左子树上
		A.left = B.right;
		// 将A节点连接到B节点的右子树上
		B.right = A;
		int AHeight = Math.max(getHeight(A.left),getHeight(A.right))+1;
		int BHeight = Math.max(getHeight(B.left), AHeight) + 1;
		// 更新 A,B树高
		A.height = AHeight;
		B.height = BHeight;
		// 此时B成为"根"节点，并返回B节点
		return B;
	}
	
	/**
	 * 右-右单旋
	 * 麻烦节点，在发现节点的右子树的右边（!并不一定是右子树上）
	 * @return
	 */
	public AVLTree singleRightRotate(AVLTree A){
		AVLTree B = A.right;
		A.right = B.left;
		A = B.left;
		int AHeight = Math.max(getHeight(A.left), getHeight(A.right)) + 1;
		int BHeight = Math.max(getHeight(B.right), AHeight) + 1;
		// 更新树高
		A.height = AHeight;
		B.height = BHeight;
		// 返回B节点
		return B;
	}
	
	/**
	 * 左-右双旋
	 * 麻烦节点，在发现节点的左子树的右边
	 * @return
	 */
	public AVLTree doubleLeftRightRotation(AVLTree A){
		// 结合图示理解A,B,C节点
		AVLTree B = A.left;
		// 对B节点做右-右单旋,并将其链接到C节点上
		AVLTree C = singleRightRotate(B);
		// 将C节点链接到A节点的左子树上
		A.left = C;
		// 对A节点做左-左单旋
		return singleLeftRotate(A);
	}
	
	/**
	 * 右-左双旋
	 * 麻烦节点，在发现节点的右子树的左边
	 * @return
	 */
	public AVLTree doubleRightLeftRotation(AVLTree A){
		// 结合图示理解A,B,C节点
		AVLTree B = A.right;
		// 先对B节点做左-左单旋,后将其链接到C节点上
		AVLTree C = singleLeftRotate(B);
		// 将C链接到A的右子树上
		A.right = C;
		// 对A做右-右单旋
		return singleRightRotate(A);
	}
}
