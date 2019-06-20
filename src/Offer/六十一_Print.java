package Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Offer.��ʮ_Print.TreeNode;

/**
 * ���ϵ��°����ӡ��������ͬһ����������������ÿһ�����һ�С�
		 * ѹ��Ԫ��(���)��add()��offer()
		��ͬ��δ�����������Ӷ�βѹ��Ԫ�أ�����ѹ����Ǹ�Ԫ�ء�
		�����ڳ�������ʱ��add()��������׳��쳣��offer()����false
		����Ԫ��(ɾ��)��remove()��poll()
		��ͬ����������0��ʱ��ɾ�������ض�ͷ��ɾ�����Ǹ�Ԫ�ء�
		����������Ϊ0��ʱ��remove()���׳��쳣��poll()����false
		��ȡ��ͷԪ��(��ɾ��)��element()��peek()
		��ͬ����������0��ʱ�򣬶����ض�ͷԪ�ء����ǲ�ɾ����
		��������Ϊ0��ʱ��element()���׳��쳣��peek()����null��

 * @author YX
 *
 */
public class ��ʮһ_Print {
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
		// ��¼������
		Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
		// ��¼ż����
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
