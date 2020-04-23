package com.leetcode.stack;

import java.util.Stack;

public class IsValid_20 {
	public static void main(String[] args) {
		System.out.println(isValid("()[]{}"));
	}
	// '('��')'��'{'��'}'��'['��']'
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char symbol = s.charAt(i);
			// �����ţ�ֱ��ѹջ
			if (symbol == '(' || symbol == '{' || symbol == '[') {
				stack.push(symbol);
				// ����������
			} else {
				// ջ�յ�����£����ѹ����������ţ���ʱһ����false
				if (stack.size() == 0) {
					return false;
				}
				// �ж�ջ��Ԫ���뵱ǰ�ַ��Ƿ���ͬһ���͵ķ���
				char top = stack.peek();
				if ((top == '(' && symbol == ')') || (top == '{' && symbol == '}') || (top == '[' && symbol == ']')) {
					stack.pop();
				} else {
					stack.push(symbol);
				}
			}
		}
		if (stack.size() > 0) {
			return false;
		}
		return true;
	}
}
