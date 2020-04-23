package com.geektime.sort;

/**
 * 归并排序（递归版本）
 * @author Flystar
 *
 */
public class MergeSort_1 {
	public static void main(String[] args) {
		int[] nums = new int[]{4,1,2,3,7,6,48,13,24};
		mergeSort(nums);
		System.out.println(nums);
	}
	
	// 归并入口
	public static void mergeSort(int [] args){
		int length = args.length;
		int[] tmp = new int[length];
		Msort(args,tmp,0,length - 1);
	}
	
	public static void Msort(int[] args,int[] tmp,int start,int end){
		int center = (start + end)/2;
		if (start < end) {
			// 递归处理左半部分
			Msort(args, tmp, 0, center);
			// 递归处理右半部分
			Msort(args, tmp, center + 1, end);
			// 合并左，右数组
			Merge(args,tmp,start,center + 1,end);
		}
	}
	
	public static void Merge(int[] args,int[] tmp,int lStart,int rStart,int rEnd) {
		int lEnd = rStart - 1;
		int tmpStart = lStart;
		// 记录元素个数
		int numElements = rEnd - lStart + 1;
		while (lStart <= lEnd && rStart <= rEnd) {
			if (args[lStart] <= args[rStart]) {
				tmp[tmpStart++] = args[lStart++];
			}else{
				tmp[tmpStart++] = args[rStart++];

			}
		}
		// 左边的数组有元素剩余
		while (lStart <= lEnd) {
			tmp[tmpStart++] = args[lStart++];
		}
		// 右边的数组有元素剩余
		while (rStart <= rEnd) {
			tmp[tmpStart++] = args[rStart++];
		}
		// 将元素导回到初始数组，此处是从右边的终点位置往回导
		for(int i = 0;i < numElements ; i++, rEnd--){
			args[rEnd] = tmp[rEnd];
		}
	}
}
