package com.geektime.search;

/**
 * ���ֲ��ң��ǵݹ飩
 * @author Flystar
 *
 */
public class BSearch_1 {
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,4,5,6,7,8,9,14};
		System.out.println(bSearch(nums,6));
	}
	public static int bSearch(int[] arr, int val) {
		// �յ�λ��
		int high = arr.length - 1;
		// ��ʼλ��
		int low = 0;
		// ע���� low <= high��������  low < high
		while (low <= high) {
			// �м�λ��
			// ��Ϊ��� low �� high �Ƚϴ�Ļ�������֮�;��п��ܻ������
			// �Ľ��ķ����ǽ� mid �ļ��㷽ʽд�� low + (high-low) / 2
			// low + ((high-low) >> 1) , ��ȳ���������˵�����������λ����Ҫ��ö࣬ע��>>����������ȼ��ܵͣ�����+��
			int mid = low + (high-low) / 2;
			// ����м�λ�õ���Ҫ�ҵ�ֵ���򷵻��м�λ��
			if (arr[mid] == val) {
				return mid;
			// ����м�λ�ô���Ҫ�ҵ�ֵ��˵����ֵλ����벿��
			// �������յ�λ��Ϊԭ�м�λ�õ�ǰһ��λ��
			}else if (arr[mid] > val) {
				// ���ֱ��д�� low=mid ���� high=mid���Ϳ��ܻᷢ����ѭ����
				// ���磬�� high=3��low=3 ʱ����� a[3]������ value���ͻᵼ��һֱѭ�����˳���
				high = mid - 1;
			// ����м�λ��С��Ҫ�ҵ�ֵ��˵����ֵλ���Ұ벿��
			// ��������ʼλ��Ϊԭ�м�λ�õĺ�һ��λ��
			}else if (arr[mid] < val) {
				low = mid + 1;
			}
		}
		return -1;
	}
}
