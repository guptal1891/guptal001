package progs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FormLargestNumberFromArrayInt {

	static String getMaxNumber(int size, int[] arr) {

		List<String> list = new ArrayList<>();
		for (int x : arr)
			list.add(String.valueOf(x));

		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {

				String XY = str1 + str2;
				String YX = str2 + str1;

				return XY.compareTo(YX) > 0 ? -1 : 1;
			}
		});

		StringBuffer sb = new StringBuffer();

		for (String str : list) {

			sb = sb.append(str);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		int[] arr = { 54, 546, 548, 60 };
		System.out.println(getMaxNumber(4, arr));
	}

}
