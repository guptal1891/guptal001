package progs;

public class LongestPalondromeString {

	private String longestPalindrome(String str) {

		if (str.length() == 0)
			return "";
		String maxLengthStr = "";
		int len = str.length();

		for (int i = 0; i < str.length(); i++) {

			String str1 = checkPalindrome(str, i, i, len);
			String str2 = checkPalindrome(str, i, i + 1, len);
			maxLengthStr = maxLengthStr.length() > str2.length() ? maxLengthStr : str2;
			maxLengthStr = maxLengthStr.length() > str1.length() ? maxLengthStr : str1;
		}

		return maxLengthStr;
	}

	private String checkPalindrome(String str, int low, int high, int len) {

		while (low >= 0 && high < len) {

			if (str.charAt(low) == str.charAt(high)) {
				low--;
				high++;
			} else
				break;
		}
		
		return str.substring(low + 1, high);
	}

	public static void main(String s[]) {

		LongestPalondromeString ob = new LongestPalondromeString();
		System.out.println(ob.longestPalindrome("abcd"));
		System.out.println(ob.longestPalindrome("abba"));
		System.out.println(ob.longestPalindrome("abcdaaabaaa"));

	}
}
