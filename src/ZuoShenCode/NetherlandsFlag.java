package ZuoShenCode;

/**
 * 荷兰国旗问题:现在有若干个红、白、蓝三种颜色的球随机排列成一条直线。现在我们的任务是把这些球按照红、白、蓝排序。
 * 
 * 在使用partition-exchange排序算法时，如快速排序算法(即使选择了一个好的关键元素pivot
 * values)，我们往往面临一个很尴尬的境地--当排序对象中有很多重复的元素，partition-exchange
 * 排序算法表现很不尽如人意。当所有元素都相等时，这就特别容易理解了。在每次递归中，左边部分是空的(没有元素比关键元素小)，
 * 而右边部分只能一个一个递减移动。结果导致耗费了二次方时间来排序相等元素。为了解决这个问题(有时叫做荷兰国旗问题)，我们详细介绍下解决这个问题的方法。
 * 
 * @author YX
 *
 */
public class NetherlandsFlag {

	public static int[] partition(int[] arr, int L, int R, int Num) {
		int less = L - 1;
		int more = R + 1;
		int cur = L;
		while (cur < more) {
			if (arr[cur] < Num) {
				swap(arr, ++less, L++);
			} else if (arr[cur] > Num) {
				swap(arr, --more, cur);
			} else { // == Num
				cur++;
			}
		}
		return new int[] { less + 1, more - 1 };
	}

	// for test
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test
	public static int[] generateArray() {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 3);
		}
		return arr;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] test = { 1, 2, 3, 11, 1, 2, 3, 3, 0, 0 };

		printArray(test);
		int[] res = partition(test, 0, test.length - 1, 1);
		printArray(test);
		System.out.println(res[0]);
		System.out.println(res[1]);

	}
}
