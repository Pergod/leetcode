package com.leetcode.list;

import java.math.BigDecimal;

public class AddTwoNumbers_2 {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		BigDecimal n1 = new BigDecimal(0);
		int cnt = 0;
		while (l1 != null) {
			n1 = n1.add(new BigDecimal(l1.val).multiply(new BigDecimal(10).pow(cnt)));
			++ cnt;
			l1 = l1.next;
		}
		BigDecimal n2 = new BigDecimal(0);
		cnt = 0;
		while (l2 != null) {
			n2 = n2.add(new BigDecimal(l2.val).multiply(new BigDecimal(10).pow(cnt)));
			++ cnt;
			l2 = l2.next;
		}
		cnt = 0;
		BigDecimal num = new BigDecimal(0);
		num = num.add(n1).add(n2);
		BigDecimal re = num.divideAndRemainder(new BigDecimal(10))[1];
		ListNode head = new ListNode(re.intValue());
		ListNode tmp = head;
		while (num.compareTo(new BigDecimal(10)) > 0) {
			num = num.divide(new BigDecimal(10));
			re = num.divideAndRemainder(new BigDecimal(10))[1];
			ListNode node = new ListNode(re.intValue());
			tmp.next = node;
			tmp = node;
		}
		return head;
    }

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
