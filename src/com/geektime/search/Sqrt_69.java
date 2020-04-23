package com.geektime.search;

public class Sqrt_69 {
	public static void main(String[] args) {
		System.out.println(sqrt_1(8));
		System.out.println(sqrt_2(8));

	}
	
	/**
	 * 直接求值计算
	 * @param num
	 * @return
	 */
	private static int sqrt_1(int num) {
		return (int)Math.floor(Math.sqrt(num));
	}
	
	/**
	 * 二分查找
	 */
	private static int sqrt_2(int x) {
		if (x < 2) {
			return x;
		}
		// 当 x >= 2 时，它的整数平方根一定小于 x/2 且大于 0，即 0 < a < x/2。
		// 由于 a一定是整数，此问题可以转换成在有序整数集中寻找一个特定值，因此可以使用二分查找
		int low = 2;
		int high = x / 2;
		// 注意选择的类型是long!，否则会有问题
		long num;
		while (low <= high) {
			// 防止溢出
			int mid = low + ((high-low)>>2);
			num = (long) mid*mid;
			if (num == x) {
				return mid;
			}else if(num > x){
				high = mid - 1;
			}else{
				low = mid + 1;
			}
		}
		// 注意返回的位置!
		return high;
	}
}
