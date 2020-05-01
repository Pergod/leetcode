package com.geektime.match;

/**
 * BF暴力字符串匹配
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
			// 如果当前主字符，与模式字符的字符匹配
			// 模式字符与主字符同时移动到下一位
			if (main.charAt(i) == com.charAt(j)) {
				j ++;
			// 否则主字符跳到下一位，模式字符归0
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
