import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {123,5135,351,21,915,56,61,6,67,7,23,2};
		quickSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr) {
		quickSort(arr,0, arr.length-1);
		
	}

	private static void quickSort(int[] arr, int left, int right) {
		if(left >= right) {
			return;
		}
		int pivot = arr[(left+right)/2];
		int index = partition(arr,left, right, pivot);
		quickSort(arr, left, index -1);
		quickSort(arr, index, right);
	}

	private static int partition(int[] arr, int left, int right, int pivot) {
		while(left <= right) {
			while(arr[left] < pivot) {
				left++;
			}
			while(arr[right] > pivot) {
				right--;
			}
			if(left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
			
		}
		return left;
	}

	private static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
}

