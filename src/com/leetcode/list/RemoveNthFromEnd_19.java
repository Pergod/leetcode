package com.leetcode.list;

public class RemoveNthFromEnd_19 {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		removeNthFromEnd(head, 2);
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		int length = 0;
		ListNode first = head;
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
