package LeetCode;
/**
 * ʹ�ó����ռ临�Ӷ� ��O��n log n��ʱ���ڶ������������ ˼·��1���鲢���� 2���ҵ��е�
 * 
 * @author YX
 *
 */
public class ��sortList {
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
		// �ü�����
		ListNode midNext = mid.next;
		mid.next = null;
		return Merge(sortList(head), sortList(midNext));
	}

	private ListNode Merge(ListNode n1, ListNode n2) {
		// ����һ�������ڵ�
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
		// �������ƴ����
		cur.next = node1 == null ? node2 : node1;
		//ȥ���ʼ��û�õ�ͷ�ڵ�
		return head.next;
	}

	private ListNode findMid(ListNode head) {
		if (head == null || head.next == null)
			return head;
		// ʹ�ÿ���ָ�
		ListNode quick = head;
		ListNode slow = head;
		while (quick.next != null && quick.next.next != null) {
			quick = quick.next.next;
			slow = slow.next;
		}

		return slow;
	}
}
