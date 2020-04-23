package com.geektime.sort;

/**
 * ѡ������
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
			// Ĭ�ϵ�ǰ��Ԫ��Ϊ��СԪ�أ���ǰ���±�Ϊ��СԪ�ص������±�
			int minIndex = i;
			int min = args[i];
			for(int j = i + 1; j < n; j++){
				// �����Ԫ�ص�ֵС����СԪ�ص�ֵ����¼��ǰ���±꣬������Сֵ����Ϊ��ǰֵ
				if (args[j] < min) {
					min = args[j];
					minIndex = j;
				}
			}
			// ����СԪ���������δ����Ĳ��ֵĿ�ʼ���±���н���
			int t = args[i];
			args[i] = args[minIndex];
			args[minIndex] = t;
		}
	}
}
