package Offer;

import java.util.ArrayList;

/**
 * 问题：输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 *     如果有多对数字的和等于S，输出两个数的乘积最小的。
 * @author YX
 *
 */
public class 四十二_FindNumbersWithSum {
	//思路：采用左右逼近方法，前提是已经排好序。左右里的越远，它们的乘积就越小。
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum){
		ArrayList<Integer> result = new ArrayList<Integer> ();
		//设置最左，和最右
		int low = 0;
		int high = array.length-1;
		while(high > low) {
			if((array[low] + array[high]) == sum ) {
				result.add(array[low]);
				result.add(array[high]);
				return result;
			}else if ((array[low] + array[high]) < sum) {
				low++;
			}else {
				high--;
			}
		}
		return result;
	}
}
