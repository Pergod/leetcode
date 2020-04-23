package com.leetcode.list;

public class ReverList_206 {
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		reverseList(node);
	}
	
	public static ListNode reverseList(ListNode head) {
		// �սڵ����ֻ��һ���ڵ㣬��ʱ������ת
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = null ;
		ListNode cur = head;
		// ����һ����ʱ�ڵ㣨��¼��ǰ�ڵ���һ���ڵ��λ�ã�
		ListNode tmp = null;
		while (cur != null) {
			// ��¼��ǰ�ڵ���һ���ڵ��λ��
			tmp = cur.next;
			// ��ǰ�ڵ��Nextָ��ָ����һ���ڵ�
			cur.next = prev;
			// prev�ڵ�ָ��ǰ�ڵ�
			prev = cur;
			// ��ǰ�ڵ��ƶ�����һ���ڵ㣨��tmp����Ľڵ㣩
			cur = tmp;
		}
        return prev;
    }
	
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { 
		val = x; 
	}
}