package Offer;
/*
 * 问题：统计一个数字k在排序数组中出现的次数。
 * 注意数组是排序的，所以找第一个k和最后一个k的位置就可以了
   二分查找
   （一）找第一个K，二分查找，找到中间的数字mid
   1、mid>k，则k在数组前半段
   2、mid<k，则k在数组后半段
   3、mid = k，判断k是不是第一个，（1）如果中间数字前面的数不是k，则k=mid；（2）如果中间数字前面的一个数是k，则k在前半段
   （二）找最后一个K，二分查找，找到中间的数字mid
   1、mid>k，则k在数组前半段
   2、mid<k，则k在数组后半段
   3、mid = k，判断k是不是最后一个，（1）如果中间数字后面的数不是k，则k=mid；（2）如果中间数字后面的一个数是k，则k在后半段
   */

public class Array_FindCount_times {
	public int GetNumberOfK(int [] array , int k) {
		int count = 0;
		if(array != null || array.length >= 1) {
			int first = findFirstKey(array,0,array.length-1,k);
			int last = findLastKey(array,0,array.length-1,k);
			if(first < 0 || last < 0) {
				return 0;
			}else {
				count = last - first + 1;
			}	
		}
		return count;
	
	}

	private int findFirstKey(int[] array, int start, int end, int k) {
		if (start > end)
			return -1;
		int mid = (start + end) / 2;
		int midData = array[mid];
		// 判断三种情况，前段，中间，后端。
		if (midData == k) {
			// 判断k前面还有k吗？
			if (mid > 0 && array[mid - 1] != k || mid == 0) {
				return mid;
			} else {
				end = mid - 1;
			}
		} else if (midData > k) {
			end = mid - 1;
		} else {
			start = mid + 1;
		}
		return findFirstKey(array, start, end, k);
	}

	private int findLastKey(int[] array, int start, int end, int k) {
		if (start > end)
			return -1;
		int mid = (start + end) / 2;
		int midData = array[mid];
		if (midData == k) {
			if (mid == end || mid < end && array[mid + 1] != k) {
				return mid;
			} else {
				start = mid + 1;
			}
		} else if (midData > k) {
			end = mid - 1;
		} else {
			start = mid + 1;
		}
		return findLastKey(array, start, end, k);
	}

}
