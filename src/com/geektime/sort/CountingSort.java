package com.geektime.sort;

/**
 * 计数排序
 * 
 * @author Flystar
 *
 */
public class CountingSort {
	public static void main(String[] args) {
		int[] nums = new int[] {2,5,3,0,2,3,0,3};
		countingSort(nums);
		System.out.println(nums);
	}

	public static void countingSort(int[] args) {
		// 数组长度
		int len = args.length;
		int max = args[0];
		// 获取最大值，例如数组为[2，5，3，0，2，3，0，3]，获取最大值5
		for (int i = 1; i < len; i++) {
			if (args[i] > max) {
				max = args[i];
			}
		}

		// 申请数组，例如数组为[2，5，3，0，2，3，0，3]，数组下标 [0,5]
		int[] count = new int[max + 1];
		// 初始化计数数组
		for (int i = 0; i < max; i++) {
			count[i] = 0;
		}

		// 计算每个元素的个数,则count = [2，0，2，3,0,1]
		for (int i = 0; i < len; i++) {
			count[args[i]]++;
		}

		// 依次累加，则count = [2,2,4,7,7,8]
		for (int i = 1; i <= max; i++) {
			count[i] = count[i - 1] + count[i];
		}

		// 申请临时数组，存放排序后的结果
		int[] temp = new int[len];

		// 计算排序的关键步骤，有点难理解
		// 数组args为[2，5，3，0，2，3，0，3]
		// count = [2,2,4,7,7,8]
		for (int i = len - 1; i >= 0; --i) {
			// 从后到前依次扫描数组 args。
			// 比如，当扫描到 3 时，我们可以从数组 count 中取出下标为 3 的值 7，
			// 也就是说，到目前为止，包括自己在内，分数小于等于 3 的考生有 7 个，
			int index = count[args[i]] - 1;
			// 也就是说 3 是数组 args中的第 7 个元素（也就是数组args中下标为 6 的位置）。
			temp[index] = args[i];
			// 当 3 放入到数组 R 中后，小于等于 3 的元素就只剩下了 6 个了，所以相应的 count[3]要减 1，变成 6。
			count[args[i]]--;
		}

		// 将结果导回原数组
		for (int i = 0; i < len; i++) {
			args[i] = temp[i];
		}
	}
}
