package com.geektime.search;

/**
 * ���ֲ���������
 * @author Flystar
 *
 */
public class BSearch_Up {
	
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,3,3,4,4,5,6,7,8,9,9,10,14};
//		System.out.println(getFirstMatch(nums,3));
//		System.out.println(getLastMatch(nums,4));
//		System.out.println(getFirstGreater(nums,9));
		System.out.println(getLastSmaller(nums,9));


	}
	
	/**
	 * ���ҵ�һ��ֵ���ڸ���ֵ��Ԫ��
	 * @return
	 */
	public static int getFirstMatch(int[] arr,int val) {
		int n = arr.length - 1;
		int left = 0;
		int right = n;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (arr[mid] > val) {
				right = mid - 1;
			}else if (arr[mid] < val) {
				left = mid + 1;
			// �����λ�õ�ֵ����Ҫ���ҵ�ֵ
			}else if (arr[mid] == val) {
				// д��1: 
				// �����ж�ǰ���ֵ�Ƿ���ڸ�ֵ
//				while (arr[mid - 1] == val) {
//					mid -- ;
//				}
//				return mid;
				
				// д��2: 
				// ����Ѿ��ǵ�һ��λ�ã����ߵ�ǰλ�õ���һ��λ�ò�����val����˵����ǰλ���Ѿ��ǵ�һ�����ڸ���ֵ��Ԫ��
				if (mid == 0 || arr[mid -1] != val) {
					return mid;
				// ���������ǰ�벿�ֻ���
				}else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}
	
	/**
	 * �������һ��ֵ���ڸ���ֵ��Ԫ��
	 * @return
	 */
	public static int getLastMatch(int[] arr,int val) {
		int n = arr.length - 1;
		int left = 0;
		int right = n;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (arr[mid] > val) {
				right = mid - 1;
			}else if (arr[mid] < val) {
				left = mid + 1;
			// �����λ�õ�ֵ����Ҫ���ҵ�ֵ
			}else if (arr[mid] == val) {
				// д��1: �����жϺ����ֵ�Ƿ���ڸ�ֵ
//				while (arr[mid + 1] == val) {
//					mid ++ ;
//				}
//				return mid;
				// д��2: 
				// ����Ѿ��ǵ�һ��λ�ã����ߵ�ǰλ�õ���һ��λ�ò�����val����˵����ǰλ���Ѿ������һ�����ڸ���ֵ��Ԫ��
				if (mid == 0 || arr[mid + 1] != val) {
					return mid;
				// ��������Ӻ�벿�ֻ���
				}else {
					left = mid + 1;
				}
			}
		}
		return -1;
	}
	
	/**
	 * ���ҵ�һ�����ڵ��ڸ���ֵ��Ԫ��
	 */
	public static int getFirstGreater(int[] arr,int val) {
		int n = arr.length - 1;
		int left = 0;
		int right = n;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			// �����λ�õ�ֵ����Ҫ���ҵ�ֵ
			if (arr[mid] > val) {
				// �����һ��λ��С��Ҫ���ҵ�ֵ����˵����ǰλ���Ѿ��ǵ�һ�����ڵ��ڸ���ֵ��Ԫ��
				if (mid == 0 || arr[mid - 1] < val) {
					return mid;
				// �����ǰ�벿�ּ�������
				}else {
					right = mid - 1;
				}
			}else if (arr[mid] < val) {
				left = mid + 1;
			// �����λ�õ�ֵ����Ҫ���ҵ�ֵ
			}else if (arr[mid] == val) {
				// �����һ��λ��С��Ҫ���ҵ�ֵ����˵����ǰλ���Ѿ��ǵ�һ�����ڵ��ڸ���ֵ��Ԫ��
				if (mid == 0 || arr[mid - 1] < val) {
					return mid;
				// �����ǰ�벿�ּ�������
				}else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}
	
	/**
	 * �������һ��С�ڵ��ڸ���ֵ��Ԫ��
	 * @param arr
	 * @return
	 */
	public static int getLastSmaller(int[] arr,int val) {
		int n = arr.length - 1;
		int left = 0;
		int right = n;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (arr[mid] > val) {
				right = mid - 1;
			}else if (arr[mid] < val) {
				left = mid + 1;
				// ����Ѿ��ǵ�һ��λ�ã����ߵ�ǰλ�õ���һ��λ�ô���val����˵����ǰλ���Ѿ������һ��С�ڸ���ֵ��Ԫ��
				if (mid == 0 || arr[mid + 1] > val) {
					return mid;
				// ��������Ӻ�벿�ֻ���
				}else {
					left = mid + 1;
				}
			// �����λ�õ�ֵ����Ҫ���ҵ�ֵ
			}else if (arr[mid] == val) {
				// ����Ѿ��ǵ�һ��λ�ã����ߵ�ǰλ�õ���һ��λ�ô���val����˵����ǰλ���Ѿ������һ��С�ڸ���ֵ��Ԫ��
				if (mid == 0 || arr[mid + 1] > val) {
					return mid;
				// ��������Ӻ�벿�ֻ���
				}else {
					left = mid + 1;
				}
			}
		}
		return -1;
	}
}
