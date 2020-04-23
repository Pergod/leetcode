package com.leetcode.stack;

import java.util.Stack;

public class MinStack_155 {
	public static void main(String[] args) {
		MinStack_155 s = new MinStack_155();
		s.push(-2);
		s.push(0);
		s.push(-3);
		System.out.println(s.getMin());
		s.getMin();
		s.pop();
		s.top();
		System.out.println(s.top());
		s.getMin();
		System.out.println(s.getMin());
	}

	private Stack<Integer> stack = null;
	private Stack<Integer> minStack = null;

	/** initialize your data structure here. */
	public MinStack_155() {
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}

	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty()) {
			minStack.push(x);
		} else {
			if (x <= minStack.peek()) {
				minStack.push(x);
			}
		}
	}

	public void pop() {
		// pop出来的是integer对象!!!
		// if (stack.pop() == minStack.peek()) {
		// minStack.pop();
		// }
		int pop = stack.pop();
		int top = minStack.peek();
		// 等于的时候再出栈
		if (pop == top) {
			minStack.pop();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}
