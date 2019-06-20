package Offer;
/**
 * ����һ�ö��������жϸö������Ƿ���ƽ���������
 */
import Offer.TreeDepth.TreeNode;

public class ��ʮ��_IsBalanced_Solution_39 {
	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}
	}
	public boolean IsBalanced_Solution(TreeNode root) {
	//�ж���ȫ����������
		if(root == null)
			return false;
		//�ж���ȫ�����������
		if(Math.abs(depth(root.left)-depth(root.right)) > 1)
			return false;
		//�������ֵ����1
		return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
	}
	private int depth(TreeNode root) {
		if(root == null)
			return 0;
		return Math.max(depth(root.left), depth(root.right))+1;
	}
}
