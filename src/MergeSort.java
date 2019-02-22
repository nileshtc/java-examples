import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {123,5135,351,21,915,56,61,6,67,7,23,2};
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int[] arr) {
		
		mergeSort(arr, new int[arr.length],0,arr.length-1);
	}
	// divide the array into smaller bits
	private static void mergeSort(int[] arr, int [] temp,int leftStart, int rightEnd) {
		if(leftStart >= rightEnd) {
			return;
		}
		int mid = (leftStart + rightEnd)/2;
		mergeSort(arr,temp,leftStart, mid);
		mergeSort(arr, temp, mid+1, rightEnd);
		mergeHalves(arr, temp, leftStart, rightEnd);
	}

	//helper method to merge the half
	private static void mergeHalves(int[] arr, int[] temp, int leftStart, int rightEnd) {
		
		int leftEnd = (leftStart + rightEnd)/2;
		int rightStart = leftEnd +1;
		int size = (rightEnd - leftStart)+1;
		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
		while(left <= leftEnd && right<=rightEnd) {
			if(arr[left] <= arr[right]) {
				temp[index] = arr[left];
				left++;
			}
			else {
				temp[index] = arr[right];
				right++;
			}
			index++;
		}
		System.arraycopy(arr, left, temp, index, leftEnd - left +1);
		System.arraycopy(arr, right, temp, index, rightEnd - right +1);
		System.arraycopy(temp, leftStart, arr, leftStart, size);
	}

}
