package progs;

import java.util.ArrayList;

public class MinStepsInGrid {

	public static int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
		return moveOn(A, B, 0, 0, 0);
	}

	static int moveOn(ArrayList<Integer> A, ArrayList<Integer> B, int x, int y, int len) {

		if (x >= A.size() || y >= B.size() || x < 0 || y < 0 || len >= A.size())
			return 999;

		if (!A.contains(A.get(x)) && !B.contains(B.get(y)))
			return 999;

		if (A.get(x) == A.get(A.size() - 1) && B.get(y) == B.get(B.size() - 1)) {
			return len;
		}

		int min = 999;
		int xAxis[] = { 1, -1, 0, 0, -1, 1, -1, 1 };
		int yAxis[] = { 0, 0, 1, -1, -1, 1, 1, -1 };

		for (int i = 0; i < 8; i++) {

			min = Math.min(min, moveOn(A, B, x + xAxis[i], y + yAxis[i], len + 1));
		}

		return min;
	}

	public static void main(String[] args) {

		ArrayList<Integer> listA = new ArrayList<>();
		listA.add(0);
		listA.add(1);
		listA.add(1);
		ArrayList<Integer> listB = new ArrayList<>();
		listB.add(0);
		listB.add(1);
		listB.add(2);
		System.out.println(coverPoints(listA, listB));
	}

}
