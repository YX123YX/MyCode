package Offer;

import java.util.Stack;


/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8） 中， 按结点数值大小顺序第三小结点的值为4。
 * 
 * @author YX
 *
 */
public class 六十三_KthNode {
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
