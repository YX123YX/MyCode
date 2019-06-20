package Offer;

import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;

/**
 * ���⣺����һ�ö����������������ȡ��Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·���� �·���ĳ���Ϊ������ȡ�
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
		int depth = 0;//�������
		int count = 0;//�����������ʼ����
		int nextCount = 1;//��¼��һ���ж��ٸ��ڵ�
		int with = 0;//�����
		
		//��֪����һ�����ĸ�����Ȼ��count++�����ʱ�򣬽���һ��Ĳ��������
		
		while (queue.size() != 0) {
			TreeNode top = queue.poll();
			count++;
			if (top.left != null)
				queue.add(top.left);
			if (top.right != null)
				queue.add(top.right);
			if (count == nextCount) {//����������һ��ѭ��
				nextCount = queue.size();
				count = 0;
				depth++;
			}
			with = Math.max(with, nextCount);
			
		}

		return depth;
	}
}
