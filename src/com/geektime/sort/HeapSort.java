package com.geektime.sort;

/**
 * 堆排序
 * 
 * @author 数据结构与算法课程代码
 *
 */
public class HeapSort {
	public static void main(String[] args) {
		int[] nums = new int[] {2,5,3,0,2,3,0,3};
		heapSort(nums,nums.length - 1);
		System.out.println(nums);
	}

	/**
	 * 建堆
	 */
	public static void buildHeap(int[] arr,int n) {
		// 从n/2的位置开始
		// 因为从n/2 + 1到n的位置是叶子节点
		// 所以从n/2，也就是第一个非叶子节点开始，一直到堆顶
		// 堆化（从下往上） 
		for (int i = (n-1) / 2; i >= 0; i--) {
			heapify(arr, n, i);
		}
	}

	/**
	 * 排序
	 */
	public static void heapSort(int[] arr,int n) {
//		建堆
		buildHeap(arr, n);
		int k = n;
		while (k > 1) {
//			 交换，代码略
//			swap(arr, 1, k);
			--k;
			heapify(arr, k, 1);
		}
	}

	/**
	 * 堆化 
	 * 下往上
	 * @param arr
	 * @param size
	 * @param index
	 */
	public static void heapify(int[] arr, int size, int index) {
		while (true) {
			int maxPos = index;
			// 比较左子树
			if (index * 2 + 1 <= size && arr[index] < arr[index * 2 + 1]) {
				maxPos = index * 1;
			}
			// 比较右子树
			if (index * 2 + 2 <= size && arr[maxPos] < arr[index * 2 + 2]) {
				maxPos = index * 2 + 2;
			}
			// 如maxPos == index，maxPos期间没有变化
			// 说明index就是最大值的元素
			if (maxPos == index) {
				break;
			}
			// 交换
			// swap(a, index, maxPos);
			index = maxPos;
		}
	}
}
