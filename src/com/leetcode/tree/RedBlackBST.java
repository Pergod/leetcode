package com.leetcode.tree;

/**
 * 红黑树 基于<<算法>>第4版实现
 * 推举动画演示https://www.cs.usfca.edu/~galles/visualization/Algorithms.html
 * 
 * @author Flystar
 */
public class RedBlackBST {

	private Node root;

	/**
	 * 左旋 当该节点的右子树是红色，左子树是黑色时需左旋 具体操作参考书籍277页，图3.3.16
	 * 
	 * @param h
	 * @return
	 */
	private Node rotateLeft(Node h) {
		// 此时的h节点的右子树是红色，也就是x节点是红色
		Node x = h.right;
		h.right = x.left;
		h = x.left;
		// 更新颜色
		x.color = h.color;
		x.color = RED;
		// 更新x的节点个数
		x.N = h.N;
		// 更新h的节点个数
		h.N = size(h.left) + size(h.right) + 1;
		return x;
	}

	/**
	 * 获取树的节点个数
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
	 * 右旋 当该节点的子节点为红色，并且孙子节点也为红色，不允许出现连续的红色节点 具体操作参考书籍277页，图3.3.17
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
	 * 变色
	 * 
	 * @param h
	 */
	private void flipColors(Node h) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}

	/**
	 * 插入数据
	 * 
	 * @param val
	 */
	public void put(int val) {
		root = put(root, val);
		// 红黑树定义，根节点必须是黑色
		root.color = BLACK;
	}

	/**
	 * 判断节点是否是红色
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
			// 和父节点必须用红连接，可以把它理解为构造一个3节点
			return new Node(val, 1, RED);
		}
		if (val < h.val) {
			put(h.left, val);
		} else if (val > h.val) {
			put(h.right, val);
		}
		// 如果右子树为红色，左子树为黑色，左旋
		if (isRed(h.right) && isRed(h.left)) {
			rotateLeft(h);
			// 如果左子树为红色，并且左子树的左子树也为红色，右旋
		} else if (isRed(h.left) && isRed(h.left.left)) {
			rotateRight(h);
			// 如果左子树，右子树都是红色，变色
		} else if (isRed(h.left) && isRed(h.right)) {
			flipColors(h);
		}
		// 更新节点个数
		h.N = size(h.left) + size(h.right) + 1;
		return h;
	}

	/**
	 * 判断是否为空树
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
	 * 删除
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
		// 当目标键小于当前键的时候，我们做类似于寻找最小是的操作，向树左边移动，合并父子结点来消除2-结点
		if(val < h.val){         
            if(h.left == null){
                return null;
            }
            if(isRed(h.left) && !isRed(h.left.left)){
                h = moveRedLeft(h);
            }
            h.left = delete(h.left,val);
        // 当目标键大于当前键的时候，我们向右移动，并做与deleteMax相同的操作，如果相同的话，我们使用和二叉树的删除一样的操作，获取当前键的右子树的最小健，然后交换，并将目标键删除
        }else{               
            if(isRed(h.left)){
                h = rotateRight(h);
            }
            if(val != h.val && h.right == null){    // 我们没有找到目标键，我们将其删除
                return null;
            }
            if(!isRed(h.right) && isRed(h.right.left)){
                h = moveRedRight(h);
            }
            if(val == h.val){
            	// 从右子树获取最小值
                h.val = min(h.right);
                h.right = deleteMin(h.right);
            }
            else h.right = delete(h.right,val);
        }
        return balance(h);
	}
	
	/**
	 * 获取最小值
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
	 * 删除最大值
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
			 * 这里比deleteMin多了一步操作，
			 * 因为右子节点从父节点中获得节点的时候，我们需要将左边节点给于到右边节点，
			 * 如果我们不移动的话，会破坏树的平衡
			 * 5,6 1,2 9
			 * 对于所展示的这个红黑树，如果不把5从左边移到右边的话，我们会直接删除9，这样会导致树的不平衡，因为红节点总是在左边的，我们进行删除操作的时候，直接将结点给予，只需要改变颜色即可，不需要移动
			 * 对于红黑树而言，6是黑结点，再删除的时候，是不需要移动的，我们移动的是5这样的红结点
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
	 * 删除最小值
	 */
	public void deleteMin() {
		if (!isRed(root.left) && !isRed(root.right)) {
			// 如果根节点的左右子节点是2-节点，我们可以将根设为红节点，这样才能进行后面的moveRedLeft操作，因为左子要从根节点借一个
			root.color = RED;
		}
		root = deleteMin(root);
		if (!isEmpty()) {
			// 借完以后，我们将根节点的颜色复原
			root.color = BLACK;
		}
	}

	private Node deleteMin(Node h) {
		if (h.left == null) {
			return null;
		}
		// 判断x的左节点是不是2-节点
		if (!isRed(h.left) && !isRed(h.left)) {
			h = moveRedLeft(h);
		}
		h.left = deleteMin(h.left);
		// 解除临时组成的4-节点
		return balance(h);
	}

	/**
	 * 
	 * @param h
	 * @return
	 */
	private Node moveRedLeft(Node h) {
		flipColors(h);
		// 判断兄弟节点，如果是非红节点，也从兄弟节点中借一个
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
		// 如果右子树为红色，左子树为黑色，左旋
		if (isRed(h.right) && isRed(h.left)) {
			rotateLeft(h);
			// 如果左子树为红色，并且左子树的左子树也为红色，右旋
		} else if (isRed(h.left) && isRed(h.left.left)) {
			rotateRight(h);
			// 如果左子树，右子树都是红色，变色
		} else if (isRed(h.left) && isRed(h.right)) {
			flipColors(h);
		}
		// 更新节点个数
		h.N = size(h.left) + size(h.right) + 1;
		return h;
	}

	// 红色
	private static final boolean RED = true;
	// 黑色
	private static final boolean BLACK = true;

	// 节点
	class Node {
		private int val;
		private Node left;
		private Node right;
		// 这棵树节点的个数
		private int N;
		// 是否是红色
		boolean color;

		public Node(int val, int N, boolean color) {
			this.val = val;
			this.N = N;
			this.color = color;
		}
	}
}
