package Offer;

import java.util.ArrayList;
import java.util.Stack;

import sun.reflect.generics.tree.Tree;

public class 一十六To三十五 {
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
	 * 16、输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
	 * 
	 * @author YX
	 *
	 */
	public class Solution16 {
		public ListNode Merge(ListNode list1, ListNode list2) {
			ListNode head = new ListNode(0);
			ListNode root = head;
			while (list1 != null && list2 != null) {
				if (list1.val < list2.val) {
					root.next = list1;
					list1 = list1.next;
				} else {
					root.next = list2;
					list2 = list2.next;
				}
				root = root.next;
			}
			if (list1 != null) {
				root.next = list1;
			}

			if (list2 != null) {
				root.next = list2;
			}
			return head.next;
		}
	}

	/**
	 * 17、输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
	 * 
	 */
	public static class Solution17 {
		public boolean HasSubtree(TreeNode root1, TreeNode root2) {
			boolean result = false;
			if (root2 != null && root1 != null) {
				// 从根节点开始寻找，是否有tree
				if (root1.val == root2.val) {
					result = search(root1, root2);
				}
				// 根节点不等，比较左子树
				if (!result) {
					result = search(root1.left, root2);
				}
				// 左子树没有，比较与子树
				if (!result) {
					result = search(root1.right, root2);
				}
			}
			return result;
		}

		public static boolean search(TreeNode node1, TreeNode node2) {
			// 如果node2为空
			if (node2 == null) {
				return true;
			}
			// 如果node1为空
			if (node1 == null) {
				return false;
			}

			// 如果val不等
			if (node1.val != node2.val) {
				return false;
			}
			// 其余,比较左子树，比较右子树
			return search(node1.left, node2.left) && search(node1.right, node2.right);
		}

	}

	/**
	 * 18、 题目描述 操作给定的二叉树，将其变换为源二叉树的镜像。 输入描述: 二叉树的镜像定义：左右颠倒
	 */
	public class Solution18 {
		public void Mirror(TreeNode root) {
			// //采用递归，先看一部分
			// TreeNode temp = null;
			// if(root != null){
			// temp = root.left;
			// root.left = root.right;
			// root.right = temp;
			// if(root.left != null)
			// Mirror(root.left);
			// if(root.right != null)
			// Mirror(root.right);
			// }*
			// 非递归版本
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.push(root);
			while (!stack.isEmpty()) {
				TreeNode node = stack.pop();
				if (node.left != null || node.right != null) {
					TreeNode temp = node.left;
					node.left = node.right;
					node.right = temp;
				}
				if (node.left != null)
					stack.push(node.left);
				if (node.right != null)
					stack.push(node.right);
			}

		}
	}

	/**
	 * 19、输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11
	 * 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
	 */
	public class Solution19 {
		public ArrayList<Integer> printMatrix(int[][] matrix) {
			// 行长
			int row = matrix.length;
			// 列长
			int col = matrix[0].length;
			//
			ArrayList<Integer> array = new ArrayList<Integer>();
			if (row == 0 || col == 0) {
				return array;
			}
			int left = 0;
			int right = col - 1;
			int top = 0;
			int bottom = row - 1;
			while (left <= right && top <= bottom) {
				for (int i = left; i <= right; i++) {
					array.add(matrix[top][i]);
				}
				for (int i = top + 1; i <= bottom; i++) {
					array.add(matrix[i][right]);
				}
				if (top != bottom) {
					for (int i = right - 1; i >= left; i--) {
						array.add(matrix[bottom][i]);
					}
				}
				if (left != right) {
					for (int i = bottom - 1; i > top; i--) {
						array.add(matrix[i][left]);
					}
				}
				left++;
				top++;
				right--;
				bottom--;

			}
			return array;
		}
	}

	/**
	 * 20、定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
	 */
	public class Solution20 {
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();

		public void push(int node) {
			stack.push(node);
		}

		public void pop() {
			int p = stack.pop();
		}

		public int top() {
			return stack.peek();
		}

		public int min() {
			int min = Integer.MAX_VALUE;
			while (stack.isEmpty() != true) {
				int node = stack.pop();
				if (node < min) {
					min = node;
				}
				stack2.push(node);
			}
			while (stack2.isEmpty() != true) {
				stack.push(stack2.pop());
			}
			return min;
		}
	}

	/**
	 * 21、输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
	 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
	 */
	public class Solution21 {
		public boolean IsPopOrder(int[] pushA, int[] popA) {
			Stack<Integer> temp = new Stack<Integer>();
			int index = 0;
			for (int i = 0; i < pushA.length; i++) {
				temp.push(pushA[i]);
				while (!temp.isEmpty() && temp.peek() == popA[index]) {
					temp.pop();
					index += 1;
				}
			}
			return temp.isEmpty();
		}
	}

	/**
	 * 22从上往下打印出二叉树的每个节点，同层节点从左至右打印。
	 */
	public class Solution22 {
		public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
			if (root == null) {
				return list;
			}
			queue.add(root);
			while (queue.size() != 0) {
				TreeNode temp = queue.remove(0);
				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}
				list.add(temp.val);
			}
			return list;
		}
	}

	/**
	 * 23、输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
	 */
	public class Solution23 {
		public boolean VerifySquenceOfBST(int[] sequence) {
			int end = sequence.length;
			if (sequence == null || sequence.length == 0) {
				return false;
			}
			return isRight(sequence, 0, end - 1);
		}

		public boolean isRight(int[] arr, int start, int end) {
			int index = end - 1;
			if (start > end) {
				return true;
			}
			while (index > start && arr[index] > arr[end]) {
				index--;
			}
			for (int i = start; i < index; i++) {
				if (arr[i] > arr[end]) {
					return false;
				}
			}
			return isRight(arr, start, index) && isRight(arr, index + 1, end - 1);
		}
	}

	/**
	 * 24、输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
	 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
	 */
	public class Solution24 {
		ArrayList<Integer> path = new ArrayList<>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
			if (root == null) {
				return list;
			}
			path.add(root.val);
			target -= root.val;
			if (target == 0 && root.left == null && root.right == null) {
				list.add(new ArrayList<Integer>(path));
			} else {
				FindPath(root.left, target);
				FindPath(root.right, target);
			}

			path.remove(path.size() - 1);
			return list;
		}
	}

	/**
	 * 25、输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
	 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
	 */
	public class RandomListNode {
		int label;
		RandomListNode next = null;
		RandomListNode random = null;

		RandomListNode(int label) {
			this.label = label;
		}
	}

	public class Solution25 {
		public RandomListNode Clone(RandomListNode pHead) {

			if (pHead == null) {
				return null;
			}
			// 复制节点
			RandomListNode currentNode = pHead;
			while (currentNode != null) {
				RandomListNode cloneNode = new RandomListNode(currentNode.label);
				RandomListNode nextNode = currentNode.next;
				currentNode.next = cloneNode;
				cloneNode.next = nextNode;
				currentNode = nextNode;
			}
			// 遍历节点，分配节点
			currentNode = pHead;
			while (currentNode != null) {
				currentNode.next.random = currentNode.random == null ? null : currentNode.random.next;
				currentNode = currentNode.next.next;
			}
			// 拆分链表
			currentNode = pHead;
			RandomListNode pCloneHead = pHead.next;
			while (currentNode != null) {
				RandomListNode cloneNode = currentNode.next;
				currentNode.next = cloneNode.next;
				cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
				currentNode = currentNode.next;
			}
			return pCloneHead;
		}
	}

	/**
	 * 26、输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
	 */
	public class Solution26 {
		public TreeNode Convert(TreeNode root) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			TreeNode p = root;// p为临时节点，用来遍历树的节点，初始值为根节点
			TreeNode rootList = null;// 用来记录双链表头结点
			TreeNode pre = null;// 保存中序遍历的上一个节点，即为p的上一个节点
			boolean isFirst = true;// 判断是否为左子树链表第一个节点
			while (p != null || !stack.isEmpty()) {
				while (p != null) {
					stack.push(p);
					p = p.left;
				}
				p = stack.pop();
				if (isFirst) {
					rootList = p;
					pre = rootList;
					isFirst = false;
				} else {
					pre.right = p;
					p.left = pre;
					pre = p;
				}
				p = p.right;
			}
			return rootList;
		}

	}
}
