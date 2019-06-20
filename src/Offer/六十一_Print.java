package Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Offer.六十_Print.TreeNode;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
		 * 压入元素(添加)：add()、offer()
		相同：未超出容量，从队尾压入元素，返回压入的那个元素。
		区别：在超出容量时，add()方法会对抛出异常，offer()返回false
		弹出元素(删除)：remove()、poll()
		相同：容量大于0的时候，删除并返回队头被删除的那个元素。
		区别：在容量为0的时候，remove()会抛出异常，poll()返回false
		获取队头元素(不删除)：element()、peek()
		相同：容量大于0的时候，都返回队头元素。但是不删除。
		区别：容量为0的时候，element()会抛出异常，peek()返回null。

 * @author YX
 *
 */
public class 六十一_Print {
	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node4.left = node7;
		Print(node1);
	}
	public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
		if (pRoot == null)
			return array;
		// 记录奇数层
		Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
		// 记录偶数层
		Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
		queue1.add(pRoot);
		while(!queue1.isEmpty() || !queue2.isEmpty()) {
			if (!queue1.isEmpty()) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				while (!queue1.isEmpty()) {
					TreeNode node = queue1.poll();
					list.add(node.val);
					if (node.left != null)
						queue2.offer(node.left);
					if (node.right != null)
						queue2.offer(node.right);
				}
				array.add(list);
			} else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				while (!queue2.isEmpty()) {
					TreeNode node = queue2.poll();
					list.add(node.val);
					if (node.left != null)
						queue1.offer(node.left);
					if (node.right != null)
						queue1.offer(node.right);
				}
				array.add(list);

			}

		}

		return array;
	}
}
