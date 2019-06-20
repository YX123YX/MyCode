package Offer;

import java.util.LinkedHashMap;

import com.sun.swing.internal.plaf.basic.resources.basic;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * 
 * @author YX
 *
 */
public class 五十六_EntryNodeOfLoop {
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode EntryNodeOfLoop(ListNode pHead) {
		LinkedHashMap<ListNode, Integer> map = new LinkedHashMap<ListNode, Integer>();
		ListNode cur = pHead;
		if(cur == null)
			return null;
		while(cur != null) {
			if(map.containsKey(cur)) {
				//map.put(cur, map.get(cur)+1);
				return cur;
			}else {
				map.put(cur, 1);
			}
		
			cur = cur.next;
		}
		return null;
	}
}
