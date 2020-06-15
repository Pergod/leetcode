package com.geektime.heap;

/**
 * 堆（完全二叉树）
 * @author Flystar
 *
 */
public class Heap {

	private int[] members;
	// 堆的大小
	private int size;
	// 已经存储的元素个数
	private int exists;

	// 插入
	// 从下往上堆化
	public void insert(int val) {
		if (exists >= size) {
			return;
		}
		members[++exists] = val;
		int index = exists;
		// index / 2 > 0 表示存在父节点
		while (index/2 > 0 && members[index] > members[index/2]) {
			// 交换下标为i和i/2的两个元素 ，代码略
//			swap(members, index, index/2); 
			index /= 2;
		}
	}

	// 移除
	// 从上往下堆化
	// 如果从下往上堆化会引起数组空洞问题
	public int removeMax() {
		if (exists == 0) {
			return -1;
		}
		int index = 1;
		// 第一个元素就是大顶堆的最大的元素
		int max = members[index];
		// 将第一个元素替换成最后一个元素，然后堆化
		members[index] = members[exists];
		--exists;
		while (true) {
			int maxPos = index;
			// 比较左子树
			if (index * 2 <= size && members[index] < members[index * 2]){
				maxPos = index * 2;
			}
			// 比较右子树
			if (index * 2 + 1 <= size && members[maxPos] < members[index * 2 + 1]){
				maxPos = index * 2 + 1;
			}
			// 如maxPos == index，maxPos期间没有变化
			// 说明index就是最大值的元素
			if (maxPos == index){
				break;
			}
			// 交换
			// swap(a, index, maxPos);
			index = maxPos;
		}
		return max;
	}
}
