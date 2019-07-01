package LeetCode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import org.junit.Test;

import com.sun.org.apache.regexp.internal.recompile;
import com.sun.scenario.effect.Merge;

import Offer.TreeDepth.TreeNode;
import Stack.stack;
import sun.launcher.resources.launcher;
import sun.security.util.Length;

public class 一To二十 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
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
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node4.left = node8;
		node4.right = node9;

		TreeNode treeNode = getParent(node1, node8, node5);
	}

	public static TreeNode getParent(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null || node1 == null || node2 == null)
			return null;
		// 这里可以换成if(root == node1 || root == node2),我只是为了方便测试才这样写
		if (root.val == node1.val || root.val == node2.val)
			return root;
		TreeNode left = getParent(root.left, node1, node2);
		TreeNode right = getParent(root.right, node1, node2);
		// 如果左右子树都能找到，那么当前节点就是最近的公共祖先节点
		if (left != null && right != null)
			return root;
		// 如果左子树上没有，那么返回右子树的查找结果
		if (left == null)
			return right;
		// 否则返回左子树的查找结果
		else
			return left;
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null || root.left == null && root.right == null)
			return list;

		Queue<TreeNode> queueLeft = new LinkedList<>();
		Queue<TreeNode> queueRight = new LinkedList<>();

		queueLeft.add(root);
		int level = 0;

		while (!queueLeft.isEmpty() || !queueRight.isEmpty()) {
			List<Integer> array = new ArrayList<>();
			if (level % 2 == 0) {
				while (queueLeft != null) {
					TreeNode node = queueLeft.poll();
					array.add(node.val);
					if (node.right != null) {
						queueRight.add(node.right);
					}
					if (node.left != null) {
						queueRight.add(node.left);
					}
				}
				list.add(array);
			} else {
				while (queueRight != null) {
					TreeNode node = queueRight.poll();
					array.add(node.val);
					if (node.left != null) {
						queueRight.add(node.left);
					}
					if (node.right != null) {
						queueRight.add(node.right);
					}
				}
				list.add(array);
			}
			level++;
		}
		return list;
	}
	  long pre = Long.MIN_VALUE;
	    public boolean isValidBST(TreeNode root) {
	        if(root == null) return true;
	       
	        Stack<TreeNode> stack = new Stack();
	        TreeNode cur = root;

	        long pre = Long.MIN_VALUE;
	        while(cur != null || !stack.isEmpty()){
	            while(cur != null){
	                stack.push(cur);
	                cur = cur.left;
	            }
	            cur = stack.pop();
	            
	            if(cur.val <= pre) 
	                return false;
	            pre = cur.val;
	            
	            cur = cur.right;
	        }
	        
	        return true;
	   }
	    class Solution {
	    	  int max_sum = Integer.MIN_VALUE;

	    	  public int max_gain(TreeNode node) {
	    	    if (node == null) return 0;

	    	    // max sum on the left and right sub-trees of node
	    	    int left_gain = Math.max(max_gain(node.left), 0);
	    	    int right_gain = Math.max(max_gain(node.right), 0);

	    	    // the price to start a new path where `node` is a highest node
	    	    int price_newpath = node.val + left_gain + right_gain;

	    	    // update max_sum if it's better to start a new path
	    	    max_sum = Math.max(max_sum, price_newpath);

	    	    // for recursion :
	    	    // return the max gain if continue the same path
	    	    return node.val + Math.max(left_gain, right_gain);
	    	  }

	    	  public int maxPathSum(TreeNode root) {
	    	    max_gain(root);
	    	    return max_sum;
	    	  }
	    	}

}
