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
			// 交换字符
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
		 // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
	}
}
