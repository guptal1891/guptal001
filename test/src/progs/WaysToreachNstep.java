package progs;

public class WaysToreachNstep {

	// A recursive function used by countWays
	static int countWays(int n) {
		if (n <= 1)
			return n;
		int res = 0;
		for (int i = 1; i <= n; i++)
			res += countWays(n - i);
		return res;
	}

	static int countWaysMain(int n) {
		return countWays(n + 1);
	}

	// Driver program to test above functions-
	public static void main(String[] s) {
		System.out.println("Nuber of ways = " + countWaysMain(1));
		System.out.println("Nuber of ways = " + countWaysMain(2));
		System.out.println("Nuber of ways = " + countWaysMain(3));
		System.out.println("Nuber of ways = " + countWaysMain(4));
		System.out.println("Nuber of ways = " + countWaysMain(7));
	}

}
