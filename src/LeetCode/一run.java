package LeetCode;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 给定二叉树，找到它的最小深度。最小深度是从根节点到最近叶节点的最短路径上的节点数。
 * 
 * 思路：层序遍历，找到第一个左右都为空的节点，就返回。
 * 
 * @author YX
 *
 */
public class 一run {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int run(TreeNode root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		
		int depth = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			int len = queue.size();
			depth++;
			for(int i = 0 ;i < len;i++) {
				TreeNode cur = queue.poll();
				if(cur.left == null && cur.right == null) 
					return depth;
				if(cur.left != null)
					queue.offer(cur.left);
				if(cur.right != null)
					queue.offer(cur.right);
			}
		}
		return 0;
	}
}
