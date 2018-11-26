package progs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FormLargestNumberFromArrayInt {

	static String getMaxNumber(int size, int[] arr) {

		List<Integer> list = new ArrayList<>();
		for (int x : arr)
			list.add(x);

		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer str1, Integer str2) {

				String XY = str1.toString() + str2.toString();
				String YX = str2.toString() + str1.toString();

				return XY.compareTo(YX) > 0 ? -1 : 1;
			}
		});

		StringBuffer sb = new StringBuffer();

		for (Integer num : list) {

			sb = sb.append(num);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		int[] arr = { 54, 546, 548, 60 };
		System.out.println(getMaxNumber(4, arr));
	}

}
