package Offer;
/**
 * ��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 * @author YX
 *
 */
public class ��replaceSpace {
	public String replaceSpace(StringBuffer str) {
		
		//�����µ�StringBuilder
		//�ж�charAt
		//���
		
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
