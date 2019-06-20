package LeetCode;

/**
 * 使用插入排序对链接列表进行排序。
 * 
 * @author YX
 *
 */
public class 五insertionSortList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode insertionSortList(ListNode head) {
		
		if(head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		ListNode cur = head;
		
		while(cur != null) {
			
			ListNode pre = dummy;
			ListNode next = cur.next;
			
			while(pre.next != null && pre.next.val < cur.val)
				pre = pre.next;
			
			cur.next = pre.next;
			pre.next = cur;
			cur= next;
			
		}
		
		return dummy.next;
	}
}
