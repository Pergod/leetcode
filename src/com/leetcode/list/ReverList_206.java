package com.leetcode.list;

public class ReverList_206 {
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		reverseList(node);
	}
	
	public static ListNode reverseList(ListNode head) {
		// 空节点或者只有一个节点，此时无需逆转
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = null ;
		ListNode cur = head;
		// 申请一个临时节点（记录当前节点下一个节点的位置）
		ListNode tmp = null;
		while (cur != null) {
			// 记录当前节点下一个节点的位置
			tmp = cur.next;
			// 当前节点的Next指针指向上一个节点
			cur.next = prev;
			// prev节点指向当前节点
			prev = cur;
			// 当前节点移动至下一个节点（即tmp保存的节点）
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