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
	public static boolean hasCycle(ListNode head) {
		Set<ListNode> set = new HashSet<ListNode>();
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
	 * ����ָ��
	 * @param head
	 * @return
	 */
	public static boolean hasCycle2(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		// *
		ListNode quick = head.next;
		ListNode slow = head;
		// ��������
		while (slow != quick) {
			// ��ָ�����ȵ���null
			if (quick == null || quick.next == null) {
				return false;
			}
			// ǰ��һ��
			slow = slow.next;
			// ǰ������
			quick = quick.next.next;
		}
		return true;
    }
	
	
}
