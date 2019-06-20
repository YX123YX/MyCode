package Offer;

import java.util.LinkedHashMap;

/**
 * 在一个字符串（0 <=字符串长度<= 10000，全部由字母组成）中找到第一个只出现一次的字符， 
 * 并返回它的位置，如果没有则返回-1（需要区分大小写）。
 * 
 * 知识点：  1、Map.containsKey方法——判断Map集合对象中是否包含指定的键名
 *       2、charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1
 *       3、散列映射是根据散列值来存储的，而LinkedHashMap的底层是链表，可以根据   顺序   存储。
 *           比如说输入C，A，散列映射存储计算出C，A的散列值，有可能存成A，C，而链接存储为C，A不会改变输入顺序
 * 		4、不能使用HashMap的，运行不通过的，因为HashMap的底层是散列表，数据存储与插入顺序无关，
			  比如依次摆进Q，W，E字符，可能遍历的时候是E，W，Q的顺序。
			  而LinkedHashMap的底层有一个双向循环链表来维护其存储顺序，遍历的时候是按照插入顺序来遍历的。
 * 
 * @author YX
 *
 */
public class FirstNotRepeatingChar {
	 public static int FirstNotRepeatingChar(String str) {
		 LinkedHashMap<Character, Integer> map = new 
				 LinkedHashMap<Character, Integer>();
		 for(int i = 0;i < str.length();i++) {
			 if(map.containsKey(str.charAt(i))) {
				 int time = map.get(str.charAt(i));
				 map.put(str.charAt(i),	++time);
			 }else {
				 map.put(str.charAt(i), 1);
			 }
		 }
		 for(int j =0;j<str.length();j++) {
			 char c = str.charAt(j);
			 if(map.get(c) == 1) 
				 return j;
		 }
		 return -1;
	 }
	 public static void main(String[] args) {
		 String string = "google";
		 System.out.println(FirstNotRepeatingChar(string));;
	}
}
