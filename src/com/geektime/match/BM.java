package com.geektime.match;

/**
 * BM字符串匹配算法
 * @author 数据结构与算法课程
 *
 */
public class BM {
	
	// 全局变量或成员变量
	private static final int SIZE = 256;

	// a	主串
	// b	模式串
	// n	主串的长度
	// m	模式串的长度。
	public int bm(char[] a, int n, char[] b, int m) {
		// 记录模式串中每个字符最后出现的位置
		int[] bc = new int[SIZE]; 
		// 构建坏字符哈希表
		generateBC(b, m, bc); 
		// suffix 数组的下标 k，表示后缀子串的长度
		// 下标对应的数组值存储的是，在模式串中跟好后缀{u}相匹配的子串{u*}的起始下标值
		int[] suffix = new int[m];
		// 来记录模式串的后缀子串是否能匹配模式串的前缀子串
		boolean[] prefix = new boolean[m];
		// b表示模式串，m表示长度，suffix，prefix数组事先申请好了
		generateGS(b, m, suffix, prefix);
		int i = 0; // 表示主串与模式串匹配的第一个字符
		while (i <= n - m) {
			int j;
			// 模式串从后往前匹配
			for (j = m - 1; j >= 0; --j) { 
				if (a[i + j] != b[j])
					// 坏字符对应模式串中的下标是j
					break; 
			}
			if (j < 0) {
				// 匹配成功，返回主串与模式串第一个匹配的字符的位置
				return i; 
			}
			int x = j - bc[(int) a[i + j]];
			int y = 0;
			if (j < m - 1) { 
				// 如果有好后缀的话
				y = moveByGS(j, m, suffix, prefix);
			}
			i = i + Math.max(x, y);
		}
		return -1;
	}

	// j表示坏字符对应的模式串中的字符下标; m表示模式串长度
	private int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
		int k = m - 1 - j; // 好后缀长度
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
	 * 1. 在模式串中，查找跟好后缀匹配的另一个子串
	 * 2. 在好后缀的后缀子串中，查找最长的、能跟模式串前缀子串匹配的后缀子串
	 * @param b			模式串
	 * @param m			长度
	 * @param suffix	suffix 数组的下标 k，表示后缀子串的长度，下标对应的数组值存储的是，在模式串中跟好后缀{u}相匹配的子串{u*}的起始下标值
	 * @param prefix	来记录模式串的后缀子串是否能匹配模式串的前缀子串
	 */
	private void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
		// 初始化
		for (int i = 0; i < m; ++i) { 
			suffix[i] = -1;
			prefix[i] = false;
		}
		// b[0, i]，也就是b[0,m-2]
		for (int i = 0; i < m - 1; ++i) { 
			int j = i;
			int k = 0; // 公共后缀子串长度
			while (j >= 0 && b[j] == b[m - 1 - k]) { // 与b[0, m-1]求公共后缀子串
				--j;
				++k;
				// j+1表示公共后缀子串在b[0, i]中的起始下标
				suffix[k] = j + 1; 
			}
			if (j == -1)
				// 如果公共后缀子串也是模式串的前缀子串
				prefix[k] = true; 
		}
	}
	
	public static void main(String[] args) {
		char a = 'a';
		int c = a;
		System.out.println(c);
	}

	/**
	 * 构建坏字符哈希表
	 * @param b		模式串
	 * @param m		模式串的长度
	 * @param bc	散列表
	 */
	private void generateBC(char[] b, int m, int[] bc) {
		// 初始化bc
		for (int i = 0; i < SIZE; ++i) {
			bc[i] = -1; 
		}
		for (int i = 0; i < m; ++i) {
			// 计算b[i]的ASCII值
			// 例如，字符'a'的ascii码值为97
			int ascii = (int) b[i]; 
			// bc[97] = 1，表示字符a的存储位置为1
			bc[ascii] = i;
		}
	}
}
