package LeetCode;

import com.sun.scenario.effect.Merge;

import LeetCode.五insertionSortList.ListNode;

public class 一To二十 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	/**
	 * 4、使用常量空间复杂度 在O（n log n）时间内对链表进行排序。 思路：1、归并排序 2、找到中点
	 * 
	 * @author YX
	 *
	 */
	public class Solution4 {
		public ListNode sortList(ListNode head) {
			if (head == null || head.next == null)
				return head;
			ListNode mid = findMid(head);
			// 裁剪链表
			ListNode midNext = mid.next;
			mid.next = null;
			return Merge(sortList(head), sortList(midNext));
		}

		private ListNode Merge(ListNode sortList, ListNode sortList2) {
			ListNode head = new ListNode(0);
			ListNode node1 = sortList;
			ListNode node2 = sortList2;
			// 保存head节点
			ListNode cur = head;
			while (node1 != null && node2 != null) {
				if (node1.val < node2.val) {
					cur.next = node1;
					node1 = node1.next;
				} else if (node1.val > node2.val) {
					cur.next = node2;
					node2 = node2.next;
				} else {
					cur = cur.next;
				}
			}
			cur.next = node1 == null ? node2 : node1;

			return head.next;
		}

		private ListNode findMid(ListNode head) {
			// 拿两个指针，快慢指针，找到链表中点
			ListNode quick = head;
			ListNode slow = head;
			while (quick.next != null && quick.next.next != null) {
				quick = quick.next.next;
				slow = slow.next;
			}
			return slow;
		}
	}

	/**
	 * 5、使用插入排序对链接列表进行排序。
	 * 
	 * @author YX
	 *
	 */
	public ListNode insertionSortList(ListNode head) {

		// 1.判断一下
		if (head == null || head.next == null) {
			return head;
		}
		// 2.新建一个虚拟节点，后面要用
		ListNode dummy = new ListNode(0);
		// 3.curr指向的节点及其后面所有节点都是未排序的，前面的都是排好序的
		ListNode curr = head;
		while (curr != null) {
			// 4.每次循环，pre都重新指向dummy，dummy后一个节点到curr前一个节点都是排好序的
			ListNode pre = dummy;
			// 5.保存一下当前节点后面一个节点的引用
			ListNode next = curr.next;
			// 6.每次都从dummy节点下一个开始找，前面都是排好序的，如果小于当前节点则指针后移，一直找到pre.next为空
			// 或者比当前节点大的时候，停止，表明pre的下一个节点就是当前节点应该放的位置
			while (pre.next != null && pre.next.val < curr.val) {
				pre = pre.next;
			}
			// 7.找到当前节点应该放的位置之后，下面的工作就是移动指针，让curr插到pre和pre.next中间
			// 然后让curr后移一位，前面都是排好序的
			curr.next = pre.next;
			pre.next = curr;
			curr = next;
		}
		// 8.dummy后面就是我们所需要的用插入排序排好序的链表
		return dummy.next;
	}

}
