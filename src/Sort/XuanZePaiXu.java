package Sort;

/**
 * ѡ������ ԭ���ǣ�ÿһ�˴Ӵ�����ļ�¼��ѡ����С��Ԫ�أ�˳��������ź�����������ֱ��ȫ����¼������ϡ�
 * Ҳ���ǣ�ÿһ����n-i+1(i=1��2����n-1)����¼��ѡȡ�ؼ�����С�ļ�¼��Ϊ���������е�i����¼��
 * 
 * @author YX
 *
 */
public class XuanZePaiXu {
	public static void sort(int[] arr) {
		// ��ʵҲ����Ҫ����forѭ������һ��for����Ҫ���м���,��Ҫ����n��������Ҫn�ˡ�
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			// �ڶ���for��ÿ����Ҫ��˭�Ƚϣ�ֻ�����±꣬������Ԫ�ء�
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIndex] > arr[j]) {
					// �����±�
					minIndex = j;
				}
			}
			swap(arr, i, minIndex);
		}
	}

	/**
	 * �Ǳ����ʽ ����Ԫ��
	 */
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}