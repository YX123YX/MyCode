package Offer;

import java.util.LinkedHashMap;

/**
 * ��һ���ַ�����0 <=�ַ�������<= 10000��ȫ������ĸ��ɣ����ҵ���һ��ֻ����һ�ε��ַ��� 
 * ����������λ�ã����û���򷵻�-1����Ҫ���ִ�Сд����
 * 
 * ֪ʶ�㣺  1��Map.containsKey���������ж�Map���϶������Ƿ����ָ���ļ���
 *       2��charAt() �������ڷ���ָ�����������ַ���������ΧΪ�� 0 �� length() - 1
 *       3��ɢ��ӳ���Ǹ���ɢ��ֵ���洢�ģ���LinkedHashMap�ĵײ����������Ը���   ˳��   �洢��
 *           ����˵����C��A��ɢ��ӳ��洢�����C��A��ɢ��ֵ���п��ܴ��A��C�������Ӵ洢ΪC��A����ı�����˳��
 * 		4������ʹ��HashMap�ģ����в�ͨ���ģ���ΪHashMap�ĵײ���ɢ�б����ݴ洢�����˳���޹أ�
			  �������ΰڽ�Q��W��E�ַ������ܱ�����ʱ����E��W��Q��˳��
			  ��LinkedHashMap�ĵײ���һ��˫��ѭ��������ά����洢˳�򣬱�����ʱ���ǰ��ղ���˳���������ġ�
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
