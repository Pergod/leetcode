package com.leetcode.tree;

/**
 * ����� ����<<�㷨>>��4��ʵ��
 * �ƾٶ�����ʾhttps://www.cs.usfca.edu/~galles/visualization/Algorithms.html
 * 
 * @author Flystar
 */
public class RedBlackBST {

	private Node root;

	/**
	 * ���� ���ýڵ���������Ǻ�ɫ���������Ǻ�ɫʱ������ ��������ο��鼮277ҳ��ͼ3.3.16
	 * 
	 * @param h
	 * @return
	 */
	private Node rotateLeft(Node h) {
		// ��ʱ��h�ڵ���������Ǻ�ɫ��Ҳ����x�ڵ��Ǻ�ɫ
		Node x = h.right;
		h.right = x.left;
		h = x.left;
		// ������ɫ
		x.color = h.color;
		x.color = RED;
		// ����x�Ľڵ����
		x.N = h.N;
		// ����h�Ľڵ����
		h.N = size(h.left) + size(h.right) + 1;
		return x;
	}

	/**
	 * ��ȡ���Ľڵ����
	 * 
	 * @param h
	 * @return
	 */
	public int size(Node h) {
		if (h == null) {
			return 0;
		}
		return size(h.left) + size(h.right) + 1;
	}

	/**
	 * ���� ���ýڵ���ӽڵ�Ϊ��ɫ���������ӽڵ�ҲΪ��ɫ����������������ĺ�ɫ�ڵ� ��������ο��鼮277ҳ��ͼ3.3.17
	 * 
	 * @param h
	 * @return
	 */
	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = size(h.left) + size(h.right) + 1;
		return x;
	}

	/**
	 * ��ɫ
	 * 
	 * @param h
	 */
	private void flipColors(Node h) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}

	/**
	 * ��������
	 * 
	 * @param val
	 */
	public void put(int val) {
		root = put(root, val);
		// ��������壬���ڵ�����Ǻ�ɫ
		root.color = BLACK;
	}

	/**
	 * �жϽڵ��Ƿ��Ǻ�ɫ
	 * 
	 * @param h
	 * @return
	 */
	private boolean isRed(Node h) {
		if (h == null) {
			return false;
		}
		return h.color;
	}

	private Node put(Node h, int val) {
		if (h == null) {
			// �͸��ڵ�����ú����ӣ����԰������Ϊ����һ��3�ڵ�
			return new Node(val, 1, RED);
		}
		if (val < h.val) {
			put(h.left, val);
		} else if (val > h.val) {
			put(h.right, val);
		}
		// ���������Ϊ��ɫ��������Ϊ��ɫ������
		if (isRed(h.right) && isRed(h.left)) {
			rotateLeft(h);
			// ���������Ϊ��ɫ��������������������ҲΪ��ɫ������
		} else if (isRed(h.left) && isRed(h.left.left)) {
			rotateRight(h);
			// ��������������������Ǻ�ɫ����ɫ
		} else if (isRed(h.left) && isRed(h.right)) {
			flipColors(h);
		}
		// ���½ڵ����
		h.N = size(h.left) + size(h.right) + 1;
		return h;
	}

	/**
	 * �ж��Ƿ�Ϊ����
	 * 
	 * @return
	 */
	private boolean isEmpty() {
		if (root != null) {
			return true;
		}
		return false;
	}

	/**
	 * ɾ��
	 * 
	 * @param val
	 * @return
	 */
	public void delete(int val) {
		if (!isRed(root.left) && !isRed(root.right)) {
			root.color = RED;
		}
		root = delete(root, val);
		if (!isEmpty()) {
			root.color = BLACK;
		}
	}

	private Node delete(Node h, int val) {
		// ��Ŀ���С�ڵ�ǰ����ʱ��������������Ѱ����С�ǵĲ�������������ƶ����ϲ����ӽ��������2-���
		if(val < h.val){         
            if(h.left == null){
                return null;
            }
            if(isRed(h.left) && !isRed(h.left.left)){
                h = moveRedLeft(h);
            }
            h.left = delete(h.left,val);
        // ��Ŀ������ڵ�ǰ����ʱ�����������ƶ���������deleteMax��ͬ�Ĳ����������ͬ�Ļ�������ʹ�úͶ�������ɾ��һ���Ĳ�������ȡ��ǰ��������������С����Ȼ�󽻻�������Ŀ���ɾ��
        }else{               
            if(isRed(h.left)){
                h = rotateRight(h);
            }
            if(val != h.val && h.right == null){    // ����û���ҵ�Ŀ��������ǽ���ɾ��
                return null;
            }
            if(!isRed(h.right) && isRed(h.right.left)){
                h = moveRedRight(h);
            }
            if(val == h.val){
            	// ����������ȡ��Сֵ
                h.val = min(h.right);
                h.right = deleteMin(h.right);
            }
            else h.right = delete(h.right,val);
        }
        return balance(h);
	}
	
	/**
	 * ��ȡ��Сֵ
	 * @param h
	 * @return
	 */
	public int min(Node h){
		if (h == null) {
			return -1;
		}
		if (h.left == null) {
			return h.left.val;
		}
		return min(h.left);
	}
	
	/**
	 * ɾ�����ֵ
	 */
	public void deleteMax() {
		if (!isRed(root.left) && isRed(root.right)) {
			root.color = RED;
		}
		root = deleteMax(root);
		if (!isEmpty()) {
			root.color = BLACK;
		}
	}

	private Node deleteMax(Node h) {
		if (isRed(h.left)) {
			/**
			 * �����deleteMin����һ��������
			 * ��Ϊ���ӽڵ�Ӹ��ڵ��л�ýڵ��ʱ��������Ҫ����߽ڵ���ڵ��ұ߽ڵ㣬
			 * ������ǲ��ƶ��Ļ������ƻ�����ƽ��
			 * 5,6 1,2 9
			 * ������չʾ�������������������5������Ƶ��ұߵĻ������ǻ�ֱ��ɾ��9�������ᵼ�����Ĳ�ƽ�⣬��Ϊ��ڵ���������ߵģ����ǽ���ɾ��������ʱ��ֱ�ӽ������裬ֻ��Ҫ�ı���ɫ���ɣ�����Ҫ�ƶ�
			 * ���ں�������ԣ�6�Ǻڽ�㣬��ɾ����ʱ���ǲ���Ҫ�ƶ��ģ������ƶ�����5�����ĺ���
			 * 
			 */
			h = rotateRight(h);
		}
		if (h.right == null) {
			return null;
		}
		if (!isRed(h.right) && !isRed(h.right.left)) {
			h = moveRedRight(h);
		}
		h.right = deleteMax(h.right);
		return balance(h);
	}

	/**
	 * ɾ����Сֵ
	 */
	public void deleteMin() {
		if (!isRed(root.left) && !isRed(root.right)) {
			// ������ڵ�������ӽڵ���2-�ڵ㣬���ǿ��Խ�����Ϊ��ڵ㣬�������ܽ��к����moveRedLeft��������Ϊ����Ҫ�Ӹ��ڵ��һ��
			root.color = RED;
		}
		root = deleteMin(root);
		if (!isEmpty()) {
			// �����Ժ����ǽ����ڵ����ɫ��ԭ
			root.color = BLACK;
		}
	}

	private Node deleteMin(Node h) {
		if (h.left == null) {
			return null;
		}
		// �ж�x����ڵ��ǲ���2-�ڵ�
		if (!isRed(h.left) && !isRed(h.left)) {
			h = moveRedLeft(h);
		}
		h.left = deleteMin(h.left);
		// �����ʱ��ɵ�4-�ڵ�
		return balance(h);
	}

	/**
	 * 
	 * @param h
	 * @return
	 */
	private Node moveRedLeft(Node h) {
		flipColors(h);
		// �ж��ֵܽڵ㣬����ǷǺ�ڵ㣬Ҳ���ֵܽڵ��н�һ��
		if (isRed(h.right.left)) {
			h.right = rotateRight(h.right);
			h = rotateLeft(h);
		}
		return h;
	}

	/**
	 * 
	 * @param h
	 * @return
	 */
	private Node moveRedRight(Node h) {
		flipColors(h);
		if (!isRed(h.left.left)) {
			h = rotateRight(h);
		}
		return h;
	}

	/**
	 * 
	 * @param h
	 * @return
	 */
	private Node balance(Node h) {
		if (isRed(h.right)) {
			h = rotateLeft(h);
		}
		// ���������Ϊ��ɫ��������Ϊ��ɫ������
		if (isRed(h.right) && isRed(h.left)) {
			rotateLeft(h);
			// ���������Ϊ��ɫ��������������������ҲΪ��ɫ������
		} else if (isRed(h.left) && isRed(h.left.left)) {
			rotateRight(h);
			// ��������������������Ǻ�ɫ����ɫ
		} else if (isRed(h.left) && isRed(h.right)) {
			flipColors(h);
		}
		// ���½ڵ����
		h.N = size(h.left) + size(h.right) + 1;
		return h;
	}

	// ��ɫ
	private static final boolean RED = true;
	// ��ɫ
	private static final boolean BLACK = true;

	// �ڵ�
	class Node {
		private int val;
		private Node left;
		private Node right;
		// ������ڵ�ĸ���
		private int N;
		// �Ƿ��Ǻ�ɫ
		boolean color;

		public Node(int val, int N, boolean color) {
			this.val = val;
			this.N = N;
			this.color = color;
		}
	}
}
