package com.leetcode.stack;

import java.util.Stack;

public class IsValid_20 {
	public static void main(String[] args) {
		System.out.println(isValid("()[]{}"));
	}
	// '('，')'，'{'，'}'，'['，']'
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char symbol = s.charAt(i);
			// 左括号，直接压栈
			if (symbol == '(' || symbol == '{' || symbol == '[') {
				stack.push(symbol);
				// 否则，右括号
			} else {
				// 栈空的情况下，如果压入的是右括号，此时一定是false
				if (stack.size() == 0) {
					return false;
				}
				// 判断栈顶元素与当前字符是否是同一类型的符号
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
