package Offer;

/**
 * ���}��ÿ����һ��ͯ��,ţ�Ͷ���׼��һЩС����ȥ�����¶�Ժ��С����,����������ˡ�HF��Ϊţ�͵�����Ԫ��,��ȻҲ׼����һЩС��Ϸ��
 * ����,�и���Ϸ��������:����,��С������Χ��һ����Ȧ��Ȼ��,�����ָ��һ����m,�ñ��Ϊ0��С���ѿ�ʼ������
 * ÿ�κ���m-1���Ǹ�С����Ҫ���г��׸�,Ȼ���������Ʒ�����������ѡ����,���Ҳ��ٻص�Ȧ��,��������һ��С���ѿ�ʼ,
 * ����0...m-1����....������ȥ....ֱ��ʣ�����һ��С����,���Բ��ñ���,�����õ�ţ������ġ�����̽���ϡ���ذ�(��������Ŷ!!^_^)��
 * ������������,�ĸ�С���ѻ�õ������Ʒ�أ�(ע��С���ѵı���Ǵ�0��n-1)
 * 
 * @author YX
 *
 */
public class ��ʮ��_LastRemaining_Solution {
	public static void main(String[] args) {
		System.out.println(LastRemaining_Solution(5,3));
	}
	//��������ģ�⻻
	public static int LastRemaining_Solution(int n, int m) {
		if(n == 0 || m == 0)
			return -1;
		//1.�������飬��СΪn������ȫ�����Ϊ��true
		boolean[] peopleFlags = new boolean[n];
		for(int i = 0;i<peopleFlags.length;i++) {
			peopleFlags[i] = true;
		}
		/*2.��������������һ��������¼��ʣ������Ϊ����̭����������ĳ�ʼֵΪ��������
			 �ڶ���������¼�����˶��٣����������������̭��ʱ���㣻
			  ������������¼��ʱ�����˵ڼ����ˣ��������������������ʱ���㣨��Ϊ��һ��Ȧ���������һ������������ֵ���һ����������
	    */		
		int peopleLeft = n; //ʣ������
		int count = 0; //��������ÿ��һ�� +1���ӵ� m-1 ʱ���㡣
		int index = 0; //��Ǵ����￪ʼ
		//3.forѭ���ж�
		while(peopleLeft > 1) {//�������һ����ѭ����ȡindex����������δ����̭�����������һ��
			                 //�������keyNumber����̭����ˣ���������������������index����������ʱ
			//3.1��ǰ���Ƿ���
			if(peopleFlags[index])
				//˵��û����̭��������+1
				count++;
				if(count == m) {
					count = 0;
					peopleFlags[index] = false;//���˱���̭
					peopleLeft--;
				}
			//3.2������һ����
			index++;
			//3.3����һȦ�����¹���
			if(index == n)
				index = 0;
		}
		int b= 0;
		for(int i = 0;i<peopleFlags.length;i++) {
			if(peopleFlags[i] == true) {
				b = i;
				break;
			}
				
		}
		return b;
		
	}
}
