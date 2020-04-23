package com.geektime.search;

/**
 * 二分查找（非递归）
 * @author Flystar
 *
 */
public class BSearch_1 {
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,4,5,6,7,8,9,14};
		System.out.println(bSearch(nums,6));
	}
	public static int bSearch(int[] arr, int val) {
		// 终点位置
		int high = arr.length - 1;
		// 起始位置
		int low = 0;
		// 注意是 low <= high，而不是  low < high
		while (low <= high) {
			// 中间位置
			// 因为如果 low 和 high 比较大的话，两者之和就有可能会溢出。
			// 改进的方法是将 mid 的计算方式写成 low + (high-low) / 2
			// low + ((high-low) >> 1) , 相比除法运算来说，计算机处理位运算要快得多，注意>>运算符的优先级很低，低于+号
			int mid = low + (high-low) / 2;
			// 如果中间位置等于要找的值，则返回中间位置
			if (arr[mid] == val) {
				return mid;
			// 如果中间位置大于要找的值，说明数值位于左半部分
			// 则设置终点位置为原中间位置的前一个位置
			}else if (arr[mid] > val) {
				// 如果直接写成 low=mid 或者 high=mid，就可能会发生死循环。
				// 比如，当 high=3，low=3 时，如果 a[3]不等于 value，就会导致一直循环不退出。
				high = mid - 1;
			// 如果中间位置小于要找的值，说明数值位于右半部分
			// 则设置起始位置为原中间位置的后一个位置
			}else if (arr[mid] < val) {
				low = mid + 1;
			}
		}
		return -1;
	}
}
