import java.util.HashMap;

public class CoinProblemDynamicProgramming {
	public static void main(String[] args) {
	
		System.out.println(change(12, new int[] { 1, 2, 5 }));
		
		System.out.println(makeChange(new int[] {1,2,5}, 12));
	
	}

	public static int change(int amount, int[] coins) {
		int[] combinations = new int[amount+1];
		combinations[0] = 1;
		for(int coin: coins) {
			for(int i=1;i<combinations.length;i++) {
				if(i >= coin) {
					combinations[i] += combinations[i-coin];
				}
			}
		}
		return combinations[amount];
	}
	
	public static long makeChange(int[] coins, int money) {
		return makeChange(coins, money, 0, new HashMap<String, Long>());
	}

	private static long makeChange(int[] coins, int money, int index, HashMap<String, Long> memo) {
		if(money == 0) {
			return 1;
		}
		if(index >= coins.length) {
			return 0;
		}
		String key = money + "-" + index;
		if(memo.containsKey(key)) {
			return memo.get(key);
		}
		int amountWithCoin = 0;
		long ways = 0;
		while(amountWithCoin <= money) {
			int remaining = money - amountWithCoin;
			ways += makeChange(coins, remaining, index+1, memo);
			amountWithCoin += coins[index];
		}
		memo.put(key, ways);
		return ways;
	}
}
