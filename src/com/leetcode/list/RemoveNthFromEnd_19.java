package com.leetcode.list;

public class RemoveNthFromEnd_19 {
	public static void main(String[] args) {
		ListNode1 head = new ListNode1(1);
		removeNthFromEnd(head, 2);
	}

	public static ListNode1 removeNthFromEnd(ListNode1 head, int n) {
		ListNode1 dummy = new ListNode1(0);
		dummy.next = head;
		int length = 0;
		ListNode1 first = head;
		while (first != null) {
			length++;
			first = first.next;
		}
		length -= n;
		first = dummy;
		while (length > 0) {
			length--;
			first = first.next;
		}
		first.next = first.next.next;
		return dummy.next;
	}

}
