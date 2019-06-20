package Offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 
 * @author YX
 *
 */
public class 五十九_isSymmetrical {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	boolean isSymmetrical(TreeNode pRoot) {
		if (pRoot == null)
			return true;
		return match(pRoot.left, pRoot.right);

	}

	private boolean match(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left != null && right != null) {
			return match(left.left, right.right) && match(left.right, right.left) 
					&& left.val == right.val;
		}
		return false;
	}

	// 采用深度优先DFS，使用Stack成对保存节点
	boolean isSymmetrical2(TreeNode pRoot) {
		if (pRoot == null)
			return true;
		Stack<TreeNode> stack = new Stack<TreeNode>();

		stack.push(pRoot.left);
		stack.push(pRoot.right);
		while (!stack.isEmpty()) {
			TreeNode right = stack.pop();
			TreeNode left = stack.pop();
			if (left == null && right == null)
				return true;
			if (left == null || right == null)
				return false;
			if (left.val != right.val)
				return false;
			// 成对插入
			stack.push(left.left);
			stack.push(right.right);
			stack.push(left.right);
			stack.push(right.left);
		}
		return true;

	}

	// 采用广度优先BFS，使用Queue成对保存节点
	boolean isSymmetrical3(TreeNode pRoot) {

		if (pRoot == null)
			return true;
		Queue<TreeNode> s = new LinkedList<>();
		/**
		 * offer，add区别： 一些队列有大小限制，因此如果想在一个满的队列中加入一个新项，多出的项就会被拒绝。 这时新的 offer
		 * 方法就可以起作用了。它不是对调用 add() 方法抛出一个 unchecked 异常，而只是得到由 offer() 返回的 false。
		 * 
		 * poll，remove区别： remove() 和 poll() 方法都是从队列中删除第一个元素。remove() 的行为与 Collection
		 * 接口的版本相似， 但是新的 poll() 方法在用空集合调用时不是抛出异常，只是返回 null。因此新的方法更适合容易出现异常条件的情况。
		 * 
		 * peek，element区别： element() 和 peek() 用于在队列的头部查询元素。与 remove() 方法类似，在队列为空时，
		 * element() 抛出一个异常，而 peek() 返回 null
		 */
		s.offer(pRoot.left);
		s.offer(pRoot.right);
		while (!s.isEmpty()) {
			TreeNode right = s.poll();// 成对取出
			TreeNode left = s.poll();
			if (left == null && right == null)
				continue;
			if (left == null || right == null)
				return false;
			if (left.val != right.val)
				return false;
			// 成对插入
			s.offer(left.left);
			s.offer(right.right);
			s.offer(left.right);
			s.offer(right.left);
		}
		return true;
	}
}
