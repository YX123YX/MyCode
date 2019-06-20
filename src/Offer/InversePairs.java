package Offer;



import org.junit.Test;

public class InversePairs {

	private int count = 0;

	public int InversePairs(int[] a) {
		if (a == null || a.length == 0)
			return -1;
		mergeSort(a, 0, a.length - 1);
		return count;
	}

	public void mergeSort(int[] a, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(a, left, mid);
			mergeSort(a, mid + 1, right);
			merge(a, left, mid, right);
		}
	}

	public void merge(int[] a, int left, int mid, int right) {
		int[] tmp = new int[right - left + 1];
		int t = right - left;// 临时数组下标
		int l = mid;
		int r = right;
		while (l >= left && r >= mid + 1) {
			if (a[l] > a[r]) {
				count += (r - mid);
				tmp[t--] = a[l--];
				if (count >= 1000000007) {
					count %= 1000000007;
				}
			} else {
				tmp[t--] = a[r--];
			}
		}
		while (l >= left) {
			tmp[t--] = a[l--];
		}
		while (r >= mid + 1) {
			tmp[t--] = a[r--];
		}
		for (int i = 0; i <= right - left; i++) {
			a[left + i] = tmp[i];
		}
	}

	@Test
	public void testSolution() {
		int[] a = { 364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993, 407, 416, 366, 315, 301, 601, 650, 418, 355,
				460, 505, 360, 965, 516, 648, 727, 667, 465, 849, 455, 181, 486, 149, 588, 233, 144, 174, 557, 67, 746,
				550, 474, 162, 268, 142, 463, 221, 882, 576, 604, 739, 288, 569, 256, 936, 275, 401, 497, 82, 935, 983,
				583, 523, 697, 478, 147, 795, 380, 973, 958, 115, 773, 870, 259, 655, 446, 863, 735, 784, 3, 671, 433,
				630, 425, 930, 64, 266, 235, 187, 284, 665, 874, 80, 45, 848, 38, 811, 267, 575 };
		System.out.println(InversePairs(a));// 2519
	}
}
