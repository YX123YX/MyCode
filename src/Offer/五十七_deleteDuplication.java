package Offer;

import java.util.LinkedHashMap;
import java.util.Map;



/**
 * ��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣 ���磬����1->2->3->3->4->4->5
 * �����Ϊ 1->2->5
 * 
 * @author YX
 *
 */
public class ��ʮ��_deleteDuplication {
	public static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(4);
		ListNode node7 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		System.out.println(deleteDuplication(node1));
	}

	public static ListNode deleteDuplication(ListNode pHead) {
		if(pHead == null || pHead.next == null)
			return pHead;
		if(pHead.val == pHead.next.val) {//��ǰ�ڵ��ظ�
			while(pHead.next != null || pHead.next.val == pHead.val) {
				pHead.next = pHead.next.next;
			}
			return deleteDuplication(pHead.next);
		}else {
			pHead.next = deleteDuplication(pHead.next);
			return pHead;
		}
	}
		
	
}


	
	
/*
LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
if(pHead == null)
	return null;
ListNode cur = pHead;
while(cur != null) {
	if(map.containsKey(cur.val)) {
		map.put(cur.val, map.get(cur.val)+1);
	}else {
		map.put(cur.val, 1);	
	}
	cur = cur.next;
}
ListNode p = pHead;
for(Map.Entry<Integer, Integer> set : map.entrySet()) {
	if(set.getValue() == 1) {
		pHead.val = set.getKey();
		pHead = pHead.next;
	}
}
return p;*/