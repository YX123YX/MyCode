package Sort;

import java.util.Arrays;

/**
 * 基数排序：计数排序有如下四个步骤。 首先会对每个输入进行频率统计，得到元素的频率表； 然后将频率表转换为该元素的开始索引；
 * 根据各个元素的开始索引，将相同元素分类到临时数组中。 最后将临时数组中的元素写回到原数组中。
 * 
 * @author YX
 *
 */
public class JiShuSort {
	public static void sort(int[] arr) {
		// 计算最大值和最小值
		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();
		int N = arr.length;
		// 建立频率表的大小，范围是【min，max】
		int R = max - min + 1;
		// 1.计算频率，需要在数组上加入额外长度1
		int[] count = new int[R + 1];
		for (int i = 0; i < N; i++) {
			// 使用加1后的索引，有重复的该位置就自增
			count[arr[i] - min + 1]++;
		}
		// 2. 频率 -> 元素的开始索引
		for (int r = 0; r < R; r++) {
			count[r + 1] += count[r];
		}
		// 3. 元素按照开始索引分类，用到一个和待排数组一样大临时数组存放数据
		int[] aux = new int[N];
		for (int i = 0; i < N; i++) {
			// 填充一个数据后，自增，以便相同的数据可以填到下一个空位
			aux[count[arr[i] - min]++] = arr[i];
		}
		// 4. 数据回写
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
