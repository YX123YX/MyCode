package heapSort.copy;

public class HeapSort {
	public static void main(String[] args) {
		int[] array = { 4,5,3,6,7,8 };
		//int[] array = { 19, 38, 7, 36, 5, 5, 3, 2, 1, 0, 56 };
		System.out.println("排序前:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
		System.out.println();
		System.out.println("分割线---------------");
		heapSort(array);
		System.out.println("排序后:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
	}
	//堆排序
	private static void heapSort(int[] array) {
		//1.现将数组变成   大根堆|小根堆
		buildArrayToheap(array);
		//2.交换开始和结尾元素，去除结尾元素
		for(int i = array.length-1;i>=0;i--) {
			swap(array, i, 0);
			buildMaxHeap(array, i, 0);
		}
	}
	
	//建堆
	private static void buildArrayToheap(int[] array) {
		if(array == null || array.length == 1)
			return;
		int current = (array.length/2) - 1;
		for(int i = current ; i >= 0 ;i--) {
			//建立大根堆
			buildMaxHeap(array,array.length,i);
			//建立小根堆
			//buildMinHeap(array,array.length,i);
		}
		
	}
	private static void buildMinHeap(int[] array, int length, int current) {
		if(array == null || array.length == 1)
			return;
		int left = current*2+1;
		int right = current*2+2;
		int minValue = current;
		if(left < length && array[left] < array[minValue])
			minValue = left;
		if(right < length && array[right] < array[minValue])
			minValue = right;
		if(minValue != current) {
			swap(array,current,minValue);
			buildMinHeap(array, length, minValue);
		}
		
	}
	private static void buildMaxHeap(int[] array, int length, int current) {
		if(array == null || array.length == 1)
			return;
		int left = current * 2+1;
		int right = current * 2+2;
		int maxValue = current;
		if(left < length && array[left] > array[maxValue])
			maxValue = left;
		if(right < length && array[right] > array[maxValue])
			maxValue = right;
		if(maxValue != current) {
			swap(array,current,maxValue);
			buildMaxHeap(array, length, maxValue);
		}
			
	}
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}

	
}
