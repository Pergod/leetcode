package com.geektime.match;

/**
 * BM�ַ���ƥ���㷨
 * @author ���ݽṹ���㷨�γ�
 *
 */
public class BM {
	
	// ȫ�ֱ������Ա����
	private static final int SIZE = 256;

	// a	����
	// b	ģʽ��
	// n	�����ĳ���
	// m	ģʽ���ĳ��ȡ�
	public int bm(char[] a, int n, char[] b, int m) {
		// ��¼ģʽ����ÿ���ַ������ֵ�λ��
		int[] bc = new int[SIZE]; 
		// �������ַ���ϣ��
		generateBC(b, m, bc); 
		// suffix ������±� k����ʾ��׺�Ӵ��ĳ���
		// �±��Ӧ������ֵ�洢���ǣ���ģʽ���и��ú�׺{u}��ƥ����Ӵ�{u*}����ʼ�±�ֵ
		int[] suffix = new int[m];
		// ����¼ģʽ���ĺ�׺�Ӵ��Ƿ���ƥ��ģʽ����ǰ׺�Ӵ�
		boolean[] prefix = new boolean[m];
		// b��ʾģʽ����m��ʾ���ȣ�suffix��prefix���������������
		generateGS(b, m, suffix, prefix);
		int i = 0; // ��ʾ������ģʽ��ƥ��ĵ�һ���ַ�
		while (i <= n - m) {
			int j;
			// ģʽ���Ӻ���ǰƥ��
			for (j = m - 1; j >= 0; --j) { 
				if (a[i + j] != b[j])
					// ���ַ���Ӧģʽ���е��±���j
					break; 
			}
			if (j < 0) {
				// ƥ��ɹ�������������ģʽ����һ��ƥ����ַ���λ��
				return i; 
			}
			int x = j - bc[(int) a[i + j]];
			int y = 0;
			if (j < m - 1) { 
				// ����кú�׺�Ļ�
				y = moveByGS(j, m, suffix, prefix);
			}
			i = i + Math.max(x, y);
		}
		return -1;
	}

	// j��ʾ���ַ���Ӧ��ģʽ���е��ַ��±�; m��ʾģʽ������
	private int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
		int k = m - 1 - j; // �ú�׺����
		if (suffix[k] != -1)
			return j - suffix[k] + 1;
		for (int r = j + 2; r <= m - 1; ++r) {
			if (prefix[m - r] == true) {
				return r;
			}
		}
		return m;
	}

	/**
	 * 1. ��ģʽ���У����Ҹ��ú�׺ƥ�����һ���Ӵ�
	 * 2. �ںú�׺�ĺ�׺�Ӵ��У�������ġ��ܸ�ģʽ��ǰ׺�Ӵ�ƥ��ĺ�׺�Ӵ�
	 * @param b			ģʽ��
	 * @param m			����
	 * @param suffix	suffix ������±� k����ʾ��׺�Ӵ��ĳ��ȣ��±��Ӧ������ֵ�洢���ǣ���ģʽ���и��ú�׺{u}��ƥ����Ӵ�{u*}����ʼ�±�ֵ
	 * @param prefix	����¼ģʽ���ĺ�׺�Ӵ��Ƿ���ƥ��ģʽ����ǰ׺�Ӵ�
	 */
	private void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
		// ��ʼ��
		for (int i = 0; i < m; ++i) { 
			suffix[i] = -1;
			prefix[i] = false;
		}
		// b[0, i]��Ҳ����b[0,m-2]
		for (int i = 0; i < m - 1; ++i) { 
			int j = i;
			int k = 0; // ������׺�Ӵ�����
			while (j >= 0 && b[j] == b[m - 1 - k]) { // ��b[0, m-1]�󹫹���׺�Ӵ�
				--j;
				++k;
				// j+1��ʾ������׺�Ӵ���b[0, i]�е���ʼ�±�
				suffix[k] = j + 1; 
			}
			if (j == -1)
				// ���������׺�Ӵ�Ҳ��ģʽ����ǰ׺�Ӵ�
				prefix[k] = true; 
		}
	}
	
	public static void main(String[] args) {
		char a = 'a';
		int c = a;
		System.out.println(c);
	}

	/**
	 * �������ַ���ϣ��
	 * @param b		ģʽ��
	 * @param m		ģʽ���ĳ���
	 * @param bc	ɢ�б�
	 */
	private void generateBC(char[] b, int m, int[] bc) {
		// ��ʼ��bc
		for (int i = 0; i < SIZE; ++i) {
			bc[i] = -1; 
		}
		for (int i = 0; i < m; ++i) {
			// ����b[i]��ASCIIֵ
			// ���磬�ַ�'a'��ascii��ֵΪ97
			int ascii = (int) b[i]; 
			// bc[97] = 1����ʾ�ַ�a�Ĵ洢λ��Ϊ1
			bc[ascii] = i;
		}
	}
}
