package com.geektime.sort;

/**
 * ð������
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
		// �辭�������֣�ÿ�ֹ����ִμ�һ
		for(int i = args.length - 1; i >= 0 ; i--){
			// ÿһ�ֵıȽ�
			for(int j = 0;j < i; j++){
				// ��������������
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
