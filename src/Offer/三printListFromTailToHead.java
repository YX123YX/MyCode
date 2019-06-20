package Offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * @author YX
 *
 */
public class 三printListFromTailToHead {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
   }

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
		//利用栈的特性，先进后出原则保存链表值
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
