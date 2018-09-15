package soroco;

public class NumberOfIslandProblem {
		//No of rows and columns
	static final int ROW = 5, COL = 5;

	boolean isSafe(char M[][], int row, int col, boolean visited[][]) {
		// row number is in range, column number is in range
		// and value is 'X' and not yet visited
		return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (M[row][col] == 'X' && !visited[row][col]);
	}

	void DFS(char M[][], int row, int col, boolean visited[][]) {
		int rowNbr[] = new int[] { -1, 0, 0, 1 };
		int colNbr[] = new int[] { 0, 1, -1, 0 };

		// Mark this cell as visited
		visited[row][col] = true;

		// Recur for all connected neighbours
		for (int k = 0; k < 4; ++k)
			if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited))
				DFS(M, row + rowNbr[k], col + colNbr[k], visited);
	}

	// The main function that returns count of islands in a given
	// boolean 2D matrix
	int countIslands(char M[][]) {
		// Make a bool array to mark visited cells.
		// Initially all cells are unvisited
		boolean visited[][] = new boolean[ROW][COL];

		// Initialize count as 0 and travese through the all cells
		// of given matrix
		int count = 0;
		for (int i = 0; i < ROW; ++i)
			for (int j = 0; j < COL; ++j)
				if (M[i][j] == 'X' && !visited[i][j]) // If a cell with
				{ // value 1 is not
					// visited yet, then new island found, Visit all
					// cells in this island and increment island count
					DFS(M, i, j, visited);
					++count;
				}

		return count;
	}

	// Driver method
	public static void main(String[] args) throws java.lang.Exception {
		char M[][] = { { 'X', 'X', 'O', 'O', 'O' }, { 'O', 'X', 'O', 'O', 'X' }, { 'X', 'O', 'O', 'X', 'X' }, { 'O', 'O', 'O', 'O', 'O' }, { 'X', 'O', 'X', 'O', 'X' } };
		NumberOfIslandProblem I = new NumberOfIslandProblem();
		System.out.println("Number of islands is: " + I.countIslands(M));
	}

}
