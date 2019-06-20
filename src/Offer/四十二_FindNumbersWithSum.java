package Offer;

import java.util.ArrayList;

/**
 * ���⣺����һ����������������һ������S���������в�����������ʹ�����ǵĺ�������S��
 *     ����ж�����ֵĺ͵���S������������ĳ˻���С�ġ�
 * @author YX
 *
 */
public class ��ʮ��_FindNumbersWithSum {
	//˼·���������ұƽ�������ǰ�����Ѿ��ź����������ԽԶ�����ǵĳ˻���ԽС��
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum){
		ArrayList<Integer> result = new ArrayList<Integer> ();
		//�������󣬺�����
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
