package Sort;

/**
 * 希尔排序：将整个序列按照相距某个“增量”进行拆分，然后逐个对子序列进行直接插入排序，使得得到的结果基本有序，最后对基本有序的序列进行一次直接插入排序，使得整个序列有序
 * 
 * 述两个条件过于苛刻，现实中记录少或者基本有序都属于特殊情，有条件当然是好，条件不存在，我们创造条件，也是可以去做的；骚年与博主进行了研究与讨论，我们可以对序列进行分组，
 * 分割成若干个子序列，然后对每个子序列分别进行直接插入排序，当整个序列都基本有序时，注意只是基本有序时，再对全体记录进行一次直接插入排序。
 * 
 * 此时一定有人开始疑惑了。这不对呀，比如我们现在有序列是{5,3,7,9,1,6,4,8,2}，现在将它分成三组，{5,3,7}，
 * {9,1,6}，{4,8,2}，哪怕将它们各自排序排好了，变成{3,5,7}，{1,6,9}，{2,4,8}，再合并它们成
 * {3,5,7,1,6,9,2,4,8}，此时，这个序列还是杂乱无序，谈不上基本有序，要排序还是重来一遍直接插入有序，这样做有用吗？需要强调一下，
 * 所谓的基本有序，就是小的关键字基本在前面，大的基本在后面，不大不小的基本在中间，像{2,1,3,6,4,7,5,8,9}这样可以称为基本有序了。
 * 但像{3,5,7,1,6,9,2,4,8}这样的7在第三位，2在倒数第三位就谈不上基本有序。
 * 那么问题就来了，我们分割待排序记录的目的是减少待排序记录的个数，并使整个序列向基本有序发展。而如上面这样分完组后，就各自排序的方法达不到我们的要求。
 * 因此，我们需要采取跳跃分割的策略：将相距某个“增量”的记录组成一个子序列，这样才能保证在子序列内分别进行直接插入排序后得到的结果是基本有序而不是局部有序。
 * 
 * @author YX
 *
 */
public class XiErSort {
	public void sort(int[] arr) {
		int n = arr.length;
		// 拆分整个单元格，元素之间的间距即增量
		for (int gap = n / 2; gap >= 1; gap = gap / 2) {
			// 对子序列进行直接插入排序限制范围，开始到结束。
			//i:代表即将插入的元素角标，作为每一组比较数据的最后一个元素角标 
            //j:代表与i同一组的数组元素角标
			for (int i = gap; i < n; i++) {
				for (int j = i - gap; j >= 0 && arr[j] > arr[j + gap]; j = j - gap) {//j = j - gap 防止角标越界
					swap(arr, j, j + gap);
				}
			}
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
