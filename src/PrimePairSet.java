import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PrimePairSet {
	static Set<Long> primes = new HashSet<>();

	private static boolean isPrime(long i) {
		// TODO Auto-generated method stub
		if (primes.contains(i))
			return true;

		if (i <= 1)
			return false;

		for (long j = 2; j < Math.sqrt(i); j++)
			if (i % j == 0)
				return false;
		primes.add(i);
		return true;
	}
	
	public static int pair_prime_sets(int set_size){   //https://projecteuler.net/problem=60
		   // <prime#, list of prime# key can concat with to create prime#>
		   HashMap<Integer,ArrayList<Integer>> cat_primes = new HashMap<Integer, ArrayList<Integer>>(); 
		   boolean solved = false;
		   for (int i=3 ; !solved ; i+=2){
		      if (isPrime(i)){
			cat_primes.put(i, new ArrayList<Integer>());
		        cat_primes.get(i).add(i); // primes cannot concat with themselves, but concat lists 
		                                  // must contain their key to allow for intersection	
			for (int p : cat_primes.keySet()){ // check if newest prime can be concatenated 
		                                           // with discovered primes to make new prime
			   if ((isPrime(Long.parseLong(i+""+p))) && (isPrime(Long.parseLong(p+""+i)))){
			      cat_primes.get(i).add(p);
			      cat_primes.get(p).add(i);
			   }
			}
			for (int p : cat_primes.keySet()){ // intersect concat list of latest prime 
		                                           // against all other prime concat lists
			   ArrayList<Integer> intersect = new ArrayList<Integer>(cat_primes.get(i));
			   intersect.retainAll(cat_primes.get(p));
			   if (intersect.size() >= set_size){ 
			      boolean prime_set = true;
			      for (int k : intersect){
				if (!cat_primes.get(k).containsAll(intersect)){prime_set = false; break;} 
			      }	
			      if (prime_set){
			         solved = true;
			         int prime_set_sum = 0;
			         //String primes_in_set = "";
			         for (int a : intersect){
			            prime_set_sum += a;
			            //primes_in_set += a+", ";
			         }
			         //System.out.println(primes_in_set);
			         return prime_set_sum;
			      }
			   }
		         }
		      }
		   }
		   return 0;   // should never be reached
		}

	public static void main(String[] args) {/*
		// Scanner input = new Scanner(System.in);
		int[] solution = new int[5];
		boolean foundSolution = false;
		int starting = 6;
		if (args.length != 0) {
			starting = Integer.decode(args[0]);
		}
		long start = System.currentTimeMillis();
		long end;
		for (int i = starting, j = i - 1, k = j - 1, l = k - 1, m = l - 1; !foundSolution; i++, j--, k--, l--, m--) {
			if (!isPrime(i)) {
				continue;
			}

			if (!isPrime(j) || !concatPrimes(i, j)) {
				continue;
			}

			if (!isPrime(k) || !concatPrimes(j, k)) {
				continue;
			}

			if (!isPrime(l) || !concatPrimes(k, l)) {
				continue;
			}

			if (!isPrime(m) || !concatPrimes(l, m)) {
				continue;
			}
			if (concatPrimes(i, j, k, l, m)) {
				solution[0] = i;
				solution[1] = j;
				solution[2] = k;
				solution[3] = l;
				solution[4] = m;
				// SUCCEEDED: {8389, 6733, 5701, 5197, 13}
				// ENTER INTO PE: 26033
				foundSolution = true;
				end = System.currentTimeMillis();
				System.out.println(end - start + " ms to execute.");
				System.out.println("SUCCEEDED: {" + i + ", " + j + ", " + k + ", " + l + ", " + m + "}");
				System.out.println("ENTER INTO PE: " + (i + j + k + l + m));

			} else {
				System.out.println("Failed: {" + i + ", " + j + ", " + k + ", " + l + ", " + m + "}"); // Thread.sleep(1);
			}

		}
		*/
		System.out.println(pair_prime_sets(10000));
	}

	// input.close();

	/**
	 * Determines if five primes satisfy PE60's condition.
	 * 
	 * @param a Prime 1
	 * @param b Prime 2
	 * @param c Prime 3
	 * @param d Prime 4
	 * @param e Prime 5
	 * @return true if this satisfies the problem, otherwise false.
	 */
	private static boolean concatPrimes(int a, int b, int c, int d, int e) {
		// if (!isPrime(a) || !isPrime(b) || !isPrime(c) || !isPrime(d) || !isPrime(e))
		// {
		// return false;
		// }
		if (a == b || a == c || a == d || a == e || b == c || b == d || b == e || c == d || c == e || d == e) {
			return false;
		}
		if (!isPrime(Integer.decode("" + a + b)))
			return false;
		if (!isPrime(Integer.decode("" + a + c)))
			return false;
		if (!isPrime(Integer.decode("" + a + d)))
			return false;
		if (!isPrime(Integer.decode("" + a + e)))
			return false;

		if (!isPrime(Integer.decode("" + b + a)))
			return false;
		if (!isPrime(Integer.decode("" + b + c)))
			return false;
		if (!isPrime(Integer.decode("" + b + d)))
			return false;
		if (!isPrime(Integer.decode("" + b + e)))
			return false;

		if (!isPrime(Integer.decode("" + c + a)))
			return false;
		if (!isPrime(Integer.decode("" + c + b)))
			return false;
		if (!isPrime(Integer.decode("" + c + d)))
			return false;
		if (!isPrime(Integer.decode("" + c + e)))
			return false;

		if (!isPrime(Integer.decode("" + d + a)))
			return false;
		if (!isPrime(Integer.decode("" + d + b)))
			return false;
		if (!isPrime(Integer.decode("" + d + c)))
			return false;
		if (!isPrime(Integer.decode("" + d + e)))
			return false;

		if (!isPrime(Integer.decode("" + e + a)))
			return false;
		if (!isPrime(Integer.decode("" + e + b)))
			return false;
		if (!isPrime(Integer.decode("" + e + c)))
			return false;
		if (!isPrime(Integer.decode("" + e + d)))
			return false;
		return true;
	}

	private static boolean concatPrimes(int a, int b) {
		if (a == b)
			return false;
		// if(!isPrime(a) || !isPrime(b))
		// return false;
		if (!isPrime(Integer.decode("" + a + b)))
			return false;
		if (!isPrime(Integer.decode("" + b + a)))
			return false;
		return true;
	}

	/*
	 * private static boolean isPrime(int n) { for (int i = 2; i < Math.sqrt(n);
	 * i++) { if (n % i == 0 || n <= 1) { return false; } } return true; }
	 */
	private static long concat(long i, long j) {
		String con = "" + i + j;
		long k = Long.parseLong(con);
		return k;
	}
}
