package com.geektime.search;

public class Sqrt_69 {
	public static void main(String[] args) {
		System.out.println(sqrt_1(8));
		System.out.println(sqrt_2(8));

	}
	
	/**
	 * ֱ����ֵ����
	 * @param num
	 * @return
	 */
	private static int sqrt_1(int num) {
		return (int)Math.floor(Math.sqrt(num));
	}
	
	/**
	 * ���ֲ���
	 */
	private static int sqrt_2(int x) {
		if (x < 2) {
			return x;
		}
		// �� x >= 2 ʱ����������ƽ����һ��С�� x/2 �Ҵ��� 0���� 0 < a < x/2��
		// ���� aһ�������������������ת������������������Ѱ��һ���ض�ֵ����˿���ʹ�ö��ֲ���
		int low = 2;
		int high = x / 2;
		// ע��ѡ���������long!�������������
		long num;
		while (low <= high) {
			// ��ֹ���
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
		// ע�ⷵ�ص�λ��!
		return high;
	}
}
