package Offer;

import java.util.LinkedHashMap;

import com.sun.swing.internal.plaf.basic.resources.basic;

/**
 * ��һ�����������а����������ҳ�������Ļ�����ڽ�㣬�������null��
 * 
 * @author YX
 *
 */
public class ��ʮ��_EntryNodeOfLoop {
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
