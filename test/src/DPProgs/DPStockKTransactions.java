package DPProgs;

public class DPStockKTransactions {

	static int getMaxProfit(int[] price, int n, int k) {

		int[][] res = new int[k + 1][n + 1];

		for (int i = 0; i <= k; i++)
			res[i][1] = 0;

		for (int i = 0; i <= n; i++)
			res[1][i] = 0;

		for (int i = 1; i <= k; i++) {
			int max = -9999;
			for (int j = 1; j < n; j++) {
				for (int m = 0; m < j; m++)
					max = Math.max(max, price[j] - price[m] + res[i - 1][m]);
				res[i][j] = Math.max(max, res[i][j - 1]);
			}

		}
		return res[k][n-1];
	}

	public static void main(String[] s) {

		int k = 3;
		int price[] = { 12, 14, 17, 10, 14, 13, 12, 15 };
		int n = price.length;
		System.out.println("Maximum profit is: " + getMaxProfit(price, n, k));

	}

}
