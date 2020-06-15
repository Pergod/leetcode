package com.leetcode.list;

public class MiddleNode_876 {
	public ListNode1 middleNode(ListNode1 head) {
		ListNode1 first = head;
		int size = 0;
		while (first != null) {
			++ size;
			first = first.next;
		}
		int m = (int) Math.floor(size/2.0);
		first = head;
		size = 0;
		while (first != null) {
			if (size == m) {
				return first;
			}
			++ size;
			first = first.next;
		}
		return head;
    }
}
