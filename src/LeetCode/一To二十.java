package LeetCode;

import com.sun.scenario.effect.Merge;

import LeetCode.��insertionSortList.ListNode;

public class һTo��ʮ {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	/**
	 * 4��ʹ�ó����ռ临�Ӷ� ��O��n log n��ʱ���ڶ������������ ˼·��1���鲢���� 2���ҵ��е�
	 * 
	 * @author YX
	 *
	 */
	public class Solution4 {
		public ListNode sortList(ListNode head) {
			if (head == null || head.next == null)
				return head;
			ListNode mid = findMid(head);
			// �ü�����
			ListNode midNext = mid.next;
			mid.next = null;
			return Merge(sortList(head), sortList(midNext));
		}

		private ListNode Merge(ListNode sortList, ListNode sortList2) {
			ListNode head = new ListNode(0);
			ListNode node1 = sortList;
			ListNode node2 = sortList2;
			// ����head�ڵ�
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
			// ������ָ�룬����ָ�룬�ҵ������е�
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
	 * 5��ʹ�ò�������������б��������
	 * 
	 * @author YX
	 *
	 */
	public ListNode insertionSortList(ListNode head) {

		// 1.�ж�һ��
		if (head == null || head.next == null) {
			return head;
		}
		// 2.�½�һ������ڵ㣬����Ҫ��
		ListNode dummy = new ListNode(0);
		// 3.currָ��Ľڵ㼰��������нڵ㶼��δ����ģ�ǰ��Ķ����ź����
		ListNode curr = head;
		while (curr != null) {
			// 4.ÿ��ѭ����pre������ָ��dummy��dummy��һ���ڵ㵽currǰһ���ڵ㶼���ź����
			ListNode pre = dummy;
			// 5.����һ�µ�ǰ�ڵ����һ���ڵ������
			ListNode next = curr.next;
			// 6.ÿ�ζ���dummy�ڵ���һ����ʼ�ң�ǰ�涼���ź���ģ����С�ڵ�ǰ�ڵ���ָ����ƣ�һֱ�ҵ�pre.nextΪ��
			// ���߱ȵ�ǰ�ڵ���ʱ��ֹͣ������pre����һ���ڵ���ǵ�ǰ�ڵ�Ӧ�÷ŵ�λ��
			while (pre.next != null && pre.next.val < curr.val) {
				pre = pre.next;
			}
			// 7.�ҵ���ǰ�ڵ�Ӧ�÷ŵ�λ��֮������Ĺ��������ƶ�ָ�룬��curr�嵽pre��pre.next�м�
			// Ȼ����curr����һλ��ǰ�涼���ź����
			curr.next = pre.next;
			pre.next = curr;
			curr = next;
		}
		// 8.dummy���������������Ҫ���ò��������ź��������
		return dummy.next;
	}

}
