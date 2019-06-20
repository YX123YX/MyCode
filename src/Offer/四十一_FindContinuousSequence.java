package Offer;

import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,
 * 他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * ..输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * @author YX
 *
 */
public class 四十一_FindContinuousSequence {
	public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum){
		//采用滑动窗口来实现
		ArrayList<ArrayList<Integer> > result = new ArrayList<ArrayList<Integer> > ();
		//设置窗口大小,窗口最小为2
		int low = 1 ;
		int high = 2;
		while(high > low) {
			//等差数列的和为（low+high）*n/2
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
