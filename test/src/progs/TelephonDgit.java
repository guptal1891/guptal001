package progs;

public class TelephonDgit {

	public static String arr[] = new String[10];

	public static void setDigit() {
		arr[0] = "";
		arr[1] = "";
		arr[2] = "abc";
		arr[3] = "def";
		arr[4] = "ghi";
		arr[5] = "jkl";
		arr[6] = "mno";
		arr[7] = "pqrs";
		arr[8] = "tuv";
		arr[9] = "wxyz";
	}

	// A recursive function to print all possible words that can be obtained
	// by input number[] of size n. The output words are one by one stored
	// in output[]
	void printWordsUtil(int number[], int curr_digit, StringBuilder output, int n) {
		// Base case, if current output word is prepared
		int i;
		if (curr_digit == n) {
			System.out.println(output);
			return;
		}

		// Try all 3 possible characters for current digir in number[]
		// and recur for remaining digits
		for (i = 0; i < arr[number[curr_digit]].length(); i++) {
			output.append(arr[number[curr_digit]].charAt(i));
			printWordsUtil(number, curr_digit + 1, output, n);
			output.deleteCharAt(curr_digit);
			if (number[curr_digit] == 0 || number[curr_digit] == 1)
				return;
		}
	}

	// A wrapper over printWordsUtil(). It creates an output array and
	// calls printWordsUtil()
	void printWords(int number[], int n) {
		StringBuilder result = new StringBuilder();
		printWordsUtil(number, 0, result, n);
	}

	// Driver program
	public static void main(String s[]) {
		int number[] = { 2, 3, 4 };
		int n = number.length;
		setDigit();
		new TelephonDgit().printWords(number, n);
	}
}
