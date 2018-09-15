package progs;

public class LongestPalindromeLength {

	int longestPaindrome(String str) {

		if (str.length() == 0)
			return 0;
		int palLength = 0;
		int maxlength = 0;
		int len = str.length();

		for (int i = 0; i < str.length(); i++) {

			palLength = Math.max(checkPalindrome(str, i, i, len), checkPalindrome(str, i, i + 1, len));
			maxlength = Math.max(maxlength, palLength);
		}

		return maxlength;
	}

	private int checkPalindrome(String str, int low, int high, int len) {

		int len1 = 1;
		while (low >= 0 && high < len) {

			if (str.charAt(low) == str.charAt(high)) {
				len1 = high - low + 1;
				low--;
				high++;
			} else
				break;
		}
		return len1;
	}

	public static void main(String s[]) {

		LongestPalindromeLength ob = new LongestPalindromeLength();
		System.out.println(ob.longestPaindrome("abcd"));
		System.out.println(ob.longestPaindrome("abba"));
		System.out.println(ob.longestPaindrome("abcdaaabaaa"));

	}
}
