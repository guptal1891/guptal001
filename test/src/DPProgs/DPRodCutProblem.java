package DPProgs;

import java.util.Arrays;

/*
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. 
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces. 
 * For example, if length of the rod is 8 and the values of different pieces are given as following,
 *  then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 */
public class DPRodCutProblem {

	/*
	 * Returns the best obtainable price for a rod of length n and price[] as prices
	 * of different pieces
	 */
	static int cutRodRecursive(int price[], int n) {
		if (n <= 0)
			return 0;
		int max_val = Integer.MIN_VALUE;

		// Recursively cut the rod in different pieces and
		// compare different configurations
		for (int i = 0; i < n; i++)
			max_val = Math.max(max_val, price[i] + cutRodRecursive(price, n - i - 1));

		return max_val;
	}

	static int cutRodDP(int price[], int n) {

		int max =0 ;
		int table[] = new int[n + 1];
		Arrays.fill(table, 0);
		for (int i = 1; i <= n; i++) {
			for(int j=0; j<i; j++) {
				max = Math.max(max, price[j] + table[i-j-1]);  
			table[i] = max;				
			}
		}
		return table[n];
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		int arr[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
		int size = arr.length;
		System.out.println("Maximum Obtainable Value is " + cutRodRecursive(arr, size));
		System.out.println("Maximum Obtainable Value is " + cutRodDP(arr, size));
	}
}
