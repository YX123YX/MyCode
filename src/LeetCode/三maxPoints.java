package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定2D平面上的n个点，找到位于同一直线上的最大点数。
 * 
 * @author YX
 *
 */
public class 三maxPoints {
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
		// 用于返回结果，即共线的最大个数
		int max = 0;
		// 创建map集合，保存斜率 和 个数
		Map<Double, Integer> map = new HashMap<Double, Integer>();

		for (int i = 0; i < points.length; i++) {// 以每个点为固定点
			map.clear();
			// 记录固定点重合个数
			int duplicate = 1;
			for (int j = 0; j < points.length; j++) {// 遍历其他点，求其与固定点斜率
				if (i == j)
					continue;// 如果是自己就跳过
				// 斜率
				double slope = 0.0;

				if (points[i].x == points[j].x && points[i].y == points[j].y) {// 跟固定点重合
					duplicate++;
					continue;
				} else if (points[i].x == points[j].x) {// 如果跟固定点在同一条竖线上，斜率设为最大值)
					slope = Integer.MAX_VALUE;

				} else {// 计算该点与固定点的斜率
					slope = 1.0 * (points[i].y - points[j].y) / (points[i].x - points[j].x);
				}
				map.put(slope, map.containsKey(slope) ? map.get(slope) + 1 : 1);
			}
			// 更新最优解
			if (map.keySet().size() == 0) {// 如果map为空
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
