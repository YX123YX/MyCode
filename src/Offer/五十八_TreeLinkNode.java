package Offer;


/**
 * ����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�
 * ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
 * 
 *         A
 *       /   \
 *      B     C
 *     /  \  / \
 *     D   E F  G
 *        / \
 *        H  I
 * ��1�� ���ýڵ����������������һ���ڵ�Ϊ�����������ӽڵ㣨��ͼ�ڵ� B ��
 * ��2�� ���ýڵ㲻��������������ʱ����������� 
	  2.1 �ýڵ�Ϊ���ڵ�����ӽڵ㣬����һ���ڵ�Ϊ�丸�ڵ㣨��ͼ�ڵ� D ��
	  2.2 �ýڵ�Ϊ���ڵ�����ӽڵ㣬�����Ÿ��ڵ����ϱ�����֪���ҵ�һ���ڵ�ĸ��ڵ�����ӽڵ�Ϊ�ýڵ㣬��ýڵ�ĸ��ڵ���һ���ڵ㣨��ͼ�ڵ� I
	 �����Ÿ��ڵ�һֱ���ϲ����ҵ� B �� B Ϊ�丸�ڵ�����ӽڵ㣩���� B �ĸ��ڵ� A Ϊ��һ���ڵ㣩��
 * 
 * @author YX
 *
 */
public class ��ʮ��_TreeLinkNode {
	public class TreeLinkNode {
	    int val;
	    TreeLinkNode left = null;
	    TreeLinkNode right = null;
	    TreeLinkNode next = null;
	    TreeLinkNode(int val) {
	        this.val = val;
	    }
	}
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if(pNode == null)
			return pNode;
		if(pNode.right != null) {//���ҽڵ�
			pNode = pNode.right;
			while(pNode.left != null) {
				pNode = pNode.left;
			}
			return pNode;
		}else if (pNode.next != null && pNode.next.left == pNode) {//�ڵ���Ϊ������
			return pNode.next;
		}else if( pNode.next != null && pNode.next.right == pNode){//�ڵ���Ϊ������
			while(pNode.next != null && pNode.next.left != pNode) {
				pNode = pNode.next;
			}
			return pNode.next;
		}else {
			return pNode.next;//�޸��ڵ�
		}
	}

}
