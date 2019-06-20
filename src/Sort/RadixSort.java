package Sort;

import java.util.Arrays;

/**
 * 现在来说说基数是什么意思，对于十进制整数，每一位都只可能是0~9中的某一个，总共10种可能。那10就是它的基，同理二进制数字的基为2；
 * 对于字符串，如果它使用的是8位的扩展ASCII字符集，那么它的基就是256。既然我们知道每一位的数值范围。那么使用计数排序以关键字对数
 * 组进行排序就是个十分明智的选择，原因如下
 * 
 * 对于元素的每一位（关键字），计数排序都可以统计其频率，然后直接将整个元素按照该关键字进行分类、排序，实现起来简单。（想想插入排序、
 * 归并排序等稳定排序算法要如何按照某一位来将整个元素排序，是不是更复杂？）因为数据范围确定且都不大（基的大小），因此不会占用多少空间；
 * 而且计数排序不是基于比较，比通常的比较排序方法效率更高； 计数排序是稳定排序，这一点至关重要。
 * 
 * @author YX
 *
 */
public class RadixSort {
	public static void sort(int[] a) {
		// 每位数字范围0~9，基为10
		int R = 10;
		int N = a.length;
		int[] aux = new int[N];
		int[] count = new int[R + 1];
		// 以关键字来排序的轮数，由位数最多的数字决定，其余位数少的数字在比较高位时，自动用0进行比较
		// 将数字转换成字符串，字符串的长度就是数字的位数，字符串最长的那个数字也拥有最多的位数
		int W = Arrays.stream(a).map(s -> String.valueOf(s).length()).max().getAsInt();

		// 共需要d轮计数排序, 从d = 0开始，说明是从个位开始比较，符合从右到左的顺序
		for (int d = 0; d < W; d++) {
			// 1. 计算频率，在需要的数组长度上额外加1
			for (int i = 0; i < N; i++) {
				// 使用加1后的索引，有重复的该位置就自增
				count[digitAt(a[i], d) + 1]++;
			}
			// 2. 频率 -> 元素的开始索引
			for (int r = 0; r < R; r++) {
				count[r + 1] += count[r];
			}

			// 3. 元素按照开始索引分类，用到一个和待排数组一样大临时数组存放数据
			for (int i = 0; i < N; i++) {
				// 填充一个数据后，自增，以便相同的数据可以填到下一个空位
				aux[count[digitAt(a[i], d)]++] = a[i];
			}
			// 4. 数据回写
			for (int i = 0; i < N; i++) {
				a[i] = aux[i];
			}
			// 重置count[]，以便下一轮统计使用
			for (int i = 0; i < count.length; i++) {
				count[i] = 0;
			}

		}
	}

	// 根据d，获取某个值的个位、十位、百位等，d = 0取出个位，d = 1取出十位，以此类推。对于不存在的高位，用0补
	private static int digitAt(int value, int d) {
		return (value / (int) Math.pow(10, d)) % 10;
	}

	public static void main(String[] args) {
		int[] a = { 244, 167, 1234, 321, 29, 98, 1444, 111, 99, 6 };
		RadixSort.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
