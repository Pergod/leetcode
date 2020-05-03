package com.leetcode.string;

public class ReverseString_344 {
	
	public static void main(String[] args) {
		char[] e = new char[]{'h','e','l','l'};
		reverseString(e);
		System.out.println(e);
	}
	
	public static void reverseString(char[] s) {
		int len = s.length;
		int center = len / 2;
		for(int i = len-1 ;i >= center ;i--){
			int j = len - 1 -i;
			// ½»»»×Ö·û
			char tmp = s[j];
			s[j] = s[i];
			s[i] = tmp;
		}
    }
}
