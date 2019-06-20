package Sort;

/**
 * 归并排序： 原理： 将待排序数组分成两份，分别进行排序，依次进行分成两份。
 * 
 * @author YX
 *
 */
public class GuiBingPaiXu {
	public static void mergeSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		mergeSort(arr, 0, arr.length - 1);
	}

	public static void mergeSort(int[] arr, int l, int r) {
		if (l == r) {
			return;
		}
		// 找到中间下标
		int mid = l + ((r - l) >> 1);
		// 分别分割，分成两份，再进行分解。
		mergeSort(arr, l, mid);
		mergeSort(arr, mid + 1, r);
		// 再调用归并算法
		merge(arr, l, mid, r);
	}

	public static void merge(int[] arr, int l, int m, int r) {
		int[] help = new int[r - l + 1];
		int i = 0;
		int p1 = l;
		int p2 = m + 1;
		while (p1 <= m && p2 <= r) {
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= m) {
			help[i++] = arr[p1++];
		}
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}
		// 奖排完序的拷贝回原数组
		for (i = 0; i < help.length; i++) {
			arr[l + i] = help[i];
		}
	}
}
