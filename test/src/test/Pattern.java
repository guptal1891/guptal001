package test;

import java.util.Scanner;

class Pattern {

	static void printPattern(int num, int n1, int n2) {

		int t= 0;
		int start=0;
		int end = 2 * n1 -2;
		for (; num>0; num--) {
			for (int row = 0; row < (2 * n1 - 1); row++) {
				for (int col = 0; col < (2 * n1 - 1); col++) {

					if(row == start || row == end || col == start || col == end) {
						t=0;
					}
					System.out.println(n1 - t);

					if (col < n1 & t< row)
						t++;
					else
						t--;
				}
			}

		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		System.out.println("" + num + n1 + n2);
		Pattern.printPattern(num, n1, n2);
	}
}
