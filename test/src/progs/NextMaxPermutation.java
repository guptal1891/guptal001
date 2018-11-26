package progs;

import java.util.ArrayList;
import java.util.Collections;

public class NextMaxPermutation {

	public static void nextPermutation(ArrayList<Integer> arr) {

		if (arr.isEmpty())
			return;

		int n = arr.size();
		if (n == 1)
			System.out.println(arr.get(0));

		if (decreasing(arr))
			reverse(arr);

		else if (increasing(arr))
			Collections.swap(arr, n - 1, n - 2);

		else {
			for (int i = n - 2; i >= 0; i--) {
				if (arr.get(i) < arr.get(i + 1)) {
					Collections.swap(arr, i, n - 1);
					Collections.sort(arr.subList(i + 1, n));
				}
			}
		}

		for (int x : arr)
			System.out.print(x + ",");
		
		System.out.println("  ");
	}

	private static void reverse(ArrayList<Integer> arr) {

		for (int i = 0; i < arr.size() / 2; i++)
			Collections.swap(arr, i, arr.size() - 1);
	}

	private static boolean increasing(ArrayList<Integer> arr) {

		for (int i = 0; i < arr.size() - 1; i++)
			if (arr.get(i) > arr.get(i + 1))
				return false;
		return true;
	}

	private static boolean decreasing(ArrayList<Integer> arr) {

		for (int i = 0; i < arr.size() - 1; i++)
			if (arr.get(i) < arr.get(i + 1))
				return false;
		return true;
	}

	public static void main(String[] args) {

		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		nextPermutation(list1); // 1,3,2

		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(1);
		list2.add(1);
		list2.add(5);
		nextPermutation(list2); // 1,5,1

		ArrayList<Integer> list3 = new ArrayList<>();
		list3.add(20);
		list3.add(50);
		list3.add(113);
		nextPermutation(list3); // 20, 113, 50
	}
}
