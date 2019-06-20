package Sort;
/**
 * 冒泡排序（Bubble Sort）
 * 原理：比较两个相邻的元素，将值大的元素交换至右端
 * 		
 * N个数字要排序完成，总共进行N-1趟排序，每i趟的排序次数为(N-i)次，所以可以用双重循环语句，外层控制循环多少趟，内层控制每一趟的循环次数。
 * @author YX
 *
 */
public class MaoPao {
	public void BibbleSort(int[] arr) {
		int n = arr.length;
		//N个数字要排序完成，总共进行N-1趟排序
		for(int i =0 ;i< n-1;i++) {
			//每i趟的排序次数为(N-i)次
			for(int j = 1;j<n-i;j++) {
				if(arr[j-1]>arr[j]) {
					//交换两个元素
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
