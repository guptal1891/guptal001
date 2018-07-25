package soroco;

public class DigitsDecoding {

	static int countDecoding(String str, int index, int len) {

		if (str.length() == 0 || Integer.parseInt(str.substring(index)) == 0 || str.charAt(index) == '0')
			return 0;

		if (index >= len)
			return 1;

		int count = 0;
		if (str.charAt(index) > '0' && str.charAt(index) <= '9')
			count = countDecoding(str, index + 1, len);

		if ((index + 2 > len)
				&& (str.charAt(index) == '1' || (str.charAt(index) == '2' && str.charAt(index + 1) < '7')))
			count++;

		if ((index + 2 <= len)
				&& (str.charAt(index) == '1' || (str.charAt(index) == '2' && str.charAt(index + 1) < '7')))
			count += countDecoding(str, index + 2, len);
		return count;
	}

	public static void main(String[] s) {

		System.out.println(countDecoding("12", 0, "12".length() - 1));
		System.out.println(countDecoding("123", 0, "123".length() - 1));
		System.out.println(countDecoding("10", 0, "10".length() - 1));
		System.out.println(countDecoding("100", 0, "100".length() - 1));
		System.out.println(countDecoding("101", 0, "101".length() - 1));
	}
}
