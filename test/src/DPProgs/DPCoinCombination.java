package DPProgs;

import java.util.Arrays;

/*
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
 *  how many ways can we make the change? The order of coins doesn’t matter.

For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. 
For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5
 */

public class DPCoinCombination {

	static int coinChange(int coin[], int len, int sum) {

		if (sum == 0)
			return 1;

		if (len < 0 || sum < 0)
			return 0;
		return coinChange(coin, len - 1, sum) + coinChange(coin, len, sum - coin[len]);
	}

	static int coinChangeDP(int coin[], int len, int sum) {

		int table[] = new int[sum + 1];
		Arrays.fill(table, 0);
		table[0] = 1;
		for (int i = 0; i < len; i++) {
			for (int j = coin[i]; j <= sum; j++) {
				table[j] += table[j - coin[i]];
			}
		}
		return table[sum];
	}

	public static void main(String s[]) {

		int coin[] = { 1, 2, 3 };
		System.out.println(coinChange(coin, coin.length - 1, 4));
		System.out.println(coinChangeDP(coin, coin.length, 4));

		int coin2[] = { 2, 3, 5, 6 };
		System.out.println(coinChange(coin2, coin2.length - 1, 10));
		System.out.println(coinChangeDP(coin2, coin2.length, 10));
	}
}
