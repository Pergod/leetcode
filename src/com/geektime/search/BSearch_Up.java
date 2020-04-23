package com.geektime.search;

/**
 * 二分查找升级版
 * @author Flystar
 *
 */
public class BSearch_Up {
	
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,3,3,4,4,5,6,7,8,9,9,10,14};
//		System.out.println(getFirstMatch(nums,3));
//		System.out.println(getLastMatch(nums,4));
//		System.out.println(getFirstGreater(nums,9));
		System.out.println(getLastSmaller(nums,9));


	}
	
	/**
	 * 查找第一个值等于给定值的元素
	 * @return
	 */
	public static int getFirstMatch(int[] arr,int val) {
		int n = arr.length - 1;
		int left = 0;
		int right = n;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (arr[mid] > val) {
				right = mid - 1;
			}else if (arr[mid] < val) {
				left = mid + 1;
			// 如果该位置的值等于要查找的值
			}else if (arr[mid] == val) {
				// 写法1: 
				// 继续判断前面的值是否等于该值
//				while (arr[mid - 1] == val) {
//					mid -- ;
//				}
//				return mid;
				
				// 写法2: 
				// 如果已经是第一个位置，或者当前位置的上一个位置不等于val，则说明当前位置已经是第一个等于给定值的元素
				if (mid == 0 || arr[mid -1] != val) {
					return mid;
				// 否则继续从前半部分划分
				}else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}
	
	/**
	 * 查找最后一个值等于给定值的元素
	 * @return
	 */
	public static int getLastMatch(int[] arr,int val) {
		int n = arr.length - 1;
		int left = 0;
		int right = n;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (arr[mid] > val) {
				right = mid - 1;
			}else if (arr[mid] < val) {
				left = mid + 1;
			// 如果该位置的值等于要查找的值
			}else if (arr[mid] == val) {
				// 写法1: 继续判断后面的值是否等于该值
//				while (arr[mid + 1] == val) {
//					mid ++ ;
//				}
//				return mid;
				// 写法2: 
				// 如果已经是第一个位置，或者当前位置的上一个位置不等于val，则说明当前位置已经是最后一个等于给定值的元素
				if (mid == 0 || arr[mid + 1] != val) {
					return mid;
				// 否则继续从后半部分划分
				}else {
					left = mid + 1;
				}
			}
		}
		return -1;
	}
	
	/**
	 * 查找第一个大于等于给定值的元素
	 */
	public static int getFirstGreater(int[] arr,int val) {
		int n = arr.length - 1;
		int left = 0;
		int right = n;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			// 如果该位置的值大于要查找的值
			if (arr[mid] > val) {
				// 如果上一个位置小于要查找的值，则说明当前位置已经是第一个大于等于给定值的元素
				if (mid == 0 || arr[mid - 1] < val) {
					return mid;
				// 否则从前半部分继续划分
				}else {
					right = mid - 1;
				}
			}else if (arr[mid] < val) {
				left = mid + 1;
			// 如果该位置的值等于要查找的值
			}else if (arr[mid] == val) {
				// 如果上一个位置小于要查找的值，则说明当前位置已经是第一个大于等于给定值的元素
				if (mid == 0 || arr[mid - 1] < val) {
					return mid;
				// 否则从前半部分继续划分
				}else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}
	
	/**
	 * 查找最后一个小于等于给定值的元素
	 * @param arr
	 * @return
	 */
	public static int getLastSmaller(int[] arr,int val) {
		int n = arr.length - 1;
		int left = 0;
		int right = n;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (arr[mid] > val) {
				right = mid - 1;
			}else if (arr[mid] < val) {
				left = mid + 1;
				// 如果已经是第一个位置，或者当前位置的下一个位置大于val，则说明当前位置已经是最后一个小于给定值的元素
				if (mid == 0 || arr[mid + 1] > val) {
					return mid;
				// 否则继续从后半部分划分
				}else {
					left = mid + 1;
				}
			// 如果该位置的值等于要查找的值
			}else if (arr[mid] == val) {
				// 如果已经是第一个位置，或者当前位置的下一个位置大于val，则说明当前位置已经是最后一个小于给定值的元素
				if (mid == 0 || arr[mid + 1] > val) {
					return mid;
				// 否则继续从后半部分划分
				}else {
					left = mid + 1;
				}
			}
		}
		return -1;
	}
}
