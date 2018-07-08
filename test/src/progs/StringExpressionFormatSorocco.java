package progs;

public class StringExpressionFormatSorocco {

	public static String solve(int a[]) {
		String ans = "";
		int n = a.length;
		int i = 0;
		while (i < n) {
			int j = getNextConsecutive(a, i + 1);
			if (j - i >= 2) {
				ans += a[i] + "-" + a[j] + ",";
				i = j + 1;
			} else {
				ans += a[i] + ",";
				i++;
			}
		}
		if (ans.charAt(ans.length() - 1) == ',') {
			ans = ans.substring(0, ans.length() - 1);
		}
		return ans;
	}

	private static int getNextConsecutive(int[] a, int i) {
		int n = a.length;
		while (i < n && a[i] == a[i - 1] + 1)
			i++;
		return i - 1;
	}

	public static void main(String args[]) {
		int a[] = { -3, -2, -1, 5, 6, 7, 9, 11, 12, 13, 15, 16 };
		System.out.println(solve(a));
	}

}