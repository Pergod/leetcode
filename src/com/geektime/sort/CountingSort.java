package com.geektime.sort;

/**
 * ��������
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
		// ���鳤��
		int len = args.length;
		int max = args[0];
		// ��ȡ���ֵ����������Ϊ[2��5��3��0��2��3��0��3]����ȡ���ֵ5
		for (int i = 1; i < len; i++) {
			if (args[i] > max) {
				max = args[i];
			}
		}

		// �������飬��������Ϊ[2��5��3��0��2��3��0��3]�������±� [0,5]
		int[] count = new int[max + 1];
		// ��ʼ����������
		for (int i = 0; i < max; i++) {
			count[i] = 0;
		}

		// ����ÿ��Ԫ�صĸ���,��count = [2��0��2��3,0,1]
		for (int i = 0; i < len; i++) {
			count[args[i]]++;
		}

		// �����ۼӣ���count = [2,2,4,7,7,8]
		for (int i = 1; i <= max; i++) {
			count[i] = count[i - 1] + count[i];
		}

		// ������ʱ���飬��������Ľ��
		int[] temp = new int[len];

		// ��������Ĺؼ����裬�е������
		// ����argsΪ[2��5��3��0��2��3��0��3]
		// count = [2,2,4,7,7,8]
		for (int i = len - 1; i >= 0; --i) {
			// �Ӻ�ǰ����ɨ������ args��
			// ���磬��ɨ�赽 3 ʱ�����ǿ��Դ����� count ��ȡ���±�Ϊ 3 ��ֵ 7��
			// Ҳ����˵����ĿǰΪֹ�������Լ����ڣ�����С�ڵ��� 3 �Ŀ����� 7 ����
			int index = count[args[i]] - 1;
			// Ҳ����˵ 3 ������ args�еĵ� 7 ��Ԫ�أ�Ҳ��������args���±�Ϊ 6 ��λ�ã���
			temp[index] = args[i];
			// �� 3 ���뵽���� R �к�С�ڵ��� 3 ��Ԫ�ؾ�ֻʣ���� 6 ���ˣ�������Ӧ�� count[3]Ҫ�� 1����� 6��
			count[args[i]]--;
		}

		// ���������ԭ����
		for (int i = 0; i < len; i++) {
			args[i] = temp[i];
		}
	}
}
