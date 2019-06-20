package Offer;
/**
 * 问题：汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
 * 即“XYZdefabc”。是不是很简单？OK，搞定它！
 * 
 * 思路：字符串翻转，
 *     假设字符串abcdef，n=3，设X=abc，Y=def，所以字符串可以表示成XY，如题干，问如何求得YX。
 *      假设X的翻转为XT，XT=cba，同理YT=fed，那么YX=(XTYT)T，三次翻转后可得结果。
 * 
 * @author YX
 *
 */
public class 四十三_LeftRotateString {
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
