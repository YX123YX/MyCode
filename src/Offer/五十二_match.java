package Offer;

/**
 * ��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��ģʽ�е��ַ�'.'��ʾ����һ���ַ���
 * ��'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ����ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ��
 * ���磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��
 * 
 * 1-1 �����ַ�����Ϊ�գ�����true 1-2��һ���ַ�����Ϊ��ʱ�� 1���ڶ���Ϊ�� ������false��Ϊ���������޷�
 * ƥ��ɹ���,�������һ���ַ������ˣ��ڶ����ַ����ǿգ����ǿ���ƥ��� ���ģ�����ڶ����ַ����ǡ�a*a*a*a*��,
 * ���ڡ�*��֮ǰ��Ԫ�ؿ��Գ���0�Σ������п���ƥ��ɹ��� ֮��Ϳ�ʼƥ���һ���ַ������������ֿ��ܣ�ƥ��ɹ���ƥ��ʧ�ܡ������ǵ�pattern
 * ��һ���ַ������ǡ�*���� �������Ƿ�����������ۣ�pattern��һ���ַ�Ϊ��*���� ��Ϊ��*����
 * 1>pattern��һ���ַ���Ϊ��*������������Ƚϼ򵥣�ֱ��ƥ�䵱ǰ�ַ������ ƥ��ɹ�������ƥ����һ�������ƥ��ʧ�ܣ�ֱ�ӷ���false��ע�������
 * ��ƥ��ɹ��������������ַ���ͬ������⣬����һ�����������pattern�� ��ǰ�ַ�Ϊ��.��,ͬʱstr�ĵ�ǰ�ַ���Ϊ��\0����
 * 2>pattern��һ���ַ�Ϊ��*��ʱ����΢����һЩ����Ϊ��*�����Դ���0�������� �������Щ��������ǵ���
 * a>����*��ƥ��0���ַ�ʱ��str��ǰ�ַ����䣬pattern��ǰ�ַ�������λ�� ���������*�����ţ�
 * b>����*��ƥ��1������ʱ��str��ǰ�ַ�������һ����pattern��ǰ�ַ� ���䡣������ƥ��1���������Կ���һ���������Ϊ����ƥ��һ��ʱ��
 * ����str�Ƶ�����һ���ַ�����pattern�ַ����䣬�ͻص����ϱߵ����a�� ��ƥ�����һ���ַ�ʱ���൱�ڴ�str����һ���ַ�������ʼƥ�䣩
 * 
 * @author YX
 *
 */
public class ��ʮ��_match {
	public boolean match(char[] str, char[] pattern) {
		if (str == null || pattern == null)
			return true;
		int strIndex = 0;
		int patternIndex = 0;
		return matchCore(str, strIndex, pattern, patternIndex);
	}

	private boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
		// ��Ч�Լ��飺str��β��pattern��β��ƥ��ɹ�
		if (strIndex == str.length && patternIndex == pattern.length) {
			return true;
		}
		// pattern�ȵ�β��ƥ��ʧ��
		if (strIndex != str.length && patternIndex == pattern.length) {
			return false;
		}
		// pattern��2����*�����ַ�����1����ģʽ��1��ƥ��,��3��ƥ��ģʽ���粻ƥ�䣬ģʽ����2λ
		if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
			if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])
					|| (pattern[patternIndex] == '.' && strIndex != str.length)) {
				return matchCore(str, strIndex, pattern, patternIndex + 2)// ģʽ����2����Ϊx*ƥ��0���ַ�
						|| matchCore(str, strIndex + 1, pattern, patternIndex + 2)// ��Ϊģʽƥ��1���ַ�
						|| matchCore(str, strIndex + 1, pattern, patternIndex);// *ƥ��1������ƥ��str�е���һ��
			} else {
				return matchCore(str, strIndex, pattern, patternIndex + 2);
			}
		}
		// ģʽ��2������*�����ַ�����1����ģʽ��1��ƥ�䣬�򶼺���1λ������ֱ�ӷ���false
		if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])
				|| (pattern[patternIndex] == '.' && strIndex != str.length)) {
			return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
		}
		return false;
	}
}
