package Offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * ��Ŀ���� ����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ�����磬�����������{2,3,4,2,6,2,5,1}
 * ���������ڵĴ�С3����ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}��
 * �������{2,3,4,2,6,2,5,1}�Ļ�������������6���� {[2,3,4],2,6,2,5,1}�� {2,[3,4,2],6,2,5,1}��
 * {2,3,[4,2,6],2,5,1}�� {2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}��
 * {2,3,4,2,6,[2,5,1]}��
 * 
 * @author YX
 */

public class ��ʮ�� {
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		if (num == null || size < 0)
			return null;
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (size == 0)
			return list;
		ArrayList<Integer> temp = null;
		int length = num.length;
		if (length < size) {
			return list;
		} else {
			// �������ڵ�����
			for (int i = 0; i < length - size + 1; i++) {
				temp = new ArrayList<Integer>();
				for (int j = i; j < size + i; j++) {
					temp.add(num[j]);
				}
				Collections.sort(temp);
				list.add(temp.get(temp.size() - 1));
			}
		}

		return list;
	}
}
