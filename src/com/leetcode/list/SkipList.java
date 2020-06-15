package com.leetcode.list;

import java.util.HashMap;

/**
 * �����һ��ʵ�ַ����� �����д洢���������������Ҵ洢���ǲ��ظ��ġ�
 * ���ͼʾ���https://juejin.im/post/57fa935b0e3dd90057c50fbc
 * Author��ZHENG
 */

public class SkipList {

	private static final float SKIPLIST_P = 0.5f;
	// �������㼶
	private static final int MAX_LEVEL = 16;
	// �����㼶
	private int levelCount = 1;
	// ��ͷ����Ĭ����16��ָ��
	private Node head = new Node(); 

	/**
	 * ����
	 * @param value
	 * @return
	 */
	public Node find(int value) {
		Node p = head;
		// ���������㣨����һ����������ʼ���ң��ҵ�ǰһ�ڵ㣬ͨ��--i���ƶ����²��ٿ�ʼ����
		for (int i = levelCount - 1; i >= 0; --i) {
			// �����ǰ�㼶�Ľڵ��ֵ��С��Ҫ��ѯ��ֵ�����ƶ�ָ�뵽��ǰ�㼶����һ���ڵ�
			while (p.nextNodes[i] != null && p.nextNodes[i].data < value) {
				// �ҵ���һ�ڵ�
				p = p.nextNodes[i];
			}
			// ���򣬲㼶�³�
		}
		// ��0�㣬Ҳ�������һ�㣬�൱��ԭʼ����㡣
		// ����ҵ��򷵻�
		if (p.nextNodes[0] != null && p.nextNodes[0].data == value) {
			return p.nextNodes[0];
		} else {
			return null;
		}
	}

	/**
	 * ���˲�����ֵ֮�⣬����Ҫ��̬������������
	 * @param value
	 */
	public void insert(int value) {
		// ͨ��һ���������������������������뵽�ļ���������
		int level = randomLevel();
		// �����½ڵ�
		Node newNode = new Node();
		// ���õ�ǰ�ڵ��ֵ
		newNode.data = value;
		// ���õ�ǰ�ڵ�����㼶
		newNode.maxLevel = level;
		// �����½ڵ���ÿһ���pre�������
		Node preNodes[] = new Node[level];
		for (int i = 0; i < level; ++i) {
			// Ĭ�����ô�����ڵ����һ���ڵ�Ϊͷ���
			preNodes[i] = head;
		}

		Node p = head;
		// �ӵ�ǰ�㼶��ʼ����
		for (int i = level - 1; i >= 0; --i) {
			// �����ǰ�ڵ��ֵ��С�ڴ������ֵ��������ƶ���ǰ�㼶��ָ�뵽��һ���ڵ�
			while (p.nextNodes[i] != null && p.nextNodes[i].data < value) {
				p = p.nextNodes[i];
			}
			// ����˵����ǰ�ڵ��ֵ�����ڴ������ֵ��
			// �³�����һ���㼶
			// ����¼ÿ���㼶�£���һ���ڵ��λ��
			preNodes[i] = p;
		}

		// �ӵ�1�㵽��level�㶼��Ҫ�����ֵ
		for (int i = 0; i < level; ++ i) {
			// ��¼��ǰ��ڵ����ڵ�ָ��
			newNode.nextNodes[i] = preNodes[i].nextNodes[i];
            // ǰһ���ڵ��ָ�룬ָ��ǰ�ڵ�
			preNodes[i].nextNodes[i] = newNode;
			// ���ϲ���������ͨ������������
		}

		// ���µ�ǰ������Ĳ㼶��
		if (levelCount < level)
			levelCount = level;
	}

	/**
	 * ����ɾ����ֵ֮�⣬����Ҫ��̬������������
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
	
	// ������ɲ㼶
	// ����������һ��������Ԫ�ظ���Ӧ��ռԭʼ���ݵ� 50%������������Ԫ�ظ���ռ 25%����������12.5% ��һֱ����㡣
	// ��Ϊ����ÿһ��Ľ��������� 50%������ÿһ���²���Ľڵ㣬����Ҫ���� randomLevel ����һ������Ĳ�����
	// �� randomLevel ������������� 1~MAX_LEVEL ֮��������� ��
	// 50%�ĸ��ʷ��� 1
	// 25%�ĸ��ʷ��� 2
	// 12.5%�ĸ��ʷ��� 3 ...
	private int randomLevel() {
		int level = 1;
		while (Math.random() < SKIPLIST_P && level < MAX_LEVEL)
			level += 1;
		return level;
	}

	/**
	 * ��ӡ
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
	 * �ڵ�
	 */
	public class Node {
		private int data = -1;
		// ��ǰ�ڵ���ÿһ���next�ڵ�����
		// ���ͼʾ���https://juejin.im/post/57fa935b0e3dd90057c50fbc
		// ÿ���ڵ�����������ڶ��ָ��
		// ÿ���㼶��ָ�������ͬ���㼶Խ�ߣ�ָ��Խ��
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
