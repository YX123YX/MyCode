package Offer;
/**
 * ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��дЩ�����ڱ����ϡ�ͬ��Cat��Fishд�������ĸ���Ȥ����һ������Fish������������ȴ������������˼��
 * ���磬��student. a am I������������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ���ȷ�ľ���Ӧ���ǡ�I am a student.����
 * Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��
 * @author YX
 *
 */
public class ��ʮ��_ReverseSentence {
	public String ReverseSentence(String str) {
		if(str == null || str.length() == 1)
			return str;
		char[] array = str.toCharArray();
		//1.�ȷ�ת��������
		swap(array,0,array.length-1);
		//2.�ٷ�תÿ������
		int blank = -1;
		for(int i = 0;i<array.length-1;i++) {
			if(array[i] == ' ') {
				int nextBlank = i;
				swap(array, blank+1, nextBlank-1);
				blank = nextBlank;
			}
		}
		//��ʣ�����һ������û��ת
		swap(array, blank+1, array.length-1);
		return new String(array);
	}

	private void swap(char[] array, int i, int j) {
		while(i<j) {
			char temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			i++;
			j--;
		}
		
	}

	
}
