package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * ����2Dƽ���ϵ�n���㣬�ҵ�λ��ͬһֱ���ϵ���������
 * 
 * @author YX
 *
 */
public class ��maxPoints {
	class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	public int maxPoints(Point[] points) {
		if (points.length < 3)
			return points.length;
		// ���ڷ��ؽ���������ߵ�������
		int max = 0;
		// ����map���ϣ�����б�� �� ����
		Map<Double, Integer> map = new HashMap<Double, Integer>();

		for (int i = 0; i < points.length; i++) {// ��ÿ����Ϊ�̶���
			map.clear();
			// ��¼�̶����غϸ���
			int duplicate = 1;
			for (int j = 0; j < points.length; j++) {// ���������㣬������̶���б��
				if (i == j)
					continue;// ������Լ�������
				// б��
				double slope = 0.0;

				if (points[i].x == points[j].x && points[i].y == points[j].y) {// ���̶����غ�
					duplicate++;
					continue;
				} else if (points[i].x == points[j].x) {// ������̶�����ͬһ�������ϣ�б����Ϊ���ֵ)
					slope = Integer.MAX_VALUE;

				} else {// ����õ���̶����б��
					slope = 1.0 * (points[i].y - points[j].y) / (points[i].x - points[j].x);
				}
				map.put(slope, map.containsKey(slope) ? map.get(slope) + 1 : 1);
			}
			// �������Ž�
			if (map.keySet().size() == 0) {// ���mapΪ��
				max = duplicate > max ? duplicate : max;
			} else {
				for (double key : map.keySet()) {
					max = Math.max((duplicate + map.get(key)), max);
				}
			}
		}

		return max;
	}
}
