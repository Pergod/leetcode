package com.geektime.sort;

/**
 * 插入排序
 * @author Flystar
 *
 */
public class InsertSort {
	public static void main(String[] args) {
		int[] nums = new int[]{4,1,2,3,7,6,48,13,24};
		insertSort(nums);
		System.out.println(nums);
	}
	public static void insertSort(int[] args){
		int n = args.length;
		for(int i = 1; i < n ; i++){
			// 摸下一张牌
			int tmp = args[i];
			int j = i;
			for(; j > 0 && args[j-1] > tmp; j--){
				// 如果前一张牌大于摸的牌，则把后一张牌往前挪
				args[j] = args[j-1];
			}
			// 确定该张牌的位置
			args[j] = tmp;
		}
	}
}
