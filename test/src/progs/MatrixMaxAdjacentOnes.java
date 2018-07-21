package progs;

import java.util.Arrays;

// Given that we can traverse in two directions only : right or down
public class MatrixMaxAdjacentOnes {

	static int count;
	static int cols;
	static int rows;

	static void countOnes(int[][] mat, boolean[][] visited, int i, int j) {

		if (i < rows && j < cols && mat[i][j] == 1 && !visited[i][j]) {
			count++;
			visited[i][j] = true;

			countOnes(mat, visited, i + 1, j);
			countOnes(mat, visited, i, j + 1);
		}
	}

	static int countMaxAdjOnes(int[][] mat) {

		cols = mat[0].length;
		rows = mat.length;

		int max = 0;
		boolean visited[][] = new boolean[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {

				if (!visited[i][j]) {

					countOnes(mat, visited, i, j);
					max = Math.max(max, count);
					count = 0;
				}
			}
		}
		return max;
	}

	public static void main(String[] s) {

		int mat[][] = { { 1, 1, 0, 1 }, { 0, 1, 0, 1 }, { 1, 1, 1, 1 } };

		System.out.println(countMaxAdjOnes(mat));

	}
}
