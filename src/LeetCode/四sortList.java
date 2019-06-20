package LeetCode;
/**
 * 使用常量空间复杂度 在O（n log n）时间内对链表进行排序。 思路：1、归并排序 2、找到中点
 * 
 * @author YX
 *
 */
public class 四sortList {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode sortList(ListNode head) {

		if (head == null || head.next == null)
			return head;
		ListNode mid = findMid(head);
		// 裁剪链表
		ListNode midNext = mid.next;
		mid.next = null;
		return Merge(sortList(head), sortList(midNext));
	}

	private ListNode Merge(ListNode n1, ListNode n2) {
		// 建立一个辅助节点
		ListNode head = new ListNode(0);
		ListNode cur = head;
		ListNode node1 = n1;
		ListNode node2 = n2;
		while (node1 != null && node2 != null) {
			if (node1.val < node2.val) {
				cur.next = node1;
				node1 = node1.next;
			} else {
				cur.next = node2;
				node2 = node2.next;
			}
			cur = cur.next;
		}
		// 将多余的拼接上
		cur.next = node1 == null ? node2 : node1;
		//去除最开始的没用的头节点
		return head.next;
	}

	private ListNode findMid(ListNode head) {
		if (head == null || head.next == null)
			return head;
		// 使用快慢指針
		ListNode quick = head;
		ListNode slow = head;
		while (quick.next != null && quick.next.next != null) {
			quick = quick.next.next;
			slow = slow.next;
		}

		return slow;
	}
}
