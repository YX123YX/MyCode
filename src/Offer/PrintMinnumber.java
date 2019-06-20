package Offer;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class PrintMinnumber {
	public static void main(String[] args) {
		int [] numbers = { 41,25,63,74,85 };
		System.out.println(PrintMinNumber(numbers));
	}
	public static String PrintMinNumber(int [] numbers) {
		if(numbers == null || numbers.length == 0)
			return "";
		int length = numbers.length;
		String[] string = new String[length];
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i< length;i++) {
			string[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(string,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String c1 = o1 + o2;
				String c2 = o2 + o1;
				return c1.compareTo(c2);
			}
		});
		for (String q : string) {
			System.out.println(q);
		}
		for (String s : string) {
			sb.append(s);
		}
		return sb.toString();
	}

}
