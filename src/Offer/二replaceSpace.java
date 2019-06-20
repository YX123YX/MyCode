package Offer;
/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @author YX
 *
 */
public class 二replaceSpace {
	public String replaceSpace(StringBuffer str) {
		
		//创建新的StringBuilder
		//判断charAt
		//添加
		
		StringBuilder strr = new StringBuilder();
		for(int i = 0;i<str.length();i++) {
			if(str.charAt(i) == ' ') {
				strr.append("%20");
			}else {
				strr.append(str.charAt(i));
			}
		}
		return strr.toString();
		
	}
}
