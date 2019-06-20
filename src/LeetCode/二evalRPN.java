package LeetCode;

import java.util.Stack;

/**
 * 问题：在反向波兰表示法中计算算术表达式的值。
 * 有效的运算符是+， - ，*，/。每个操作数可以是整数或另一个表达式。
 * 一些例子：
 * [“2”，“1”，“+”，“3”，“*”]  - >（（2 + 1）* 3） - > 9 
   [“4”，“13”，“5”，“/ “，”+“]  - >（4 +（13/5）） - > 6
 * @author YX
 *
 */
public class 二evalRPN {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for(int i = 0;i<tokens.length;i++) {
			if(tokens[i].equals("+") || tokens[i].equals("-") ||
					tokens[i].equals("*") || tokens[i].equals("/")) {
				int num1 = stack.pop();
				int num2 = stack.pop();
				stack.push(calculate(tokens[i],num1,num2));
			}else {
				int number = Integer.parseInt(tokens[i]);
				stack.push(number);
			}
		}
		return stack.pop();
	}

	private Integer calculate(String string, int num1, int num2) {
		if (string.equals("+")) {
            return num1 + num2;
        }
		if (string.equals("-")) {
			return num1 - num2;
		}
		if (string.equals("*")) {
			return num1 * num2;
		}
		if (string.equals("/")) {
			return num1 / num2;
		}
		return null;
	}
}
