package progs;

public class MaxProductSubArray {

	static int maxProductSubArray(int arr[]) {
		int res = -9999;

		int minProduct = 1;
		int maxProduct = 1;

		if (arr.length == 0)
			return 0;

		for (int a : arr) {

			maxProduct = Math.max(maxProduct * a, a);
			minProduct = Math.min(minProduct * a, a);
			res = Math.max(res, Math.max(maxProduct, minProduct));
		}

		return res;
	}

	public static void main(String[] s) {

		int arr1[] = { 1, 2, -3, 4 }; // 4
		int arr2[] = { 1, -2, -3, 4 }; // 24
		int arr3[] = { -2, 3, 1 }; // 3

		System.out.println(maxProductSubArray(arr1));
		System.out.println(maxProductSubArray(arr2));
		System.out.println(maxProductSubArray(arr3));

	}
}
