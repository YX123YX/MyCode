package Sort;

import java.util.Arrays;

/**
 * �������򣺼��������������ĸ����衣 ���Ȼ��ÿ���������Ƶ��ͳ�ƣ��õ�Ԫ�ص�Ƶ�ʱ� Ȼ��Ƶ�ʱ�ת��Ϊ��Ԫ�صĿ�ʼ������
 * ���ݸ���Ԫ�صĿ�ʼ����������ͬԪ�ط��ൽ��ʱ�����С� �����ʱ�����е�Ԫ��д�ص�ԭ�����С�
 * 
 * @author YX
 *
 */
public class JiShuSort {
	public static void sort(int[] arr) {
		// �������ֵ����Сֵ
		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();
		int N = arr.length;
		// ����Ƶ�ʱ�Ĵ�С����Χ�ǡ�min��max��
		int R = max - min + 1;
		// 1.����Ƶ�ʣ���Ҫ�������ϼ�����ⳤ��1
		int[] count = new int[R + 1];
		for (int i = 0; i < N; i++) {
			// ʹ�ü�1������������ظ��ĸ�λ�þ�����
			count[arr[i] - min + 1]++;
		}
		// 2. Ƶ�� -> Ԫ�صĿ�ʼ����
		for (int r = 0; r < R; r++) {
			count[r + 1] += count[r];
		}
		// 3. Ԫ�ذ��տ�ʼ�������࣬�õ�һ���ʹ�������һ������ʱ����������
		int[] aux = new int[N];
		for (int i = 0; i < N; i++) {
			// ���һ�����ݺ��������Ա���ͬ�����ݿ������һ����λ
			aux[count[arr[i] - min]++] = arr[i];
		}
		// 4. ���ݻ�д
		for (int i = 0; i < N; i++) {
			arr[i] = aux[i];
		}
	}

	public static void main(String[] args) {
		int[] a = { 9, 7, 6, 3, 9, 2, 7, 3, 2, 8 };
		sort(a);
		System.out.println(Arrays.toString(a));
	}
}
