package Sort;

/**
 * 选择排序 原理是：每一趟从待排序的记录中选出最小的元素，顺序放在已排好序的序列最后，直到全部记录排序完毕。
 * 也就是：每一趟在n-i+1(i=1，2，…n-1)个记录中选取关键字最小的记录作为有序序列中第i个记录。
 * 
 * @author YX
 *
 */
public class XuanZePaiXu {
	public static void sort(int[] arr) {
		// 其实也是需要两个for循环，第一个for是需要进行几趟,需要排序n个，即需要n趟。
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			// 第二个for是每趟需要和谁比较，只交换下标，不交换元素。
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIndex] > arr[j]) {
					// 交换下标
					minIndex = j;
				}
			}
			swap(arr, i, minIndex);
		}
	}

	/**
	 * 角标的形式 交换元素
	 */
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}