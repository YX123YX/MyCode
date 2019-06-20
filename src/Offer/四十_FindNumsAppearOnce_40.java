package Offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 知识点：( ^ )当两个操作数的对应位不同时将该位设置为1。
 * 			两个操作数的位中，相同则结果为0，不同则结果为1。下面看一个简单的例子。
			a=15与 b=2 异或的结果是：13
			                    分析上面的程序段：a 的值是15，转换成二进制为1111，而b 的值是2，
			                    转换成二进制为0010，根据异或的运算规律，可以得出其结果为1101 即13。
			与运算：& ：两者都为1结果才为1，否则为0 ，  eg：1&1=1,  1&0=0,  0&1=0,  0&0=0
					或运算：|：两者都为0结果才为0，否则为1，  eg：1|1 = 1,  1|0 = 1,  0|1 = 1, 0|0 = 0
					非运算：~：1取0，0取1，    eg：~1 = 0, ~0 = 1  eg：~(1001) = 01110
					异或运算:^：两者相等才为0,不等则为1  eg: 1^1=0, 1^0=1, 0^1=1, 0^0=0
                    
	解题思路：1、位运算中异或的性质：两个相同数字异或=0，一个数和0异或还是它本身。
			        这个问题可以可以使用用异或的性质解决。异或的性质：对于整数a,有
		                         （1） a^a=0
		                         （2）a^0=a
		                         （2）a^b^c=a^(b^c)=(a^c)^b
	       2、
 * @author YX
 *
 */
public class 四十_FindNumsAppearOnce_40 {
	//num1,num2分别为长度为1的数组。传出参数
	//将num1[0],num2[0]设置为返回结果
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
		/*方法一：		//Map对应的键值key就是数组中的元素，value就是这个元素出现的次数
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0 ; i < array.length ; i++) {
			if(map.containsKey(array[i])) {
				map.put(array[i], map.get(array[i])+1);
			}else {
				map.put(array[i], 1);
			}
		}
		List list = new ArrayList();
		for(int j = 0; j < map.keySet().size();j++ ) {
			if(map.get(array[j]) == 1) {
				list.add(array[j]);
			}
		}
		
		num1[0] = (int) list.get(0);
		num2[0] = (int) list.get(1);
		
	}*/
		if(array == null || array.length <=2) {
			num1[0] = num2[0]=0;
			return;
		}
		int sum = 0;
		for(int i = 0;i<array.length;i++)
			sum = sum ^ array[i];
		int index = 1;
		while((sum & index) == 0 )
			index<<=1;
		for(int i =0;i<array.length;i++) {
			if((index&array[i])==0) {
				num2[0]^=array[i];
			}else {
				num1[0]^=array[i];
			}
		}
		
}
}
