package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AntiDiagonal {

	public static void main(String[] str) {
		ArrayList<ArrayList<Integer>> rows = new ArrayList<>();

		ArrayList<Integer> first = new ArrayList<>(Arrays.asList(1, 2));
		ArrayList<Integer> sec = new ArrayList<>(Arrays.asList(4, 5));

		rows.add(first);
		rows.add(sec);

		System.out.println(diagonal(rows));
	}

	public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {

		if (A.isEmpty())
			return new ArrayList<>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();

		int initial = 0;
		int n = A.get(0).size() - 1;
		int icount = 0;
		int jcount = 0;

		int i = initial, j = initial;
		while (icount <= n && jcount <= n) {
			ArrayList<Integer> arr = new ArrayList<>();
			while (i <= n && j >= 0) {
				arr.add(A.get(i).get(j));
				System.out.println(A.get(i).get(j));
				i++;
				j--;
			}

			result.add(arr);
			if (i > n) {
				icount++;
				i = initial + icount;
				j = n;
			} else if (j < 0) {
				jcount++;
				j = initial + jcount;
				i = initial;
			}
		}
		return result;
	}
}
