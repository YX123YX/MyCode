package Offer;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格（35,37）， 因为3+5+3+7 =
 * 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * 
 * @author YX
 *
 */
public class 六十七_movingCount {
	public static void main(String[] args) {
		System.out.println(19 % 10);
	}

	public int movingCount(int threshold, int rows, int cols) {
		//记录是否走过
		boolean[][] flag = new boolean[rows][cols];
		return helper(threshold, rows, cols, 0, 0, flag);

	}

	private int helper(int threshold, int rows, int cols, int i, int j, boolean[][] flag) {
		if (i < 0 || j < 0 || i >= rows || j >= cols || flag[i][j] || Sum(i) + Sum(j) > threshold)
			return 0;

		flag[i][j] = true;
		return helper(threshold, rows, cols, i - 1, j, flag)
				+ helper(threshold, rows, cols, i, j - 1, flag)
				+ helper(threshold, rows, cols, i + 1, j, flag)
				+ helper(threshold, rows, cols, i, j + 1, flag) + 1;
	}

	private int Sum(int i) {
		int count = 0;
		while (i != 0) {
			count += i % 10;
			i /= 10;
		}
		return count;
	}
}
