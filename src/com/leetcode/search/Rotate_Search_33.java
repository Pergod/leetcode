package com.leetcode.search;

/**
 * 搜索旋转排序数组
 * @author Flystar
 *
 */
public class Rotate_Search_33 {
	public static void main(String[] args) {
		int[] nums = new int[] {1};
		System.out.println(rotateSearch(nums,9));
	}
	
	public static int rotateSearch(int[] nums, int target) {
		// 数组长度为0，直接返回
		if (nums.length == 0) {
			return -1;
		}
		// 数组长度为1
		if (nums.length == 1) {
			if (nums[0] == target) {
				return 0;
			}else {
				return -1;
			}
		}
		int right = nums.length - 1;
		int index = -1;
		// 寻找到旋转点
		int rotate_inx = findRotateIndex(nums);
		// 判断当前旋转点的值是否等于要查询的值
		if (nums[rotate_inx] == target) {
			index = rotate_inx;
		}else {
			// 递归从左半部分寻找（二分查找）
			index = bSearch(nums, 0, rotate_inx - 1, target);
			if (index == -1) {
				// 递归从右半部分寻找（二分查找）
				index = bSearch(nums, rotate_inx + 1, right, target);
			}
		}
		return index;
	}

	// 寻找旋转点
	// 旋转点的特征，右边的元素比自己小
	public static int findRotateIndex(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		// 如果最左端的位置小于最右端位置，说明是已经是全部有序的，则不存在旋转点
		if (arr[left] < arr[right]) {
			return 0;
		}
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			// 如果右边的数比自己小，说明这个数就是旋转点
			if ((arr[mid] > arr[mid + 1])) {
				return mid + 1;
			} else {
				// 如果左边的数值比当前（中间位置）的数值大
				// 因为数组是升序的，如果左边的比当前的还大，说明该部分不是升序
				// 说明旋转点在剩下的左边部分
				if (arr[mid] < arr[left])
					right = mid - 1;
				// 否则，在右边部分
				else
					left = mid + 1;
			}
		}
		return 0;
	}
	
	/**
	 * 普通二分查找
	 * @param arr
	 * @param low
	 * @param high
	 * @param val
	 * @return
	 */
	public static int bSearch(int[] arr, int low, int high,int val) {
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
