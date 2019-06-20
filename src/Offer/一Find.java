package Offer;

/**
 * ��һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 * 
 * @author YX
 *
 */
public class һFind {
	public boolean Find(int target, int[][] array) {
		// �õ������г���
		int h = array.length - 1;
		// �õ������г���
		int l = array[0].length - 1;
		int i = 0;
		// �����Ͻǿ�ʼ�Ƚ�
		while (h >= 0 && (i <= l)) {
			if (array[i][h] < target) {
				i++;
			} else if (array[i][h] > target) {
				h--;
			} else {
				return true;
			}
		}
		return false;
	}
}
