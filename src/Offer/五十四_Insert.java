package Offer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * ��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ������磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ��
 * ��һ��ֻ����һ�ε��ַ���"g"�����Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"��
 * 
 * @author YX
 *
 */
public class ��ʮ��_Insert {
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
		//��Ҫѭ���Ķ�����map.entryset()Ҳ����˵�����map�𿪣�Ȼ����forѭ����ѭ����ÿ��ѭ�����Եõ�һ��Entry<String,Integer> entry����
		//��ѭ������Դ��� ��ͨforѭ�������ܷŵĶ��������ǿforѭ��һ�㶼���á�
		for (Map.Entry<Character, Integer> set : map.entrySet()) {
			if (set.getValue() == 1) {
				return set.getKey();
			}
		}
		return '#';
	}
}
