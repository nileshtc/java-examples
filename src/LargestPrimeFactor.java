public class LargestPrimeFactor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long N = 600851475143L;
		long time = System.currentTimeMillis();
		System.out.println();
		long maxPrime = -1;
		while(N %2 == 0) {
			maxPrime = 2;
			N>>=1;
		}
		
		for (long i = 3; i <= Math.sqrt(N); i+=2)
			while(N%i == 0) {
				maxPrime = i;
				N /=i;
			}
		
		if(N>2)
			maxPrime= N;
		long endtime = System.currentTimeMillis();
		System.out.println(endtime - time);
		System.out.println(maxPrime);
	}

	private static boolean checkIfPrime(long i) {
		// TODO Auto-generated method stub
		if (i <= 1)
			return false;

		for (long j = 2; j < Math.sqrt(i); j++)
			if (i % j == 0)
				return false;

		return true;
	}

}
