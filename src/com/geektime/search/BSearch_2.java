package com.geektime.search;

/**
 * 二分查找（递归）
 * 
 * @author Flystar
 *
 */
public class BSearch_2 {
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 14 };
		System.out.println(bSearch(nums, 6));
	}

	public static int b_Search(int[] arr, int low, int high, int val) {
		int mid = (low + high) / 2;
		if (low > high) {
			return -1;
		}
		if (arr[mid] == val) {
			// 返回位置
			return mid;
		} else if (arr[mid] > val) {
			// 递归查左边（记住要return!）
			return b_Search(arr, low, mid - 1, val);
		} else {
			// 递归查右边（记住要return!）
			return b_Search(arr, mid + 1, high, val);
		}
	}

	public static int bSearch(int[] arr, int val) {
		int high = arr.length - 1;
		return b_Search(arr, 0, high, val);
	}
}
