package com.leetcode.tree;

/**
 * 二叉查找树
 * 
 * @author Flystar
 *
 */
public class BinarySearchTree {
	private Node tree;

	/**
	 * 插入
	 * 
	 * @param val
	 */
	public void insert(int val) {
		if (tree == null) {
			tree = new Node(val);
			return;
		}
		// 记录当前位置
		Node tmp = tree;
		while (tmp != null) {
			// 如果插入值小于，当前值，则插入到左子树
			if (tmp.data > val) {
				// 判断当前节点的左子树，是否为空
				// 如果为空，则直接构造节点，并使得当前节点的左指针，指向该新增节点
				if (tmp.left == null) {
					tmp.left = new Node(val);
					return;
				}
				// 否则，跳到左子树继续判断
				tmp = tmp.left;
				// 否则插入到右子树
			} else {
				// 判断当前节点的右子树，是否为空
				// 如果为空，则直接构造节点，并使得当前节点的右指针，指向该新增节点
				if (tmp.right == null) {
					tmp.right = new Node(val);
					return;
				}
				// 否则，跳到右子树继续判断
				tmp = tmp.right;
			}
		}
	}

	/**
	 * 查找
	 * 
	 * @param val
	 * @return
	 */
	public Node find(int val) {
		if (tree != null) {
			Node tmp = tree;
			while (tmp != null) {
				// 如果查找值小于当前值，则从左子树查找
				if (tmp.data > val) {
					if (tmp.left == null) {
						return null;
					}
					tmp = tmp.left;
					// 否则，查找值大于当前值，从右子树查找
				} else if (tmp.data < val) {
					if (tmp.right == null) {
						return null;
					}
					tmp = tmp.right;
					// 找到，则返回
				} else {
					return tmp;
				}
			}
		}
		return null;
	}

	/**
	 * 删除 
	 * 第一种情况，如果要删除的节点没有子节点 
	 * 第二种情况，如果要删除的节点只有一个子节点 
	 * 第三种情况，如果要删除的节点有两个子节点
	 * @param val
	 * @return
	 */
	public void delete(int val) {
		if (tree != null) {
			Node cur = tree;
			// 当前节点的父节点
			Node curP = null;
			// 先查找，后删除
			while (cur != null) {
				if (cur.data > val) {
					if (cur.left != null) {
						// 当前节点给父节点
						curP = cur;
						// 当前节点跳到左子树
						cur = cur.left;
					}
				} else if (cur.data < val) {
					if (cur.right != null) {
						// 父节点
						curP = cur;
						// 当前节点跳到右子树
						cur = cur.right;
					}
				} else {
					// 如果要删除的节点没有子节点
					if (cur.left == null && cur.right == null) {
						// 判断该节点是在父节点的左子树上，还是右子树上
						if (curP.left == cur) {
							curP.left = null;
						} else {
							curP.right = null;
						}
					// 如果要删除的节点有两个子节点
					} else if (cur.left != null && cur.right != null) {
						// 我们需要找到这个节点的右子树中的最小节点
						Node minP = cur;
						Node min = cur.right;
						while (min.left != null) {
							minP = min;
							min = min.left;
						}
						// 把它的值替换到要删除的节点
						cur.data = min.data;
						// 然后再删除掉这个最小节点
						// 该节点肯定是没有左子树的
						minP.left = min.right;
					// 如果要删除的节点只有一个子节点
					} else {
						if (cur.left == null) {
							curP = cur.right;
						} else {
							curP = cur.left;
						}
					}
				}
			}
		}
	}

	/**
	 * 课程代码
	 * @param data
	 */
	public void remove(int data) {
		Node cur = tree;
		// p指向要删除的节点，初始化指向根节点
		Node curP = null;
		// pp记录的是p的父节点
		while (cur != null && cur.data != data) {
			// 父节点
			curP = cur;
			// 节点下移
			if (data > cur.data) {
				cur = cur.right;
			} else {
				cur = cur.left;
			}
		}
		// 没有找到
		if (cur == null) {
			return;
		}
		// 要删除的节点有两个子节点
		if (cur.left != null && cur.right != null) {
			// 查找右子树中最小节点
			Node min = cur.right;
			// minP表示min最小节点的父节点
			Node minP = cur;
			while (min.left != null) {
				// 记录父节点
				minP = min;
				// 节点跳到左子树
				min = min.left;
			}
			// 将最小的值，替换当前值（要删除的节点）
			cur.data = min.data;
			// 下面就变成了删除min了，结合下面代码看
			// 由于右子树中的最小节点只可能是有一个右子节点或者没有子节点，
			// 所以，是将第二步骤，放到了删除只有一个子节点或者没有子节点的范围内
			// 此时把min赋给cur，也就是cur此时指向min的位置
			// 同时curP指向minP，也是就curP此时指向min的父节点
			// 当前此时也可以直接做删除操作
			cur = min;
			curP = minP;
		}
		// 删除节点是叶子节点或者仅有一个子节点（最小值的位置也可能存在右节点）
		// 如果上面代码执行完，下面cur的位置已经是最小值的位置
		// cur的子节点
		Node child;
		if (cur.left != null) {
			child = cur.left;
		} else if (cur.right != null) {
			child = cur.right;
		} else {
			child = null;
		}
		// 删除的是根节点
		if (curP == null) {
			tree = child;
		// 如果要删除的节点只有一个子节点（只有左子节点或者右子节点）
	    // 我们只需要更新父节点中，指向要删除节点的指针，让它指向要删除节点的子节点就可以
		} else if (curP.left == cur) {
			// 也就是将要删除的节点的左子节点，连接到要删除的节点的父子节点的左子树上
			curP.left = child;
		} else {
			// 也就是将要删除的节点的右子节点，连接到要删除的节点的父子节点的右子树上
			curP.right = child;
		}
	}

	/**
	 * 节点
	 * 
	 * @author Flystar
	 *
	 */
	static class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			this.data = data;
		}

	}

}
