import java.io.InputStream;
import java.util.Scanner;

public class GBus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T = 2;
		int[]N = {4,10}; 
		int[]N1 = {15, 25, 30, 35, 45, 50, 10, 20};
		int[]N2 = {10, 15, 5, 12, 40, 55, 1, 10, 25, 35, 45, 50, 20, 28, 27, 35, 15, 40, 4, 5};
		int[]P = {2,3};
		int[]C1 = {15,25};
		int[]C2 = {5,10,27};
		int test[][] = {{2,1},{3,3,4}};
		
		for(int i = 0;i<T;i++) {
			int count = 0;
			int arr[] = compute(N[i],N1,P[i],C1);
			for(int j = 0;j<arr.length;j++){
				if(arr[j] == test[i][j]) {
					count++;
				}
			}
			if(count == P[i]) {
				System.out.println("Test Case "+ (i+1) +" passed" );
			}
			else {
				System.out.println("Test Case "+ (i+1) +" failed" );
			}
		}
		
	}

	private static int[] compute(int i, int[] n1, int j, int[] c1) {
		int arr[] = new int[j];
		return arr;
	}

}
