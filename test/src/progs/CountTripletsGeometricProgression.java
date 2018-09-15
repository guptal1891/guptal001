package progs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountTripletsGeometricProgression {

	// Complete the countTriplets function below.
	static long countTriplets(List<Long> list, long r) {

		int res = 0;
		Collections.sort(list, null);
		long[] arr = list.stream().mapToLong(l -> l).toArray();

		long num = 0;

		for (int i = 0; i < arr.length; i++) {

			int c = 1;
			int triplets = 2;
			num = arr[i];
			num = num * r;
			while (triplets > 0 && (c *= findNumOfOccurences(arr, num)) > 0) {
				triplets--;
				num = num * r;
			}
			if (triplets == 0)
				res += c;
		}

		return res;
	}

	static int findNumOfOccurences(long arr[], Long x) {
		int i;
		int j;

		int len = arr.length;
		/* get the index of first occurrence of x */
		i = first(arr, 0, len - 1, x);

		/* If x doesn't exist in arr[] then return -1 */
		if (i == -1)
			return i;

		/*
		 * Else get the index of last occurrence of x. Note that we are only looking in
		 * the subarray after first occurrence
		 */
		j = last(arr, i, len - 1, x);

		/* return count */
		return j - i + 1;
	}

	/*
	 * if x is present in arr[] then returns the index of FIRST occurrence of x in
	 * arr[0..n-1], otherwise returns -1
	 */
	static int first(long arr[], int low, int high, long x) {

		if (high >= low) {
			/* low + (high - low)/2; */
			int mid = (low + high) / 2;
			if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x)
				return mid;
			else if (x > arr[mid])
				return first(arr, (mid + 1), high, x);
			else
				return first(arr, low, (mid - 1), x);
		}
		return -1;
	}

	/*
	 * if x is present in arr[] then returns the index of LAST occurrence of x in
	 * arr[0..n-1], otherwise returns -1
	 */
	static int last(long arr[], int low, int high, long x) {
		if (high >= low) {
			/* low + (high - low)/2; */
			int mid = (low + high) / 2;
			if ((mid == arr.length - 1 || x < arr[mid + 1]) && arr[mid] == x)
				return mid;
			else if (x < arr[mid])
				return last(arr, low, (mid - 1), x);
			else
				return last(arr, (mid + 1), high, x);
		}
		return -1;
	}

	public static void main(String[] args) {

		Long[] arr = { 2l, 5l, 6l, 4l, 4l, 1l };

		List<Long> list = new ArrayList<>();

		System.out.println(countTriplets(Arrays.asList(arr), 2l));
	}

}
