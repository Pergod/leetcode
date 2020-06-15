package com.leetcode.list;

import java.util.HashMap;

/**
 * 跳表的一种实现方法。 跳表中存储的是正整数，并且存储的是不重复的。
 * 结合图示理解https://juejin.im/post/57fa935b0e3dd90057c50fbc
 * Author：ZHENG
 */

public class SkipList {

	private static final float SKIPLIST_P = 0.5f;
	// 索引最大层级
	private static final int MAX_LEVEL = 16;
	// 索引层级
	private int levelCount = 1;
	// 带头链表，默认有16个指针
	private Node head = new Node(); 

	/**
	 * 查找
	 * @param value
	 * @return
	 */
	public Node find(int value) {
		Node p = head;
		// 从索引最大层（即第一层索引）开始查找，找到前一节点，通过--i，移动到下层再开始查找
		for (int i = levelCount - 1; i >= 0; --i) {
			// 如果当前层级的节点的值，小于要查询的值，则移动指针到当前层级的下一个节点
			while (p.nextNodes[i] != null && p.nextNodes[i].data < value) {
				// 找到下一节点
				p = p.nextNodes[i];
			}
			// 否则，层级下沉
		}
		// 第0层，也就是最后一层，相当于原始链表层。
		// 如果找到则返回
		if (p.nextNodes[0] != null && p.nextNodes[0].data == value) {
			return p.nextNodes[0];
		} else {
			return null;
		}
	}

	/**
	 * 除了插入数值之外，还需要动态更新跳表索引
	 * @param value
	 */
	public void insert(int value) {
		// 通过一个随机函数，来决定将这个结点插入到哪几级索引中
		int level = randomLevel();
		// 生成新节点
		Node newNode = new Node();
		// 设置当前节点的值
		newNode.data = value;
		// 设置当前节点的最大层级
		newNode.maxLevel = level;
		// 待插新节点在每一层的pre结点数组
		Node preNodes[] = new Node[level];
		for (int i = 0; i < level; ++i) {
			// 默认设置代插入节点的上一个节点为头结点
			preNodes[i] = head;
		}

		Node p = head;
		// 从当前层级开始遍历
		for (int i = level - 1; i >= 0; --i) {
			// 如果当前节点的值，小于待插入的值，则继续移动当前层级的指针到下一个节点
			while (p.nextNodes[i] != null && p.nextNodes[i].data < value) {
				p = p.nextNodes[i];
			}
			// 否则，说明当前节点的值，大于待插入的值。
			// 下沉到下一个层级
			// 并记录每个层级下，上一个节点的位置
			preNodes[i] = p;
		}

		// 从第1层到第level层都需要插入该值
		for (int i = 0; i < level; ++ i) {
			// 记录当前层节点后面节点指针
			newNode.nextNodes[i] = preNodes[i].nextNodes[i];
            // 前一个节点的指针，指向当前节点
			preNodes[i].nextNodes[i] = newNode;
			// 以上操作就是普通的链表插入操作
		}

		// 更新当前索引层的层级数
		if (levelCount < level)
			levelCount = level;
	}

	/**
	 * 除了删除数值之外，还需要动态更新跳表索引
	 * @param value
	 */
	public void delete(int value) {
		Node[] preNodes = new Node[levelCount];
		Node p = head;
		for (int i = levelCount - 1; i >= 0; --i) {
			while (p.nextNodes[i] != null && p.nextNodes[i].data < value) {
				p = p.nextNodes[i];
			}
			preNodes[i] = p;
		}

		if (p.nextNodes[0] != null && p.nextNodes[0].data == value) {
			for (int i = levelCount - 1; i >= 0; --i) {
				if (preNodes[i].nextNodes[i] != null && preNodes[i].nextNodes[i].data == value) {
					preNodes[i].nextNodes[i] = preNodes[i].nextNodes[i].nextNodes[i];
				}
			}
		}

		while (levelCount > 1 && head.nextNodes[levelCount] == null) {
			levelCount--;
		}

	}
	
	// 随机生成层级
	// 理论来讲，一级索引中元素个数应该占原始数据的 50%，二级索引中元素个数占 25%，三级索引12.5% ，一直到最顶层。
	// 因为这里每一层的晋升概率是 50%。对于每一个新插入的节点，都需要调用 randomLevel 生成一个合理的层数。
	// 该 randomLevel 方法会随机生成 1~MAX_LEVEL 之间的数，且 ：
	// 50%的概率返回 1
	// 25%的概率返回 2
	// 12.5%的概率返回 3 ...
	private int randomLevel() {
		int level = 1;
		while (Math.random() < SKIPLIST_P && level < MAX_LEVEL)
			level += 1;
		return level;
	}

	/**
	 * 打印
	 */
	public void printAll() {
		Node p = head;
		while (p.nextNodes[0] != null) {
			System.out.print(p.nextNodes[0] + " ");
			p = p.nextNodes[0];
		}
		System.out.println();
	}

	/**
	 * 节点
	 */
	public class Node {
		private int data = -1;
		// 当前节点在每一层的next节点数组
		// 结合图示理解https://juejin.im/post/57fa935b0e3dd90057c50fbc
		// 每个节点可能下面会存在多个指针
		// 每个层级的指针个数不同，层级越高，指针越多
		private Node nextNodes[] = new Node[MAX_LEVEL];
		private int maxLevel = 0;

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("{ data: ");
			builder.append(data);
			builder.append("; levels: ");
			builder.append(maxLevel);
			builder.append(" }");
			return builder.toString();
		}
	}
	
	public static void main(String[] args) {
		String a = "a";
		System.out.println(a.hashCode());
		HashMap<String, String> map = new HashMap<>();
		map.put("11", "11");
	}
}
