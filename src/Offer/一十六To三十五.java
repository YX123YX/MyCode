package Offer;

import java.util.ArrayList;
import java.util.Stack;

import sun.reflect.generics.tree.Tree;

public class һʮ��To��ʮ�� {
	// ���ڵ�
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// ������ڵ�
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	/**
	 * 16�����������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
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
	 * 17���������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
	 * 
	 */
	public static class Solution17 {
		public boolean HasSubtree(TreeNode root1, TreeNode root2) {
			boolean result = false;
			if (root2 != null && root1 != null) {
				// �Ӹ��ڵ㿪ʼѰ�ң��Ƿ���tree
				if (root1.val == root2.val) {
					result = search(root1, root2);
				}
				// ���ڵ㲻�ȣ��Ƚ�������
				if (!result) {
					result = search(root1.left, root2);
				}
				// ������û�У��Ƚ�������
				if (!result) {
					result = search(root1.right, root2);
				}
			}
			return result;
		}

		public static boolean search(TreeNode node1, TreeNode node2) {
			// ���node2Ϊ��
			if (node2 == null) {
				return true;
			}
			// ���node1Ϊ��
			if (node1 == null) {
				return false;
			}

			// ���val����
			if (node1.val != node2.val) {
				return false;
			}
			// ����,�Ƚ����������Ƚ�������
			return search(node1.left, node2.left) && search(node1.right, node2.right);
		}

	}

	/**
	 * 18�� ��Ŀ���� ���������Ķ�����������任ΪԴ�������ľ��� ��������: �������ľ����壺���ҵߵ�
	 */
	public class Solution18 {
		public void Mirror(TreeNode root) {
			// //���õݹ飬�ȿ�һ����
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
			// �ǵݹ�汾
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
	 * 19������һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣����磬�����������4 X 4���� 1 2 3 4 5 6 7 8 9 10 11
	 * 12 13 14 15 16 �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
	 */
	public class Solution19 {
		public ArrayList<Integer> printMatrix(int[][] matrix) {
			// �г�
			int row = matrix.length;
			// �г�
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
	 * 20������ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��������СԪ�ص�min������ʱ�临�Ӷ�ӦΪO��1������
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
	 * 21�����������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ����Ϊ��ջ�ĵ���˳�򡣼���ѹ��ջ���������־�����ȡ���������1,2,3,4,5��ĳջ��ѹ��˳��
	 * ����4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У���4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�
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
	 * 22�������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
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
	 * 23������һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ��������������Yes,�������No���������������������������ֶ�������ͬ��
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
	 * 24������һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
	 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����(ע��: �ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ)
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
	 * 25������һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩��
	 * ���ؽ��Ϊ���ƺ��������head����ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
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
			// ���ƽڵ�
			RandomListNode currentNode = pHead;
			while (currentNode != null) {
				RandomListNode cloneNode = new RandomListNode(currentNode.label);
				RandomListNode nextNode = currentNode.next;
				currentNode.next = cloneNode;
				cloneNode.next = nextNode;
				currentNode = nextNode;
			}
			// �����ڵ㣬����ڵ�
			currentNode = pHead;
			while (currentNode != null) {
				currentNode.next.random = currentNode.random == null ? null : currentNode.random.next;
				currentNode = currentNode.next.next;
			}
			// �������
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
	 * 26������һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
	 */
	public class Solution26 {
		public TreeNode Convert(TreeNode root) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			TreeNode p = root;// pΪ��ʱ�ڵ㣬�����������Ľڵ㣬��ʼֵΪ���ڵ�
			TreeNode rootList = null;// ������¼˫����ͷ���
			TreeNode pre = null;// ���������������һ���ڵ㣬��Ϊp����һ���ڵ�
			boolean isFirst = true;// �ж��Ƿ�Ϊ�����������һ���ڵ�
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
