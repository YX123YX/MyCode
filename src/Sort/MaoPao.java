package Sort;
/**
 * ð������Bubble Sort��
 * ԭ���Ƚ��������ڵ�Ԫ�أ���ֵ���Ԫ�ؽ������Ҷ�
 * 		
 * N������Ҫ������ɣ��ܹ�����N-1������ÿi�˵��������Ϊ(N-i)�Σ����Կ�����˫��ѭ����䣬������ѭ�������ˣ��ڲ����ÿһ�˵�ѭ��������
 * @author YX
 *
 */
public class MaoPao {
	public void BibbleSort(int[] arr) {
		int n = arr.length;
		//N������Ҫ������ɣ��ܹ�����N-1������
		for(int i =0 ;i< n-1;i++) {
			//ÿi�˵��������Ϊ(N-i)��
			for(int j = 1;j<n-i;j++) {
				if(arr[j-1]>arr[j]) {
					//��������Ԫ��
	               swap(arr,j-1,j);
				}
			}
		}
	}

	private void swap(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		 int temp = arr[j];
         arr[j] = arr[j - 1];
         arr[j - 1] = temp;
		
	}
}
