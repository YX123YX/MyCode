package Stack;

import java.util.Stack;

public class stack {
	public static void main(String[] args) {
		Stack stack = new Stack();
		// 1.empty()ջ�Ƿ�Ϊ��
		System.out.println(stack.empty());
		// 2.peek()ջ��ֵ 3.��ջpush()
		stack.push(new Integer(1));
		stack.push("b");
		//ȡջ��ֵ������ջ��peek()
		System.out.println(stack.peek());
		// 4.pop()��ջ
		stack.pop();
		System.out.println(stack.peek());

	}
}
