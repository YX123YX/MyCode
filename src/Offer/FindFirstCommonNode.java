package Offer;

import java.util.Stack;

public class FindFirstCommonNode {
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if(pHead1 == null || pHead2 == null) 
			return null;
		ListNode l1 = pHead1;
		ListNode l2 = pHead2;
		while(l1 != l2) {
			if(l1 != null)
				l1=l1.next;
			if(l2!=null)
				l2=l2.next;
			if(l1!=l2) {
				if(l1 ==null)
					l1=pHead2;
				if(l2 == null)
					l2=pHead1;
			}
		}
		return l1;
		
		
	}
}
