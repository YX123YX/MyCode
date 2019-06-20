package LeetCode;

import java.util.LinkedList;
import java.util.Queue;


/**
 * �������������ҵ�������С��ȡ���С����ǴӸ��ڵ㵽���Ҷ�ڵ�����·���ϵĽڵ�����
 * 
 * ˼·������������ҵ���һ�����Ҷ�Ϊ�յĽڵ㣬�ͷ��ء�
 * 
 * @author YX
 *
 */
public class һrun {
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
