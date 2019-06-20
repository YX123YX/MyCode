package Offer;

/**
 * ������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ��
 * ���ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ����磬��kΪ18ʱ���������ܹ����뷽��35,37���� ��Ϊ3+5+3+7 =
 * 18�����ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19�����ʸû������ܹ��ﵽ���ٸ����ӣ�
 * 
 * @author YX
 *
 */
public class ��ʮ��_movingCount {
	public static void main(String[] args) {
		System.out.println(19 % 10);
	}

	public int movingCount(int threshold, int rows, int cols) {
		//��¼�Ƿ��߹�
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
