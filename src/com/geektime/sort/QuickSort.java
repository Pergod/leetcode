package com.geektime.sort;

/**
 * ��������
 * @author Flystar
 *
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] nums = new int[]{4,1,2,3,7,6,48,13,24};
		quickSort(nums);
		System.out.println(nums);
	}
	
	// ѡȡ��Ԫ(��λ��)
	public static int middle3(int [] args,int left,int right) {
		int center = (left + right)/2;
		
		// ��ߵ�Ԫ�ش����м�Ԫ�أ����߽��н���
		if (args[left] > args[center]) {
			int temp = args[left];
			args[left] = args[center];
			args[center] = temp;
		}
		
		// ��ߵ�Ԫ�ش����ұߵ�Ԫ�أ����߽��н���
		if (args[left] > args[right]) {
			int temp = args[left];
			args[left] = args[right];
			args[right] = temp;
		}
		
		// �м�Ԫ�ش����ұ�Ԫ�أ����߽��н���
		if (args[center] > args[right]) {
			int temp = args[center];
			args[center] = args[right];
			args[right] = temp;
		}
		// ���ν�����ȷ��a[left] < a[center] < a[right]
		
		// ����λ�������������ұ�ǰһ��λ�ã���Ϊ�������ұ�ȷ��Ϊ��������
		int temp = args[center];
		args[center] = args[right-1];
		args[right-1] = temp;
		// ֻ�迼��a[left+1]...a[right-2]
		return args[right-1];
	}
	
	public static void quickSort(int [] args) {
		int len = args.length;
		qSort(args, 0, len - 1);
	}
	
	public static void qSort(int [] args,int left,int right) {
		// �����ֵ�ֻʣһ��Ԫ��
		if (left >= right) {
            return;
        }
		// ѡȡ��Ԫ
		int pivot = middle3(args,left,right);
		int i = left;
		int j = right - 1;
		while (true) {
			// �Ƚ����Ԫ������Ԫ��С��С�������������ͣ��
			while (args[++i] < pivot) {
				
			}
			// �Ƚ��Ҳ�Ԫ������Ԫ��С�����������������ͣ��
			while (args[--j] > pivot) {
				
			}
			// ���ָ��С���ұ�ָ��Ž���������˵��������ɣ���ֱ���˳�
			if (i < j) {
				// a[i],a[j]���߽��н���
				int temp = args[i];
				args[i] = args[j];
				args[j] = temp;
			}else{
				break;
			}
		}
		// ��a[i],a[r-1]���н�����������Ԫλ�ù̶�
		int temp = args[i];
		args[i] = args[right - 1];
		args[right - 1] = temp;
		// �ݹ�������
		qSort(args,left,i - 1);
		// �ݹ�����ұ�
		qSort(args,i + 1,right);
	}
}
