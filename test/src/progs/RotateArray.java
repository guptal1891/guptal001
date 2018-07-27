package progs;

public class RotateArray {
	// Complete the rotLeft function below.
	static int[] rotLeft(int[] arr, int d) {

		int n = arr.length;
		for (int i = 0; i < gcd(n, d); i++) {
			int temp = arr[i];

			int j = i;
			int k = j + d;
			while (true) {
				k = j + d;
				
				if (k >= n) {
					k = k - n;
				}
				if (k == i)
					break;
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}
		return arr;
	}

	static private int gcd(int a, int b) {

		if (b == 0 || a == 0)
			return 0;
		if (a > b)
			return gcd(a - b, b);
		else if (b > a)
			return gcd(a, b - a);
		else
			return a;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		rotLeft(arr, 4);

		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}

}
