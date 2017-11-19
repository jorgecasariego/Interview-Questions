
public class Solution {
    
    public static final int ROWS = 5;
    public static final int COLS = 5;
    
    public static boolean isSafe(int[][] M, int row, int col, boolean[][] visited) {
        if(row >= 0 && row < ROWS &&
           col >= 0 && col < COLS && 
           !visited[row][col] && M[row][col] == 1){
            return true;
        }
        
        return false;
    }
    
    public static int DFS(int[][] M, int row, int col, boolean[][] visited) {
        int[] rowsNeigh = new int[] {-1, -1, -1,  0, 0,  1, 1, 1}; 
        int[] colsNeigh = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};
        
        visited[row][col] = true;
        
        int count = 0;
        for(int k = 0; k < 8; k++) {
            if(isSafe(M, row + rowsNeigh[k], col + colsNeigh[k], visited)) {
                count += DFS(M, row + rowsNeigh[k], col + colsNeigh[k], visited);
                count++;
                
            }
        }
        
        return count;
    }
    
    // TEST
    /*
        Connected childrens + Brothers (left & right) + children inherit values from parents
        BFS
        ****
        1 (-1, -1) 1 (-1, 0)    0 (-1, 1)         0
        0 (0, -1)  1 (1, 1)     1 (0, 1)          0
        0 (1, -1)  0 (1, 0)     1 (1, 1)          0
        1          0            0                 0
    */
    
    public static int countCells(int[][] M){
        boolean[][] visited = new boolean[ROWS][COLS];
        
        int max = 0;
        int count = 0;
        for(int i = 0; i < ROWS; i++) {
            for( int j = 0; j < COLS; j++) {
                if(M[i][j] == 1 && !visited[i][j]){
                    count = DFS(M, i, j, visited);
                    
                    count++;
                                        
                    if(count > max){
                        max = count;
                    }
                       
                }
            }
        }
        
        return max;
        
    }

    public static void main(String[] args) {
        int grid[][]=  new int[][] {{1, 1, 0, 0, 0},
						            {0, 1, 0, 0, 1},
						            {1, 0, 0, 1, 1},
						            {0, 0, 0, 0, 0},
						            {1, 0, 1, 0, 1}
						           };
        
        System.out.println(countCells(grid));
        
    }
}
