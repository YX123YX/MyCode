package Offer;

import java.util.ArrayList;
import java.util.Stack;

import Offer.TreeDepth.TreeNode;
import Offer.五十七_deleteDuplication.ListNode;



/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印， 第三行按照从左到右的顺序打印，其他行以此类推。
 * 
 * @author YX
 *
 */
public class 六十_Print {
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
		if(pRoot == null)
			return array;
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		stack1.push(pRoot);

		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			if (!stack1.isEmpty()) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				while (!stack1.isEmpty()) {
					TreeNode node = stack1.pop();
					list.add(node.val);
					if (node.right != null)
						stack2.push(node.right);
					if (node.left != null)
						stack2.push(node.left);
				}
				array.add(list);
			} else {
				ArrayList<Integer> aList2 = new ArrayList<Integer>();
				while (!stack2.isEmpty()) {

					TreeNode p = stack2.pop();
					if (p.left != null)
						stack1.add(p.left);
					if (p.right != null)
						stack1.add(p.right);
					aList2.add(p.val);

				}
				array.add(aList2);
			}
		}

		return array;
	}
}
