package progs;

/*You are given two strings S1 and S2. S2 contains a ‘*’ in middle not at start or end.Now the ‘*’ can be replaced by a NULL character or any other substring from s1.You need to return the number of strings from s2 that are substrigs of s1. Ex-
s1 “aaabbaaabb”

s2 “aa*b”

Ans – 12(Count every occurrence of “aa” matching with a following “b” and sum them all you will get 12)
*/
public class StringBasics {

	public static void main(String[] s) {

		String str1 = "aaabbacvdaaabb";
		String str2 = "aa*b";

		int index = 0;
		int count = 0;

		StringBuffer sb = new StringBuffer("abcd");
		sb.append('A');
		System.out.println(sb);
		
		int x = str2.indexOf('*');
		String startSubstr = str2.substring(0, x);
		String endSubstr = str2.substring(x + 1);

		while (index < str1.length()) {
			int i = str1.indexOf(startSubstr, index);
			if (i != -1)
				count += countOccurrences(str1, endSubstr, i);

			else
				break;
			index = i + 1;
		}
		System.out.println(count);
	}

	private static int countOccurrences(String str, String endSubstr, int i) {

		int count = 0;
		while (i != -1) {
			i = str.indexOf(endSubstr, i + 1);
			count++;
		}

		return count - 1;
	}
}
