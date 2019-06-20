package Offer;

/**
 * ��ʵ�������������ֱ��������л��ͷ����л�������
 * 
 * @author YX
 *
 */
public class ��ʮ��_Serialize {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	String Serialize(TreeNode root) {
		StringBuilder str = new StringBuilder();
		if(root == null) {
			str.append("#,");
			return str.toString();
		}
		str.append(root.val + ",");
		str.append(Serialize(root.left));
		str.append(Serialize(root.right));	
		return str.toString();
	}
	int index = -1;
	TreeNode Deserialize(String str) {
		index++;
		String[] strr = str.split(",");
		TreeNode node = null;
		if(!strr[index].equals("#")) {
			node = new TreeNode(Integer.valueOf(strr[index]));
			node.left = Deserialize(str);
			node.right = Deserialize(str);
		}
		return node;
	}
}
