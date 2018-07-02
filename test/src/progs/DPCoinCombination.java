package progs;

public class DPCoinCombination {

	static int coinChange(int coin[], int len, int sum) {

		if (sum == 0)
			return 1;

		if (len <= 0 || sum < 0)
			return 0;
		return coinChange(coin, len - 1, sum) + coinChange(coin, len, sum - coin[len - 1]);

	}

	public static void main(String s[]) {

		int coin[] = { 1, 2, 3 };
		System.out.println(coinChange(coin, coin.length, 4));
	}
}
