package com.geektime.sort;

/**
 * ������
 * 
 * @author ���ݽṹ���㷨�γ̴���
 *
 */
public class HeapSort {
	public static void main(String[] args) {
		int[] nums = new int[] {2,5,3,0,2,3,0,3};
		heapSort(nums,nums.length - 1);
		System.out.println(nums);
	}

	/**
	 * ����
	 */
	public static void buildHeap(int[] arr,int n) {
		// ��n/2��λ�ÿ�ʼ
		// ��Ϊ��n/2 + 1��n��λ����Ҷ�ӽڵ�
		// ���Դ�n/2��Ҳ���ǵ�һ����Ҷ�ӽڵ㿪ʼ��һֱ���Ѷ�
		// �ѻ����������ϣ� 
		for (int i = (n-1) / 2; i >= 0; i--) {
			heapify(arr, n, i);
		}
	}

	/**
	 * ����
	 */
	public static void heapSort(int[] arr,int n) {
//		����
		buildHeap(arr, n);
		int k = n;
		while (k > 1) {
//			 ������������
//			swap(arr, 1, k);
			--k;
			heapify(arr, k, 1);
		}
	}

	/**
	 * �ѻ� 
	 * ������
	 * @param arr
	 * @param size
	 * @param index
	 */
	public static void heapify(int[] arr, int size, int index) {
		while (true) {
			int maxPos = index;
			// �Ƚ�������
			if (index * 2 + 1 <= size && arr[index] < arr[index * 2 + 1]) {
				maxPos = index * 1;
			}
			// �Ƚ�������
			if (index * 2 + 2 <= size && arr[maxPos] < arr[index * 2 + 2]) {
				maxPos = index * 2 + 2;
			}
			// ��maxPos == index��maxPos�ڼ�û�б仯
			// ˵��index�������ֵ��Ԫ��
			if (maxPos == index) {
				break;
			}
			// ����
			// swap(a, index, maxPos);
			index = maxPos;
		}
	}
}
