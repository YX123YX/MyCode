package Offer;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 
 * @author YX
 *
 */
public class 一Find {
	public boolean Find(int target, int[][] array) {
		// 拿到数组行长度
		int h = array.length - 1;
		// 拿到数组列长度
		int l = array[0].length - 1;
		int i = 0;
		// 从右上角开始比较
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
