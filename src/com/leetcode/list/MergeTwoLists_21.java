package com.leetcode.list;

public class MergeTwoLists_21 {
	
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 // 哨兵
		 ListNode prev = new ListNode(-1);
		 ListNode head = prev;
		 while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				prev.next = l1;
				l1 = l1.next;
			}else{
				prev.next = l2;
				l2 = l2.next;
			}
			prev = prev.next;
		}
		// 如果prev指的l1点后已经没有其它节点了，则直接连接l2节点即可
		prev.next = l1 == null ? l2 : l1;
		return head.next;
	 }
}
