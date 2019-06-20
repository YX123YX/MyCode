package Sort;

/**
 * ��������: һ�����飬ѡȡ���һ��Ԫ��xΪ����ֵ�����ڵ���x�ķ���ߣ�С��x�ķ����ұߡ� �������ڴ��ڵ���x������ѡȡ���Ԫ����Ϊ����ֵ��
 * ��С��x������ѡȡ���Ԫ��Ϊ����ֵ����������Ĳ��衣
 * 
 * @author YX
 *
 */
public class QuickSort {
	public static void quickSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		quickSort(arr, 0, arr.length - 1);
	}

	private static void quickSort(int[] arr, int l, int r) {
		if (l < r) {
			swap(arr, l + (int) (Math.random() * (r - l + 1)), r); // �������
			int[] p = partition(arr, l, r);
			quickSort(arr, l, p[0] - 1);
			quickSort(arr, p[1] + 1, r);

		}

	}

	private static int[] partition(int[] arr, int l, int r) {
		int less = l - 1;
		int more = r;
		while (l < more) {
			if (arr[l] < arr[r]) {
				swap(arr, ++less, l++);
			} else if (arr[l] > arr[r]) {
				swap(arr, --more, l);
			} else {
				l++;
			}
			swap(arr, more, r);
		}
		return new int[] { less + 1, more - 1 };
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
