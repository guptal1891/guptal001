package progs;

import java.util.Arrays;

public class OneStringInAnother {

	static String twoStrings(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0)
			return "NO";

		if (s1.length() < s2.length()) {
			String temp = s1;
			s1 = s2;
			s2 = temp;
		}

		char a[] = s1.toCharArray();
		Arrays.sort(a);

		int index = 0;
		while (index != s2.length()) {

			if (binarySearch(a, s2.charAt(index)) == true) {
				return "YES";
			}
			index++;
		}
		return "NO";
	}

	static private boolean binarySearch(char[] a, char s) {

		int low = 0;
		int high = a.length-1;

		while (low <= high) {
			int mid = (low + high)/2;
			if (s < a[mid])
				high = mid-1;

			else if (s > a[mid])
				low = mid+1;
			else
				return true;
		}

		return false;
	}

	public static void main(String[] s) {

		System.out.println(twoStrings("acbfbds", "werawer"));
	}
}
