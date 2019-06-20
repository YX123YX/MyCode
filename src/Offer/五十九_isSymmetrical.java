package Offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/**
 * ��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
 * 
 * @author YX
 *
 */
public class ��ʮ��_isSymmetrical {
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

	// �����������DFS��ʹ��Stack�ɶԱ���ڵ�
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
			// �ɶԲ���
			stack.push(left.left);
			stack.push(right.right);
			stack.push(left.right);
			stack.push(right.left);
		}
		return true;

	}

	// ���ù������BFS��ʹ��Queue�ɶԱ���ڵ�
	boolean isSymmetrical3(TreeNode pRoot) {

		if (pRoot == null)
			return true;
		Queue<TreeNode> s = new LinkedList<>();
		/**
		 * offer��add���� һЩ�����д�С���ƣ�����������һ�����Ķ����м���һ������������ͻᱻ�ܾ��� ��ʱ�µ� offer
		 * �����Ϳ����������ˡ������ǶԵ��� add() �����׳�һ�� unchecked �쳣����ֻ�ǵõ��� offer() ���ص� false��
		 * 
		 * poll��remove���� remove() �� poll() �������ǴӶ�����ɾ����һ��Ԫ�ء�remove() ����Ϊ�� Collection
		 * �ӿڵİ汾���ƣ� �����µ� poll() �������ÿռ��ϵ���ʱ�����׳��쳣��ֻ�Ƿ��� null������µķ������ʺ����׳����쳣�����������
		 * 
		 * peek��element���� element() �� peek() �����ڶ��е�ͷ����ѯԪ�ء��� remove() �������ƣ��ڶ���Ϊ��ʱ��
		 * element() �׳�һ���쳣���� peek() ���� null
		 */
		s.offer(pRoot.left);
		s.offer(pRoot.right);
		while (!s.isEmpty()) {
			TreeNode right = s.poll();// �ɶ�ȡ��
			TreeNode left = s.poll();
			if (left == null && right == null)
				continue;
			if (left == null || right == null)
				return false;
			if (left.val != right.val)
				return false;
			// �ɶԲ���
			s.offer(left.left);
			s.offer(right.right);
			s.offer(left.right);
			s.offer(right.left);
		}
		return true;
	}
}
