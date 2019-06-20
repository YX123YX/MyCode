package Offer;
/*
 * ���⣺ͳ��һ������k�����������г��ֵĴ�����
 * ע������������ģ������ҵ�һ��k�����һ��k��λ�þͿ�����
   ���ֲ���
   ��һ���ҵ�һ��K�����ֲ��ң��ҵ��м������mid
   1��mid>k����k������ǰ���
   2��mid<k����k���������
   3��mid = k���ж�k�ǲ��ǵ�һ������1������м�����ǰ���������k����k=mid����2������м�����ǰ���һ������k����k��ǰ���
   �����������һ��K�����ֲ��ң��ҵ��м������mid
   1��mid>k����k������ǰ���
   2��mid<k����k���������
   3��mid = k���ж�k�ǲ������һ������1������м����ֺ����������k����k=mid����2������м����ֺ����һ������k����k�ں���
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
		// �ж����������ǰ�Σ��м䣬��ˡ�
		if (midData == k) {
			// �ж�kǰ�滹��k��
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
