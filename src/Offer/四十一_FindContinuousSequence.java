package Offer;

import java.util.ArrayList;

/**
 * С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100�����������������ڴ�,
 * �����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22��
 * ���ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? Good Luck!
 * ..������к�ΪS�������������С������ڰ��մ�С�����˳�����м䰴�տ�ʼ���ִ�С�����˳��
 * @author YX
 *
 */
public class ��ʮһ_FindContinuousSequence {
	public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum){
		//���û���������ʵ��
		ArrayList<ArrayList<Integer> > result = new ArrayList<ArrayList<Integer> > ();
		//���ô��ڴ�С,������СΪ2
		int low = 1 ;
		int high = 2;
		while(high > low) {
			//�Ȳ����еĺ�Ϊ��low+high��*n/2
			int cur = (low + high)*(high - low + 1)/2;
			if(cur == sum) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				for(int i = low;i <= high;i++ ) {
					list.add(i);
				}
				result.add(list);
				low++;
			}else if (cur < sum) {
				high++;
			}else {
				low++;
			}
		}
		return result;
	}
}
