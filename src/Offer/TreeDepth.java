package Offer;

import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;

/**
 * 问题：输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径， 最长路径的长度为树的深度。
 * 
 * @author YX
 *
 */
public class TreeDepth {
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
		System.out.println(TreeDepth(node1));
	}

	public static int TreeDepth(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int depth = 0;//树的深度
		int count = 0;//最左边子树开始计算
		int nextCount = 1;//记录这一层有多少个节点
		int with = 0;//最大宽度
		
		//先知道下一层树的个数，然后count++，相等时候，结束一层的层序遍历。
		
		while (queue.size() != 0) {
			TreeNode top = queue.poll();
			count++;
			if (top.left != null)
				queue.add(top.left);
			if (top.right != null)
				queue.add(top.right);
			if (count == nextCount) {//用来结束这一层循环
				nextCount = queue.size();
				count = 0;
				depth++;
			}
			with = Math.max(with, nextCount);
			
		}

		return depth;
	}
}
