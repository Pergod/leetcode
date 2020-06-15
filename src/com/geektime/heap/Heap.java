package com.geektime.heap;

/**
 * �ѣ���ȫ��������
 * @author Flystar
 *
 */
public class Heap {

	private int[] members;
	// �ѵĴ�С
	private int size;
	// �Ѿ��洢��Ԫ�ظ���
	private int exists;

	// ����
	// �������϶ѻ�
	public void insert(int val) {
		if (exists >= size) {
			return;
		}
		members[++exists] = val;
		int index = exists;
		// index / 2 > 0 ��ʾ���ڸ��ڵ�
		while (index/2 > 0 && members[index] > members[index/2]) {
			// �����±�Ϊi��i/2������Ԫ�� ��������
//			swap(members, index, index/2); 
			index /= 2;
		}
	}

	// �Ƴ�
	// �������¶ѻ�
	// ����������϶ѻ�����������ն�����
	public int removeMax() {
		if (exists == 0) {
			return -1;
		}
		int index = 1;
		// ��һ��Ԫ�ؾ��Ǵ󶥶ѵ�����Ԫ��
		int max = members[index];
		// ����һ��Ԫ���滻�����һ��Ԫ�أ�Ȼ��ѻ�
		members[index] = members[exists];
		--exists;
		while (true) {
			int maxPos = index;
			// �Ƚ�������
			if (index * 2 <= size && members[index] < members[index * 2]){
				maxPos = index * 2;
			}
			// �Ƚ�������
			if (index * 2 + 1 <= size && members[maxPos] < members[index * 2 + 1]){
				maxPos = index * 2 + 1;
			}
			// ��maxPos == index��maxPos�ڼ�û�б仯
			// ˵��index�������ֵ��Ԫ��
			if (maxPos == index){
				break;
			}
			// ����
			// swap(a, index, maxPos);
			index = maxPos;
		}
		return max;
	}
}
