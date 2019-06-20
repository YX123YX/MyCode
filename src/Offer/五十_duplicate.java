package Offer;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 问题：在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 *     数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 *     例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * 知识点：1、Map.containsKey方法——判断Map集合对象中是否包含指定的键名
 *       2、charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1
 *       3、散列映射是根据散列值来存储的，而LinkedHashMap的底层是链表，可以根据   顺序   存储。
 *           比如说输入C，A，散列映射存储计算出C，A的散列值，有可能存成A，C，而链接存储为C，A不会改变输入顺序
 * 		 4、不能使用HashMap的，运行不通过的，因为HashMap的底层是散列表，数据存储与插入顺序无关，
			  比如依次摆进Q，W，E字符，可能遍历的时候是E，W，Q的顺序。
			  而LinkedHashMap的底层有一个双向循环链表来维护其存储顺序，遍历的时候是按照插入顺序来遍历的。
 * 
 * 
 * @author YX
 *
 */
public class 五十_duplicate {
	public boolean duplicate(int numbers[],int length,int [] duplication) {
		if(numbers == null || length == 0)
			return false;
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		for(int i = 0;i<length;i++) {
			if(map.containsKey(numbers[i])) {
				map.put(numbers[i], map.get(numbers[i])+1);
			}else {
				map.put(numbers[i], 1);
			}
		}
		for(int i = 0;i< length;i++) {
			if(map.get(numbers[i]) != 1) {
				duplication[0] = numbers[i];
				return true;
			}
		}
		return false;
	}
}
