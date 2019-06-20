package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Ͱ����
 * Ͱ������Ϊ���鳤��arr.length
 * ӳ�亯��ʹ�� bucketIndex = (value * arr.length) / (maxValue + 1) ,��1��Ϊ�˱�֤���Ԫ�ؿ��Դ浽�������һ��λ��
 * @author YX
 *
 */
public class BucketSort {
	public static void sort(int[] arr) {
		// ����Ͱ�������ʹ��������鳤��һ��
		int N = arr.length;
		LinkedList<Integer>[] bucket = (LinkedList<Integer>[]) new LinkedList[N];

		// �����������е����ֵ
		int maxValue = Arrays.stream(arr).max().getAsInt();
		// ����ÿ��Ԫ�ص�ֵ�����䵽��Ӧ��Χ��Ͱ��
		for (int i = 0; i < arr.length; i++) {
			int index = toBucketIndex(arr[i], maxValue, N);
			// û��Ͱ�Ž���Ͱ(��ʱ)
			if (bucket[index] == null) {
				bucket[index] = new LinkedList<>();
			}
			// ��Ͱֱ��ʹ��
			bucket[index].add(arr[i]);
		}

		// ��ÿ���ǿյ�Ͱ���������˳�������ʱ��List����list���Ѿ�����
		List<Integer> temp = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (bucket[i] != null) {
				Collections.sort(bucket[i]);
				temp.addAll(bucket[i]);
			}
		}

		// ��temp�е�����д��ԭ����
		for (int i = 0; i < N; i++) {
			arr[i] = temp.get(i);
		}
	}

	// ӳ�亯������ֵת��ΪӦ��ŵ���Ͱ���������
	private static int toBucketIndex(int value, int maxValue, int N) {
		return (value * N) / (maxValue + 1);
	}

	public static void main(String[] args) {
		int[] a = { 44, 67, 32, 21, 9, 98, 44, 111, 99, 6 };
		BucketSort.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
