
public class RecursiveStairsProblem {
	// Recursive Inefficient sol because if n(4) = n(3) + n(2) n(3) = n(2) + n(1)
	// n(2) = n(1)+ n(0) from n(4) -> n(2) = n(1) + n(0) we see that n(2) is
	// calculated twice, so we should try to not do that, soln. Dynamic Programming.
	// use a storage medium, HashMap or Array to store the value as it is computed
	// and return when a computation which is already done occurs.
	public static int num_ways(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		return num_ways(n - 1) + num_ways(n - 2);
	}
	
	//Dynamic Programming Solution
	public static int num_ways_bottom_up(int n) {
		if(n==0 || n ==1) {
			return 1;
		}
		int nums[] = new int[n+1];
		nums[0] = 1;
		nums[1]= 1;
		for(int i = 2;i<=n;i++) {
			nums[i] = nums[i-1]+ nums[i-2];
		}
		return nums[n];
	}
	
	public static int num_ways(int n, int[] steps) {
		if(n==0) {
			return 1;
		}
		
		int total = 0;
		for(int i=0;i<steps.length;i++) {
			if((n-steps[i]) >=0) {
				total += num_ways(n-steps[i],steps);
			}
		}
		return total; 
	}
	public static int num_ways_bottom_up(int n, int[] steps) {
		if(n == 0) {
			return 1;
		}
		int[] nums = new int[n+1];
		nums[0] = 1;
		for(int i= 1;i<=n;i++) {
			int total = 0;
			for(int j= 0; j < steps.length; j++) {
				if((i - j)  >= 0) {
					total += nums[i-j];
				}
			}
			nums[i] = total;
		}
		return nums[n];
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		long start1 = System.nanoTime();
		System.out.println(num_ways(4));
		long end1 = System.nanoTime();
		long diff1 = end1 - start1;
		System.out.println("Run time : "+ diff1);
		
		
		long start2 = System.nanoTime();
		System.out.println(num_ways_bottom_up(4));
		long end2 = System.nanoTime();
		long diff2 = end2 - start2;
		System.out.println("Run time : "+ diff2);
		
		long start3 = System.nanoTime();
		System.out.println(num_ways(4, new int[] {1,3,5}));
		long end3 = System.nanoTime();
		long diff3 = end3 - start3;
		System.out.println("Run time : "+ diff3);
		
		long start4 = System.nanoTime();
		System.out.println(num_ways_bottom_up(4,new int[] {1,3,5}));
		long end4 = System.nanoTime();
		long diff4 = end4 - start4;
		System.out.println("Run time : "+ diff4);
		
		
	}	

}
