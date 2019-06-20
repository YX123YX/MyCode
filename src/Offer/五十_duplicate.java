package Offer;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * ���⣺��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ�
 *     ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡�
 *     ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��
 * ֪ʶ�㣺1��Map.containsKey���������ж�Map���϶������Ƿ����ָ���ļ���
 *       2��charAt() �������ڷ���ָ�����������ַ���������ΧΪ�� 0 �� length() - 1
 *       3��ɢ��ӳ���Ǹ���ɢ��ֵ���洢�ģ���LinkedHashMap�ĵײ����������Ը���   ˳��   �洢��
 *           ����˵����C��A��ɢ��ӳ��洢�����C��A��ɢ��ֵ���п��ܴ��A��C�������Ӵ洢ΪC��A����ı�����˳��
 * 		 4������ʹ��HashMap�ģ����в�ͨ���ģ���ΪHashMap�ĵײ���ɢ�б����ݴ洢�����˳���޹أ�
			  �������ΰڽ�Q��W��E�ַ������ܱ�����ʱ����E��W��Q��˳��
			  ��LinkedHashMap�ĵײ���һ��˫��ѭ��������ά����洢˳�򣬱�����ʱ���ǰ��ղ���˳���������ġ�
 * 
 * 
 * @author YX
 *
 */
public class ��ʮ_duplicate {
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
