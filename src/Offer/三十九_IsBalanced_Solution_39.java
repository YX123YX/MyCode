package Offer;
/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
import Offer.TreeDepth.TreeNode;

public class 三十九_IsBalanced_Solution_39 {
	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}
	}
	public boolean IsBalanced_Solution(TreeNode root) {
	//判断完全二叉树条件
		if(root == null)
			return false;
		//判断完全二叉树的深度
		if(Math.abs(depth(root.left)-depth(root.right)) > 1)
			return false;
		//相减绝对值大于1
		return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
	}
	private int depth(TreeNode root) {
		if(root == null)
			return 0;
		return Math.max(depth(root.left), depth(root.right))+1;
	}
}
