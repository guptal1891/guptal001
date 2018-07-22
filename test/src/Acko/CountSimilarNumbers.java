package Acko;

public class CountSimilarNumbers {

	static long findSimilar(String a, String b) {

		if (a == null)
			return findSimilarCount(b, initializeCount(b));

		if (b == null)
			return findSimilarCount(a, initializeCount(a));

		// Logic to count number of occurrences of both strings
		int count1[] = initializeCount(a);
		int count2[] = initializeCount(b);

		if (a.length() == b.length()) {

			if (isSimilar(count1, count2)) {

				return findSimilarCount(a, count1);
			}
		}

		return findSimilarCount(b, count2);
	}

	private static boolean isSimilar(int count1[], int count2[]) {

		for (int j = 0; j < 10; j++) {

			if (count1[j] != count2[j])
				return false;
		}

		return true;
	}

	private static int[] initializeCount(String inStr) {
		int count[] = new int[10];

		for (int i = 0; i < 10; i++) {
			count[i] = 0;
		}

		int i = 0;
		while (i < inStr.length())
			count[inStr.charAt(i++) - '0']++;
		return count;
	}

	private static long findSimilarCount(String str, int count[]) {

		int fact = 1;

		int nonZerosCount = str.length() - count[0];

		for (int i = 0; i < 10; i++)
			fact = fact * factorial(count[i]);

		return nonZerosCount * factorial(str.length() - 1) / fact;
	}

	static int factorial(int n) {
		int fact = 1;
		for (int i = 2; i <= n; i++)
			fact = fact * i;
		return fact;
	}

	public static void main(String[] args) {
		// System.out.println(removeZero("0020"));
		// System.out.println(removeZero("020"));
		// System.out.println(removeZero("20"));
		System.out.println(findSimilar("1234", "2341"));
		System.out.println(findSimilar("1100", "1001"));
		System.out.println(findSimilar("1234", "1213"));
	}

}
