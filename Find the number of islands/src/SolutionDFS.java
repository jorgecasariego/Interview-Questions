
/*
 * 
 * What is an island?
 * ******************
 * A group of connected 1s forms an island. For example, the below matrix contains 5 islands
 * 
 *			{1, 1,   0,   0, 0},
 *          {0, 1,   0,   0, 1},
 *          	   \ ^ /
 *          {1, 0, < 0 >, 1, 1},
 *          	   / ˅ \
 *          {0, 0,   0,   0, 0},
 *          {1, 0,   1,   0, 1}
 * 
 * 	What we know?
 *  **************
 *  - A cell in 2D matrix can be connected to 8 neighbors.
 *  - In DFS we call recursively all adjacent vertices
 *  - In this example, we have 8 neighbors
 *  	=> So, unlike standard DFS(), where we recursively call for
 *  		adjacent vertices, here we can recursive call for 8 
 *  		neighbors only.
 *  	=> We keep track of the visited 1s so that they are not visited
 *  		again. 
 *  
 *  Time complexity: O(ROW x COL)
 * 
 */
public class SolutionDFS {
	private static final int ROW = 5;
	private static final int COL = 5;
	
	boolean isSafe(int M[][], int row, int col, boolean[][] visited) {
		// row number is in range, column number is in range
        // and value is 1 and not yet visited
        return (row >= 0) && (row < ROW) &&
               (col >= 0) && (col < COL) &&
               (M[row][col]==1 && !visited[row][col]);
	}

	// This is a utility function to do DFS for a 2D boolean matrix.
	// It only considers the 8 neighbors as adjacent vertices
	/*
	 * 	  -1,-1|-1,0|-1,1
	 * 	   0,-1| i,j| 0,1
	 *     1,-1| 1,0| 1,1
	 *     
	 *  1. In each DFS() call, a component or a sub-graph is visited
	 *  2. We will call DFS on the next un-visited component. 						  TRICKY PART!
	 *  	3. The number of calls to DFS() gives the number of connected components. TRICKY PART!
	 */
	void DFS(int M[][], int row, int col, boolean[][] visited) {
		int rowNeigh[] = new int[]{-1, -1, -1,  0, 0,  1, 1, 1};
		int colNeigh[] = new int[]{-1,  0,  1, -1, 1, -1, 0, 1};
		
		//Mark this row and col as visited
		visited[row][col] = true;
		
		//Recursive for all neighbors
		for(int k = 0; k < 8; ++k){
			if(isSafe(M, row + rowNeigh[k], col + colNeigh[k], visited)) {
				DFS(M, row + rowNeigh[k], col + colNeigh[k], visited);
			}
		}
	}
	
	// This function returns count of islands in a given 2D matrix 
	int countIslands(int M[][]) {
		
		boolean [][] visited = new boolean[ROW][COL];
		
		int count = 0;
		for(int i = 0; i < ROW; ++i) {
			for( int j = 0; j < COL; ++j) {
				// IF a cell with value 1 was not visited yet, 
				// then a new island was found
				// and increment island count
				if(M[i][j] == 1 && !visited[i][j]) {
					DFS(M, i, j, visited);
					++count;
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		int M[][]=  new int[][]    {{1, 1, 0, 0, 0},
						            {0, 1, 0, 0, 1},
						            {1, 0, 0, 1, 1},
						            {0, 0, 0, 0, 0},
						            {1, 0, 1, 0, 1}
						           };

        SolutionDFS I = new SolutionDFS();
		System.out.println("Number of islands is: "+ I.countIslands(M));
	}
}
