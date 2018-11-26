package progs;

import java.util.ArrayList;
import java.util.Scanner;

public class MatrixRotate {

	public static void rotate(ArrayList<ArrayList<Integer>> arr) {

		transponse(arr);
		reverse(arr);

		for (int i = 0; i < arr.size(); i++) {
			System.out.print("[");
			for (int j = 0; j < arr.size(); j++)
				System.out.print(arr.get(i).get(j) + " ");
			System.out.print("]");
		}
	}

	private static void reverse(ArrayList<ArrayList<Integer>> arr) {

		int n = arr.size();
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n / 2; j++) {

				int temp = arr.get(i).get(j);
				arr.get(i).set(j, arr.get(i).get(n - j - 1));
				arr.get(i).set(n - j - 1, temp);
			}
	}

	private static void transponse(ArrayList<ArrayList<Integer>> arr) {

		int n = arr.size();
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++) {

				int temp = arr.get(i).get(j);
				arr.get(i).set(j, arr.get(j).get(i));
				arr.get(j).set(i, temp);
			}
	}

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

		System.out.println("Enter n size of matrix");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {

			ArrayList<Integer> a = new ArrayList<>();
			System.out.println("Enter n numbers");
			for (int j = 0; j < n; j++) {
				a.add(Integer.parseInt(sc.next()));
			}
			arr.add(a);
		}

		rotate(arr);
	}

}
