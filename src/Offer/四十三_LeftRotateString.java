package Offer;
/**
 * ���⣺�����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵����񣬾������ַ���ģ�����ָ�����������
 * ����һ���������ַ�����S���������ѭ������Kλ���������������磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ����
 * ����XYZdefabc�����ǲ��Ǻܼ򵥣�OK���㶨����
 * 
 * ˼·���ַ�����ת��
 *     �����ַ���abcdef��n=3����X=abc��Y=def�������ַ������Ա�ʾ��XY������ɣ���������YX��
 *      ����X�ķ�תΪXT��XT=cba��ͬ��YT=fed����ôYX=(XTYT)T�����η�ת��ɵý����
 * 
 * @author YX
 *
 */
public class ��ʮ��_LeftRotateString {
    public String LeftRotateString(String str,int n) {
    	char[] array = str.toCharArray();
    	if(array.length < n )
    		return "";
    	swap(array,0,n-1);
    	swap(array, n, array.length-1);
    	swap(array, 0, array.length-1);
    	return new String(array);
    }

	private void swap(char[] array, int start, int end) {
		
		while(start < end) {
			char temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
		
		
	}

}
