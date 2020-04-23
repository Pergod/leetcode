package com.geektime.sort;

/**
 * ��������
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
			// ����һ����
			int tmp = args[i];
			int j = i;
			for(; j > 0 && args[j-1] > tmp; j--){
				// ���ǰһ���ƴ��������ƣ���Ѻ�һ������ǰŲ
				args[j] = args[j-1];
			}
			// ȷ�������Ƶ�λ��
			args[j] = tmp;
		}
	}
}
