package MergeSort.copy;
import java.util.Arrays;
import javax.naming.ldap.SortControl;
/**
 * 归并排序
 * Arrays.toString ，数组无法直接打印，通过其进行转换成字符串
 * @author YX
 *
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void sort(int[] arr) {
		//建立辅助数组，避免频繁开辟空间
		int[] temp = new int[arr.length];
		sort(arr,0,arr.length-1,temp);
	}

	private static void sort(int[] arr, int left, int right, int[] temp) {
		if(left < right) {
			int mid = (left + right)/2;
			sort(arr,left,mid,temp);
			sort(arr,mid+1,right,temp);
			//将两个有序子数组合并操作
			merge(arr,left,mid,right,temp);
		}
		
		
	}

	private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		int i = left;
		int j = mid+1;
		int t = 0;
		while(i <= mid && j <= right) {
			if(arr[i] <= arr[j]) {
				temp[t++] = arr[i++];
			}else {
				temp[t++] = arr[j++];
			}
		}
		while(i <= mid) {
			temp[t++] = arr[i++];
		}
		while(j <= right) {
			temp[t++] = arr[j++];
		}
		//copy原数组，必须将t变为0；
		t = 0;
		//拷贝到原数组
		while(left <= right) {
			arr[left++] = temp[t++];
		}
		
	}

}
