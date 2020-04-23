package com.leetcode.stack;

import java.util.Stack;

public class MyQueue_232 {
	public static void main(String[] args) {
		MyQueue_232 queue = new MyQueue_232();
		queue.push(1);
		queue.push(2);  
		queue.peek(); 
		System.out.println(queue.peek());
		System.out.println(queue.pop());
		System.out.println(queue.empty());
	}
	// 入队用的栈，即队尾
	Stack<Integer> leftStack = null;
	// 出队用的栈，即队首
	Stack<Integer> rightStack = null;
	int front ;
	/** Initialize your data structure here. */
    public MyQueue_232() {
    	leftStack = new Stack<Integer>();
    	rightStack = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	leftStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	// 如果出队的stack不为空，则直接从出队的stack弹出元素
    	// 如果队首有元素，直接从队首弹出。
    	if (!rightStack.isEmpty()) {
    		front = rightStack.pop();
		}else{
			// 如果出队的stack是空的，则从 入队的stack中移动元素到出队的stack
			while (!leftStack.isEmpty()) {
				rightStack.push(leftStack.pop());
			}
			front = rightStack.pop();
		}
    	return front;
    }
    
    /** Get the front element. */
    public int peek() {
    	// 与上同理
    	if (!rightStack.isEmpty()) {
    		front = rightStack.peek();
		}else{
			while (!leftStack.isEmpty()) {
				rightStack.push(leftStack.pop());
			}
			front = rightStack.peek();
		}
    	return front;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
    	return rightStack.isEmpty() && leftStack.isEmpty();
    }
}
