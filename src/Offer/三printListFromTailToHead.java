package Offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * ����һ������������ֵ��β��ͷ��˳�򷵻�һ��ArrayList��
 * @author YX
 *
 */
public class ��printListFromTailToHead {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
   }

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
		//����ջ�����ԣ��Ƚ����ԭ�򱣴�����ֵ
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> arrayList = new ArrayList<>();
		if(listNode == null)
			return arrayList;
		while(listNode != null) {
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		while(!stack.isEmpty()) {
			arrayList.add(stack.pop());
		}
		return arrayList;
	}
}
