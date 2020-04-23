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
	// ����õ�ջ������β
	Stack<Integer> leftStack = null;
	// �����õ�ջ��������
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
    	// ������ӵ�stack��Ϊ�գ���ֱ�Ӵӳ��ӵ�stack����Ԫ��
    	// ���������Ԫ�أ�ֱ�ӴӶ��׵�����
    	if (!rightStack.isEmpty()) {
    		front = rightStack.pop();
		}else{
			// ������ӵ�stack�ǿյģ���� ��ӵ�stack���ƶ�Ԫ�ص����ӵ�stack
			while (!leftStack.isEmpty()) {
				rightStack.push(leftStack.pop());
			}
			front = rightStack.pop();
		}
    	return front;
    }
    
    /** Get the front element. */
    public int peek() {
    	// ����ͬ��
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
