package Offer;

import java.util.LinkedList;



/**
 * ��εõ�һ���������е���λ����������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��
 * ������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
 * ����ʹ��Insert()������ȡ��������ʹ��GetMedian()������ȡ��ǰ��ȡ���ݵ���λ����
 * 
 * @author YX
 *
 */
public class ��ʮ��_Insert {

	LinkedList<Integer> list = new LinkedList<Integer>();

	public void Insert(Integer num) {
		if (list.size() == 0 || num < list.getFirst()) {
			list.addFirst(num);
		} else {
			boolean insertFlag = false;
			for (Integer in : list) {
				if (num < in) {
					int index = list.indexOf(in);
					list.add(index, num);
					insertFlag = true;
					break;
				}
			}
			if (!insertFlag)
				list.addLast(num);
		}
	}

	public Double GetMedian() {
		if (list.size() == 0)
			return null;
		if (list.size() % 2 == 0) {
			int i = list.size() / 2;
			double a = Double.valueOf(list.get(i - 1) + list.get(i));
			return a / 2;
		}
		list.get(0);
		Double b = Double.valueOf(list.get((list.size() + 1) / 2 - 1));
		return Double.valueOf(list.get((list.size() + 1) / 2 - 1));
		
	}
}
