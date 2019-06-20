package Offer;

import java.util.Stack;


/**
 * ����һ�ö��������������ҳ����еĵ�kС�Ľ�㡣���磬 ��5��3��7��2��4��6��8�� �У� �������ֵ��С˳�����С����ֵΪ4��
 * 
 * @author YX
 *
 */
public class ��ʮ��_KthNode {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	TreeNode KthNode(TreeNode pRoot, int k) {
		
		if(pRoot == null || k == 0)
			return null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = pRoot;
		int count = 0;
		while(node != null || !stack.isEmpty()) {
			if(node != null) {
				stack.push(node);
				node = node.left;
			}else
				node = stack.pop();
				count++;
				if(count == k) {
					return node;
				}
				node = node.right;
		}
		
		return null;
	}
}
