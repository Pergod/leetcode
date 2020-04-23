package com.geektime.sort;

/**
 * 快速排序
 * @author Flystar
 *
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] nums = new int[]{4,1,2,3,7,6,48,13,24};
		quickSort(nums);
		System.out.println(nums);
	}
	
	// 选取主元(中位数)
	public static int middle3(int [] args,int left,int right) {
		int center = (left + right)/2;
		
		// 左边的元素大于中间元素，两者进行交换
		if (args[left] > args[center]) {
			int temp = args[left];
			args[left] = args[center];
			args[center] = temp;
		}
		
		// 左边的元素大于右边的元素，两者进行交换
		if (args[left] > args[right]) {
			int temp = args[left];
			args[left] = args[right];
			args[right] = temp;
		}
		
		// 中间元素大于右边元素，两者进行交换
		if (args[center] > args[right]) {
			int temp = args[center];
			args[center] = args[right];
			args[right] = temp;
		}
		// 三次交换，确保a[left] < a[center] < a[right]
		
		// 将中位数放置数组最右边前一个位置（因为数组最右边确定为最大的数）
		int temp = args[center];
		args[center] = args[right-1];
		args[right-1] = temp;
		// 只需考虑a[left+1]...a[right-2]
		return args[right-1];
	}
	
	public static void quickSort(int [] args) {
		int len = args.length;
		qSort(args, 0, len - 1);
	}
	
	public static void qSort(int [] args,int left,int right) {
		// 即划分到只剩一个元素
		if (left >= right) {
            return;
        }
		// 选取主元
		int pivot = middle3(args,left,right);
		int i = left;
		int j = right - 1;
		while (true) {
			// 比较左侧元素与主元大小，小于则继续，否则停下
			while (args[++i] < pivot) {
				
			}
			// 比较右侧元素与主元大小，大于则继续，否则停下
			while (args[--j] > pivot) {
				
			}
			// 左边指针小于右边指针才交换，否则说明遍历完成，则直接退出
			if (i < j) {
				// a[i],a[j]两者进行交换
				int temp = args[i];
				args[i] = args[j];
				args[j] = temp;
			}else{
				break;
			}
		}
		// 将a[i],a[r-1]进行交换，即将主元位置固定
		int temp = args[i];
		args[i] = args[right - 1];
		args[right - 1] = temp;
		// 递归调用左边
		qSort(args,left,i - 1);
		// 递归调用右边
		qSort(args,i + 1,right);
	}
}
