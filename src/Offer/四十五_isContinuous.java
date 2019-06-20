package Offer;

import java.util.Arrays;

/**
 * LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,2��С��(һ����ԭ����54��^_^)...��������г����5����,
 * �����Լ�������,�����ܲ��ܳ鵽˳��,����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣��� ������A,����3,С��,����,��Ƭ5��,��Oh My
 * God!������˳��.....LL��������,��������,������\С �����Կ����κ�����,����A����1,
 * JΪ11,QΪ12,KΪ13�������5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So Lucky!����LL����ȥ��������Ʊ����
 * ����,Ҫ����ʹ�������ģ������Ĺ���,Ȼ���������LL��������Σ�
 * ����������˳�Ӿ����true����������false��Ϊ�˷������,�������Ϊ��С����0��
 * 
 * @author YX
 *
 */
public class ��ʮ��_isContinuous {
	
	public static boolean isContinuous(int[] numbers) {
		if(numbers == null || numbers.length == 0 )
			return false;
		//1.����
		Arrays.sort(numbers);
		//2.ͳ��0�ĸ���
		int count = 0;
		for(int i = 0;i< numbers.length;i++) {
			if(numbers[i] == 0) {
				count++;
			}else if (numbers[i] > 0) {
				break;
			}
		}
		//3.ͳ����Ҫ�ô�С����ĸ���
		int count2 = 0;
		for(int i = 0;i< numbers.length-1;i++) {
			if(numbers[i] != 0) {
				if(numbers[i] == numbers[i+1]) {
					return false;
				}else {
					count2 += numbers[i+1] - numbers[i] -1;
				}
			}
		}
		return count2 <= count;

	}
	public static void main(String[] args) {
		int[] a= {3,4,5,6,7};
		System.err.println(isContinuous(a));
	}
}
