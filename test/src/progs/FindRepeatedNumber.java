package progs;

import java.util.ArrayList;
import java.util.List;

public class FindRepeatedNumber {

	public static int repeatedNumber(final List<Integer> arr) {

		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(Math.abs(arr.get(i))) >= 0)
				arr.set(Math.abs(arr.get(i)), -arr.get(Math.abs(arr.get(i))));
			else
				return Math.abs(arr.get(i));
		}
		return -1;
	}

	public static void main(String[] args) {

		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(1);
		arr.add(3);
		System.out.println("The repeating elements are : " + repeatedNumber(arr));
	}
}
