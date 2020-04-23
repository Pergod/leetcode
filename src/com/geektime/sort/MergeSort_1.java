package com.geektime.sort;

/**
 * �鲢���򣨵ݹ�汾��
 * @author Flystar
 *
 */
public class MergeSort_1 {
	public static void main(String[] args) {
		int[] nums = new int[]{4,1,2,3,7,6,48,13,24};
		mergeSort(nums);
		System.out.println(nums);
	}
	
	// �鲢���
	public static void mergeSort(int [] args){
		int length = args.length;
		int[] tmp = new int[length];
		Msort(args,tmp,0,length - 1);
	}
	
	public static void Msort(int[] args,int[] tmp,int start,int end){
		int center = (start + end)/2;
		if (start < end) {
			// �ݹ鴦����벿��
			Msort(args, tmp, 0, center);
			// �ݹ鴦���Ұ벿��
			Msort(args, tmp, center + 1, end);
			// �ϲ���������
			Merge(args,tmp,start,center + 1,end);
		}
	}
	
	public static void Merge(int[] args,int[] tmp,int lStart,int rStart,int rEnd) {
		int lEnd = rStart - 1;
		int tmpStart = lStart;
		// ��¼Ԫ�ظ���
		int numElements = rEnd - lStart + 1;
		while (lStart <= lEnd && rStart <= rEnd) {
			if (args[lStart] <= args[rStart]) {
				tmp[tmpStart++] = args[lStart++];
			}else{
				tmp[tmpStart++] = args[rStart++];

			}
		}
		// ��ߵ�������Ԫ��ʣ��
		while (lStart <= lEnd) {
			tmp[tmpStart++] = args[lStart++];
		}
		// �ұߵ�������Ԫ��ʣ��
		while (rStart <= rEnd) {
			tmp[tmpStart++] = args[rStart++];
		}
		// ��Ԫ�ص��ص���ʼ���飬�˴��Ǵ��ұߵ��յ�λ�����ص�
		for(int i = 0;i < numElements ; i++, rEnd--){
			args[rEnd] = tmp[rEnd];
		}
	}
}
