package progs;

public class MaxProductSubArray {

	static int maxProductSubArray(int arr[]) {
		int res = -9999;

		int minProduct[] = new int[arr.length];
		int maxProduct[] = new int[arr.length];

		maxProduct[0]=minProduct[0]=res=arr[0];
		if (arr.length == 0)
			return 0;

		for (int i = 1; i < arr.length; i++) {
			maxProduct[i] = Math.max(Math.max(maxProduct[i - 1] * arr[i], minProduct[i - 1] * arr[i]), arr[i]); // maximum of the three
			minProduct[i] = Math.min(Math.min(maxProduct[i - 1] * arr[i], minProduct[i - 1] * arr[i]), arr[i]); // minimum of the three
			res = Math.max(res, maxProduct[i]);
		}

		return res;
	}

	public static void main(String[] s) {

		int arr1[] = { 1, 2, -3, 4 }; // 4
		int arr2[] = { 1, -2, -3, 4 }; // 24
		int arr3[] = { -2, 3, 1 }; // 3
		int arr4[] = { 0, -1, 0, -3, -2, 0, 0 }; // 6
		int arr5[] = { 0, 2, -2, -2, 0 }; // 8

		System.out.println(maxProductSubArray(arr1));
		System.out.println(maxProductSubArray(arr2));
		System.out.println(maxProductSubArray(arr3));
		System.out.println(maxProductSubArray(arr4));
		System.out.println(maxProductSubArray(arr5));
	}
}
