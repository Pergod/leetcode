package com.leetcode.stack;

import java.util.Stack;

public class BackspaceCompare_844 {
	public static void main(String[] args) {
		String S = "ab##";
		String T = "c#d#";
		System.out.println(backspaceCompare(S,T));
	}
	static Stack<Character> s1 = new Stack<Character>();
	static Stack<Character> s2 = new Stack<Character>();

	public static boolean backspaceCompare(String S, String T) {
		boolean flag = true;
		for(int i = 0;i<S.length();i++){
			if (S.charAt(i) == '#') {
				if (!s1.isEmpty()) {
					s1.pop();
				}
			}else {
				s1.push(S.charAt(i));
			}
		}
		for(int i = 0;i<T.length();i++){
			if (T.charAt(i) == '#') {
				if (!s2.isEmpty()) {
					s2.pop();
				}
			}else {
				s2.push(T.charAt(i));
			}
		}
		
		if (s1.size() != s2.size()) {
			return false;
		}else {
			while (!s1.isEmpty()) {
				if (s1.pop() != s2.pop()) {
					flag = false;
				}
			}
		}
		return flag;
    }
}
