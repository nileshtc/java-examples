import java.util.HashMap;
import java.util.Map;

public class EvenValuedFibo {

	public static int fibo(int n, int[] memo) { 
		if(n<=0) return 0;
		else if(n==1) return 1;
		else if(memo[n] >0) return memo[n];
		memo[n] = fibo(n-1, memo) + fibo(n-2, memo);
		return memo[n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long total = 0L;
		for(int i = 1 ;;i++) {
			int temp = fibo(i, new int[i+1]);
			if(temp <=4000000) {
				if(temp%2 == 0) 
					total += temp;
			}
			else
				break;
		}
		
		System.out.println(total);
		
	}

}
