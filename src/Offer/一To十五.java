package Offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 一To十五 {
	// 树节点
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// 单链表节点
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	/**
	 * 4、输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
	 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
	 * 
	 * 思路：每次找到一层根节点。依次往下。
	 */
	public class Solution4 {
		public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
			if (pre == null && in == null)
				return null;
			// 用来存放中序遍历每个节点值的位置上，根节点位置
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 0; i < in.length; i++) {
				map.put(in[i], i);
			}
			return preInt(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
		}

		private TreeNode preInt(int[] pre, int pi, int pj, int[] in, int ni, int nj, Map<Integer, Integer> map) {
			// 寻找每部分的根节点
			TreeNode head = new TreeNode(pre[pi]);
			int index = map.get(pre[pi]);
			// 左子树根节点
			head.left = preInt(pre, pi + 1, index - ni + pi, in, ni, index - 1, map);
			// 右子树根节点
			head.right = preInt(pre, index - ni + pi + 1, pj, in, index + 1, nj, map);
			return head;
		}
	}

	/**
	 * 5、用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
	 */
	public class Solution5 {
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();

		public void push(int node) {
			stack1.push(node);
		}

		public int pop() {
			if (stack2.empty()) {
				while (!stack1.empty()) {
					stack2.push(stack1.pop());
				}
			}
			return stack2.pop();
		}
	}

	/**
	 * 6、把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
	 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
	 */
	public class Solution6 {
		public int minNumberInRotateArray(int[] rotateArray) {
			// 采用二分法解决问题
			if (rotateArray == null || rotateArray.length == 0)
				return 0;
			int left = 0;
			int right = rotateArray.length - 1;

			while (left < right) {

				// 确认子数组是否是类似1,1,2,4,5,..,7的非递减数组
				if (rotateArray[left] < rotateArray[right])
					return rotateArray[left];

				int mid = left + (right - left) / 2;
				// 如果左半数组为有序数组
				if (rotateArray[left] < rotateArray[mid])
					left = mid + 1;
				// 如果右半数组为有序数组
				else if (rotateArray[mid] < rotateArray[right])
					right = mid;
				// 否则，rotateArray[left] == rotateArray[mid] == rotateArray[right]
				else {
					++left;
				}
			}
			return rotateArray[left];
		}
	}

	/**
	 * 7、大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。 n<=39
	 */
	public class Solution7 {
		public int Fibonacci(int n) {
			if (n == 0) {
				return 0;
			}
			if (n == 1) {
				return 1;
			}
			return Fibonacci(n - 1) + Fibonacci(n - 2);
		}
	}

	/**
	 * 8、一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。 递归和迭代区别：
	 * 从概念上讲，递归就是指程序调用自身的编程思想，即一个函数调用本身；迭代是利用已知的变量值，根据递推公式不断演进得到变量新值得编程思想。
	 */
	public class Solution8 {
		public int JumpFloor(int target) {
			if (target == 0 || target < 0) {
				return 0;
			}
			if (target == 1) {
				return 1;
			}
			if (target == 2) {
				return 2;
			}
			// return JumpFloor(target-1) + JumpFloor(target-2);
			// ---------------------------迭代版本--------------------------------------------
			int sum = 0;
			int step1 = 1;
			int step2 = 2;
			for (int i = 3; i <= target; i++) {
				sum = step1 + step2;
				step2 = step1;
				step1 = sum;
			}
			return sum;
		}
	}

	/**
	 * 9、一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
	 */
	public class Solution9 {
		public int JumpFloorII(int target) {
			if (target <= 0) {
				return 0;
			}
			if (target == 1) {
				return 1;
			}
			if (target == 2) {
				return 2;
			}

			return 2 * JumpFloorII(target - 1);

		}
	}

	/**
	 * 10、我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
	 * 
	 */
	public class Solution10 {
		public int RectCover(int target) {
			if (target <= 0) {
				return 0;
			}
			if (target == 1) {
				return 1;
			}
			if (target == 2) {
				return 2;
			}
			return RectCover(target - 1) + RectCover(target - 2);

		}
	}

	/**
	 * 11、输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
	 */
	public class Solution11 {
		public int NumberOf1(int n) {
			int num = 0;
			// Integer.toBinaryString 返回二进制字符串
			String str = Integer.toBinaryString(n);
			char[] chars = str.toCharArray();
			int i = 0;
			for (; i < str.length(); i++) {
				if (chars[i] == '1') {
					num++;
				}
			}
			return num;
		}
	}

	/**
	 * 12、给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。 思路：考虑exponent的正负
	 */
	public class Solution12 {
		public double Power(double base, int exponent) {
			double result = 1.0;
			if (exponent == 0) {
				return 1;
			} else if (exponent > 0) {
				for (int i = 1; i <= exponent; i++) {
					result = result * base;
				}
			} else {
				if (base == 0)
					throw new RuntimeException("出错了");
				for (int i = 1; i <= -exponent; i++) {
					result = result * base;
				}
			}
			return exponent > 0 ? result : 1 / result;
		}
	}

	/**
	 * 13、输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
	 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
	 */
	public class Solution13 {
		public void reOrderArray(int[] array) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; i < array.length - i - 1; j++) {
					if (array[j] % 2 == 0 && array[j + 1] % 2 != 0) {
						swap(array, j, j + 1);
					}
				}
			}
		}

		private void swap(int[] array, int j, int i) {
			int temp = array[j];
			array[j] = array[i];
			array[i] = temp;
		}
	}

	/**
	 * 14、输入一个链表，输出该链表中倒数第k个结点。
	 */
	public class Solution14 {
		public ListNode FindKthToTail(ListNode head, int k) {
			// 建两个节点
			ListNode p = null;
			ListNode pre = null;
			p = head;
			pre = head;
			// 记录k值
			int a = k;
			// 记录节点个数
			int count = 0;
			while (p != null) {
				p = p.next;
				count++;
				if (k < 1) {
					pre = pre.next;
				}
				k--;
			}
			if (count < a) {
				return null;
			}
			return pre;
		}
	}

	/**
	 * 15、输入一个链表，反转链表后，输出新链表的表头。
	 */
	public class Solution15 {
		public ListNode ReverseList(ListNode head) {

			if (head == null)
				return null;
			// head为当前节点，如果当前节点为空的话，那就什么也不做，直接返回null；
			ListNode pre = null;
			ListNode next = null;
			// 当前节点是head，pre为当前节点的前一节点，next为当前节点的下一节点
			// 需要pre和next的目的是让当前节点从pre->head->next1->next2变成pre<-head next1->next2
			// 即pre让节点可以反转所指方向，但反转之后如果不用next节点保存next1节点的话，此单链表就此断开了
			// 所以需要用到pre和next两个节点
			// 1->2->3->4->5
			// 1<-2<-3 4->5
			while (head != null) {
				// 做循环，如果当前节点不为空的话，始终执行此循环，此循环的目的就是让当前节点从指向next到指向pre
				// 如此就可以做到反转链表的效果
				// 先用next保存head的下一个节点的信息，保证单链表不会因为失去head节点的原next节点而就此断裂
				next = head.next;
				// 保存完next，就可以让head从指向next变成指向pre了，代码如下
				head.next = pre;
				// head指向pre后，就继续依次反转下一个节点
				// 让pre，head，next依次向后移动一个节点，继续下一次的指针反转
				pre = head;
				head = next;
			}
			// 如果head为null的时候，pre就为最后一个节点了，但是链表已经反转完毕，pre就是反转后链表的第一个节点
			// 直接输出pre就是我们想要得到的反转后的链表
			return pre;

		}
	}
}
