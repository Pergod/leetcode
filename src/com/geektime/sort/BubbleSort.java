package com.geektime.sort;

/**
 * 冒泡排序
 * @author Flystar
 *
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] nums = new int[]{4,1,2,3,7,6,48,13,24};
		bubbleSort(nums);
		System.out.println(nums);
	}
	
	public static void bubbleSort(int[] args){
		boolean flag = true;
		// 需经过多少轮，每轮过后，轮次减一
		for(int i = args.length - 1; i >= 0 ; i--){
			// 每一轮的比较
			for(int j = 0;j < i; j++){
				// 发生交换的条件
				if (args[j] > args[j+1]) {
					int t = args[j];
					args[j] = args[j+1];
					args[j+1] = t;
					flag = false;
				}
			}
		}
		if (flag) {
			return ;
		}
	}
}
