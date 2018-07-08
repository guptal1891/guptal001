package progs;

public class PitemsNMBoxes {

	// M can have 1 item, N can have 4 items
	static int numOfBoxes(int p, int m, int n) {

		if (p <= 0 || (p > m + 4 * n))
			return -1;

		if (n == 0 && p <= m)
			return p;

		int res = 0;

		while (p - 4 >= 0 && n != 0) {
			p = p - 4;
			n--;
			res++;
		}

		if (p <= n)
			res += p;
		else
			res = -1;

		return res;
	}

	public static void main(String[] args) {

		System.out.println(numOfBoxes(12, 3, 1));
		System.out.println(numOfBoxes(12, 3, 2));
		System.out.println(numOfBoxes(14, 3, 5));
	}

}
