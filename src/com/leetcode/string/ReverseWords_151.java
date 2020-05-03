package com.leetcode.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords_151 {
	public static void main(String[] args) {
		String s = "a good   example";
		System.out.println(reverseWords2(s));
	}
	
	public static String reverseWords1(String s) {
		String[] arr = s.split(" ");
		int len = arr.length;
		int center = len / 2;
		for(int i = len-1 ;i >= center ;i--){
			int j = len - 1 -i;
			// �����ַ�
			String tmp = arr[j];
			arr[j] = arr[i];
			arr[i] = tmp;
		}
		s = "";
		for(int i = 0 ; i < len ; i++){
			String tmp = arr[i];
			if (!tmp.equals("")) {
				s += tmp;
				s += " ";
			}
		}
		return s;
	}
	
	public static String reverseWords2(String s) {
		 // ��ȥ��ͷ��ĩβ�Ŀհ��ַ�
        s = s.trim();
        // ����ƥ�������Ŀհ��ַ���Ϊ�ָ����ָ�
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
	}
}
