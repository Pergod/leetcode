package com.geektime.match;

/**
 * BF�����ַ���ƥ��
 * @author Flystar
 *
 */
public class BF {
	
	public static void main(String[] args) {
		System.out.println(bf("baddef", "add"));
	}
	
	public static boolean bf(String main,String com) {
		int len1 = main.length();
		int len2 = com.length();
		int i = 0;
		int j = 0;
		while (i < len1) {
			// �����ǰ���ַ�����ģʽ�ַ����ַ�ƥ��
			// ģʽ�ַ������ַ�ͬʱ�ƶ�����һλ
			if (main.charAt(i) == com.charAt(j)) {
				j ++;
			// �������ַ�������һλ��ģʽ�ַ���0
			}else {
				j = 0;
			}
			i ++ ;
			if (j == len2) {
				return true;
			}
		}
		
		return false;
	}
}
