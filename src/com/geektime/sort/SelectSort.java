package com.geektime.sort;

/**
 * 选择排序
 * @author Flystar
 *
 */
public class SelectSort {
	public static void main(String[] args) {
		int[] nums = new int[]{4,1,2,3,7,6,48,13,24};
		selectSort(nums);
		System.out.println(nums);
	}
	
	public static void selectSort(int[] args) {
		int n = args.length;
		for(int i = 0;i < n ;i ++){
			// 默认当前的元素为最小元素，当前的下标为最小元素的数组下标
			int minIndex = i;
			int min = args[i];
			for(int j = i + 1; j < n; j++){
				// 如果该元素的值小于最小元素的值，记录当前的下标，并将最小值设置为当前值
				if (args[j] < min) {
					min = args[j];
					minIndex = j;
				}
			}
			// 将最小元素与数组的未排序的部分的开始的下标进行交换
			int t = args[i];
			args[i] = args[minIndex];
			args[minIndex] = t;
		}
	}
}
