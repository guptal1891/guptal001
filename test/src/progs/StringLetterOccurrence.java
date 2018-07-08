package progs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class StringLetterOccurrence {

	static StringBuilder findOccurences(String str) {

		int count = 0, index = 1;
		StringBuilder res = new StringBuilder();

		if (str == null)
			return res.append("-1");
		if (str.length() == 1)
			return res.append(str.charAt(0)).append("1");

		while (index <= str.length() - 1) {

			if (str.charAt(index - 1) != str.charAt(index)) {
				res = res.append(str.charAt(index - 1)).append(String.valueOf(count + 1));
				count = 0;
			} else
				count++;
			index++;
		}

		res.append(str.charAt(index - 1)).append(count + 1);
		return res;
	}

	public static void main(String s[]) {

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter an integer");
		String a = scn.nextLine();
		System.out.println("Enter a String");
		String b = scn.nextLine();
		System.out.println(b);
		System.out.println(a);

		/*
		 * System.out.println(findOccurences("aaabbcdd"));
		 * System.out.println(findOccurences("aaa"));
		 * System.out.println(findOccurences("ab"));
		 * System.out.println(findOccurences("a"));
		 */
	}
}
