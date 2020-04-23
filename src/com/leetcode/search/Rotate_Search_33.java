package com.leetcode.search;

/**
 * ������ת��������
 * @author Flystar
 *
 */
public class Rotate_Search_33 {
	public static void main(String[] args) {
		int[] nums = new int[] {1};
		System.out.println(rotateSearch(nums,9));
	}
	
	public static int rotateSearch(int[] nums, int target) {
		// ���鳤��Ϊ0��ֱ�ӷ���
		if (nums.length == 0) {
			return -1;
		}
		// ���鳤��Ϊ1
		if (nums.length == 1) {
			if (nums[0] == target) {
				return 0;
			}else {
				return -1;
			}
		}
		int right = nums.length - 1;
		int index = -1;
		// Ѱ�ҵ���ת��
		int rotate_inx = findRotateIndex(nums);
		// �жϵ�ǰ��ת���ֵ�Ƿ����Ҫ��ѯ��ֵ
		if (nums[rotate_inx] == target) {
			index = rotate_inx;
		}else {
			// �ݹ����벿��Ѱ�ң����ֲ��ң�
			index = bSearch(nums, 0, rotate_inx - 1, target);
			if (index == -1) {
				// �ݹ���Ұ벿��Ѱ�ң����ֲ��ң�
				index = bSearch(nums, rotate_inx + 1, right, target);
			}
		}
		return index;
	}

	// Ѱ����ת��
	// ��ת����������ұߵ�Ԫ�ر��Լ�С
	public static int findRotateIndex(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		// �������˵�λ��С�����Ҷ�λ�ã�˵�����Ѿ���ȫ������ģ��򲻴�����ת��
		if (arr[left] < arr[right]) {
			return 0;
		}
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			// ����ұߵ������Լ�С��˵�������������ת��
			if ((arr[mid] > arr[mid + 1])) {
				return mid + 1;
			} else {
				// �����ߵ���ֵ�ȵ�ǰ���м�λ�ã�����ֵ��
				// ��Ϊ����������ģ������ߵıȵ�ǰ�Ļ���˵���ò��ֲ�������
				// ˵����ת����ʣ�µ���߲���
				if (arr[mid] < arr[left])
					right = mid - 1;
				// �������ұ߲���
				else
					left = mid + 1;
			}
		}
		return 0;
	}
	
	/**
	 * ��ͨ���ֲ���
	 * @param arr
	 * @param low
	 * @param high
	 * @param val
	 * @return
	 */
	public static int bSearch(int[] arr, int low, int high,int val) {
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
