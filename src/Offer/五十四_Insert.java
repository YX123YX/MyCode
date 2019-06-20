package Offer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 
 * @author YX
 *
 */
public class 五十四_Insert {
	// Insert one char from stringstream
	LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();

	public void Insert(char ch) {
		if (map.containsKey(ch)) {
			map.put(ch, map.get(ch) + 1);
		} else {
			map.put(ch, 1);
		}
	}

	// return the first appearence once char in current stringstream
	public char FirstAppearingOnce() {
		//你要循环的东西是map.entryset()也就是说把这个map拆开，然后在for循环里循环，每次循环可以得到一个Entry<String,Integer> entry对象，
		//在循环里可以处理。 普通for循环里面能放的东西这个增强for循环一般都能用。
		for (Map.Entry<Character, Integer> set : map.entrySet()) {
			if (set.getValue() == 1) {
				return set.getKey();
			}
		}
		return '#';
	}
}
