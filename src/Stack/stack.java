package Stack;

import java.util.Stack;

public class stack {
	public static void main(String[] args) {
		Stack stack = new Stack();
		// 1.empty()栈是否为空
		System.out.println(stack.empty());
		// 2.peek()栈顶值 3.进栈push()
		stack.push(new Integer(1));
		stack.push("b");
		//取栈顶值（不出栈）peek()
		System.out.println(stack.peek());
		// 4.pop()出栈
		stack.pop();
		System.out.println(stack.peek());

	}
}
