package com.leetcode.list;

import java.util.HashSet;
import java.util.Set;

public class HasCycle_141 {
	static int pos = 1;
	
	/**
	 * set
	 * @param head
	 * @return
	 */
	public static boolean hasCycle(ListNode1 head) {
		Set<ListNode1> set = new HashSet<ListNode1>();
		while (head != null) {
			if (set.contains(head)) {
				return true;
			}else{
				set.add(head);
			}
			head = head.next;
		}
		return false;
    }
	
	/**
	 * 快慢指针
	 * @param head
	 * @return
	 */
	public static boolean hasCycle2(ListNode1 head) {
		if (head == null || head.next == null) {
			return false;
		}
		// *
		ListNode1 quick = head.next;
		ListNode1 slow = head;
		// 快慢相遇
		while (slow != quick) {
			// 快指针最先到达null
			if (quick == null || quick.next == null) {
				return false;
			}
			// 前进一步
			slow = slow.next;
			// 前进两步
			quick = quick.next.next;
		}
		return true;
    }
	
	
}
