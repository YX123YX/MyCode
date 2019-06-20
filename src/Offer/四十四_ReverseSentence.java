package Offer;
/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * @author YX
 *
 */
public class 四十四_ReverseSentence {
	public String ReverseSentence(String str) {
		if(str == null || str.length() == 1)
			return str;
		char[] array = str.toCharArray();
		//1.先翻转整个句子
		swap(array,0,array.length-1);
		//2.再翻转每个单词
		int blank = -1;
		for(int i = 0;i<array.length-1;i++) {
			if(array[i] == ' ') {
				int nextBlank = i;
				swap(array, blank+1, nextBlank-1);
				blank = nextBlank;
			}
		}
		//还剩下最后一个单词没翻转
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
