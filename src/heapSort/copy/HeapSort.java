package heapSort.copy;

public class HeapSort {
	public static void main(String[] args) {
		int[] array = { 4,5,3,6,7,8 };
		//int[] array = { 19, 38, 7, 36, 5, 5, 3, 2, 1, 0, 56 };
		System.out.println("����ǰ:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
		System.out.println();
		System.out.println("�ָ���---------------");
		heapSort(array);
		System.out.println("�����:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
	}
	//������
	private static void heapSort(int[] array) {
		//1.�ֽ�������   �����|С����
		buildArrayToheap(array);
		//2.������ʼ�ͽ�βԪ�أ�ȥ����βԪ��
		for(int i = array.length-1;i>=0;i--) {
			swap(array, i, 0);
			buildMaxHeap(array, i, 0);
		}
	}
	
	//����
	private static void buildArrayToheap(int[] array) {
		if(array == null || array.length == 1)
			return;
		int current = (array.length/2) - 1;
		for(int i = current ; i >= 0 ;i--) {
			//���������
			buildMaxHeap(array,array.length,i);
			//����С����
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
