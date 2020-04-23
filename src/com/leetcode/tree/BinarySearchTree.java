package com.leetcode.tree;

/**
 * ���������
 * 
 * @author Flystar
 *
 */
public class BinarySearchTree {
	private Node tree;

	/**
	 * ����
	 * 
	 * @param val
	 */
	public void insert(int val) {
		if (tree == null) {
			tree = new Node(val);
			return;
		}
		// ��¼��ǰλ��
		Node tmp = tree;
		while (tmp != null) {
			// �������ֵС�ڣ���ǰֵ������뵽������
			if (tmp.data > val) {
				// �жϵ�ǰ�ڵ�����������Ƿ�Ϊ��
				// ���Ϊ�գ���ֱ�ӹ���ڵ㣬��ʹ�õ�ǰ�ڵ����ָ�룬ָ��������ڵ�
				if (tmp.left == null) {
					tmp.left = new Node(val);
					return;
				}
				// �������������������ж�
				tmp = tmp.left;
				// ������뵽������
			} else {
				// �жϵ�ǰ�ڵ�����������Ƿ�Ϊ��
				// ���Ϊ�գ���ֱ�ӹ���ڵ㣬��ʹ�õ�ǰ�ڵ����ָ�룬ָ��������ڵ�
				if (tmp.right == null) {
					tmp.right = new Node(val);
					return;
				}
				// �������������������ж�
				tmp = tmp.right;
			}
		}
	}

	/**
	 * ����
	 * 
	 * @param val
	 * @return
	 */
	public Node find(int val) {
		if (tree != null) {
			Node tmp = tree;
			while (tmp != null) {
				// �������ֵС�ڵ�ǰֵ���������������
				if (tmp.data > val) {
					if (tmp.left == null) {
						return null;
					}
					tmp = tmp.left;
					// ���򣬲���ֵ���ڵ�ǰֵ��������������
				} else if (tmp.data < val) {
					if (tmp.right == null) {
						return null;
					}
					tmp = tmp.right;
					// �ҵ����򷵻�
				} else {
					return tmp;
				}
			}
		}
		return null;
	}

	/**
	 * ɾ�� 
	 * ��һ����������Ҫɾ���Ľڵ�û���ӽڵ� 
	 * �ڶ�����������Ҫɾ���Ľڵ�ֻ��һ���ӽڵ� 
	 * ��������������Ҫɾ���Ľڵ��������ӽڵ�
	 * @param val
	 * @return
	 */
	public void delete(int val) {
		if (tree != null) {
			Node cur = tree;
			// ��ǰ�ڵ�ĸ��ڵ�
			Node curP = null;
			// �Ȳ��ң���ɾ��
			while (cur != null) {
				if (cur.data > val) {
					if (cur.left != null) {
						// ��ǰ�ڵ�����ڵ�
						curP = cur;
						// ��ǰ�ڵ�����������
						cur = cur.left;
					}
				} else if (cur.data < val) {
					if (cur.right != null) {
						// ���ڵ�
						curP = cur;
						// ��ǰ�ڵ�����������
						cur = cur.right;
					}
				} else {
					// ���Ҫɾ���Ľڵ�û���ӽڵ�
					if (cur.left == null && cur.right == null) {
						// �жϸýڵ����ڸ��ڵ���������ϣ�������������
						if (curP.left == cur) {
							curP.left = null;
						} else {
							curP.right = null;
						}
					// ���Ҫɾ���Ľڵ��������ӽڵ�
					} else if (cur.left != null && cur.right != null) {
						// ������Ҫ�ҵ�����ڵ���������е���С�ڵ�
						Node minP = cur;
						Node min = cur.right;
						while (min.left != null) {
							minP = min;
							min = min.left;
						}
						// ������ֵ�滻��Ҫɾ���Ľڵ�
						cur.data = min.data;
						// Ȼ����ɾ���������С�ڵ�
						// �ýڵ�϶���û����������
						minP.left = min.right;
					// ���Ҫɾ���Ľڵ�ֻ��һ���ӽڵ�
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
	 * �γ̴���
	 * @param data
	 */
	public void remove(int data) {
		Node cur = tree;
		// pָ��Ҫɾ���Ľڵ㣬��ʼ��ָ����ڵ�
		Node curP = null;
		// pp��¼����p�ĸ��ڵ�
		while (cur != null && cur.data != data) {
			// ���ڵ�
			curP = cur;
			// �ڵ�����
			if (data > cur.data) {
				cur = cur.right;
			} else {
				cur = cur.left;
			}
		}
		// û���ҵ�
		if (cur == null) {
			return;
		}
		// Ҫɾ���Ľڵ��������ӽڵ�
		if (cur.left != null && cur.right != null) {
			// ��������������С�ڵ�
			Node min = cur.right;
			// minP��ʾmin��С�ڵ�ĸ��ڵ�
			Node minP = cur;
			while (min.left != null) {
				// ��¼���ڵ�
				minP = min;
				// �ڵ�����������
				min = min.left;
			}
			// ����С��ֵ���滻��ǰֵ��Ҫɾ���Ľڵ㣩
			cur.data = min.data;
			// ����ͱ����ɾ��min�ˣ����������뿴
			// �����������е���С�ڵ�ֻ��������һ�����ӽڵ����û���ӽڵ㣬
			// ���ԣ��ǽ��ڶ����裬�ŵ���ɾ��ֻ��һ���ӽڵ����û���ӽڵ�ķ�Χ��
			// ��ʱ��min����cur��Ҳ����cur��ʱָ��min��λ��
			// ͬʱcurPָ��minP��Ҳ�Ǿ�curP��ʱָ��min�ĸ��ڵ�
			// ��ǰ��ʱҲ����ֱ����ɾ������
			cur = min;
			curP = minP;
		}
		// ɾ���ڵ���Ҷ�ӽڵ���߽���һ���ӽڵ㣨��Сֵ��λ��Ҳ���ܴ����ҽڵ㣩
		// ����������ִ���꣬����cur��λ���Ѿ�����Сֵ��λ��
		// cur���ӽڵ�
		Node child;
		if (cur.left != null) {
			child = cur.left;
		} else if (cur.right != null) {
			child = cur.right;
		} else {
			child = null;
		}
		// ɾ�����Ǹ��ڵ�
		if (curP == null) {
			tree = child;
		// ���Ҫɾ���Ľڵ�ֻ��һ���ӽڵ㣨ֻ�����ӽڵ�������ӽڵ㣩
	    // ����ֻ��Ҫ���¸��ڵ��У�ָ��Ҫɾ���ڵ��ָ�룬����ָ��Ҫɾ���ڵ���ӽڵ�Ϳ���
		} else if (curP.left == cur) {
			// Ҳ���ǽ�Ҫɾ���Ľڵ�����ӽڵ㣬���ӵ�Ҫɾ���Ľڵ�ĸ��ӽڵ����������
			curP.left = child;
		} else {
			// Ҳ���ǽ�Ҫɾ���Ľڵ�����ӽڵ㣬���ӵ�Ҫɾ���Ľڵ�ĸ��ӽڵ����������
			curP.right = child;
		}
	}

	/**
	 * �ڵ�
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
