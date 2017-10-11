/**
 	Input:
 	*****
 	1     2     3     4
    5     6     7     8
    9    10    11    12
   13    14    15    16
   17    18    19    20
   
   Output: 
   ******
    1
    5     2
    9     6     3
   13    10     7     4
   17    14    11     8
   18    15    12
   19    16
   20
   
 * @author jorgecasariego
 */
public class Zigzag {
	public static int R, C;
	
	private static void diagonalOrder(int[][] array) {
		/*
		 * Through this for loop we choose each element
		 * of first column as starting point and print diagonal starting
		 * at it. array[0][0], array[1][0]...array[R-1][0] are all
		 * starting points.
		 */
		for(int k = 0; k < R; k++){
			System.out.print(array[k][0] + " ");
			
			int i = k - 1;	// Set row index for next point in diagonal
			int j = 1;		// Set column index for next point in diagonal
			
			// Print diagonal upward
			while(isValid(i, j)){
				System.out.print(array[i][j] + " ");
				
				i--;
				j++;
			}
			
			System.out.println("");
		}
		
		/*
		 * Through this for loop we choose each element of last
		 * row as starting point (Except the [0][c-1] it has already been
		 * processed in previous for-loop) and print diagonal starting at it.
		 * array[R-1][1]...array[R-1][C-1] are all starting points
		 */
		for(int k = 1; k < C; k++){
			System.out.print(array[R-1][k] + " ");
			
			int i = R - 2; // Set row index for next point in diagonal
			int j = k + 1; // Set column index for next point in diagonal
			
			while(isValid(i, j)){
				System.out.print(array[i][j] + " ");
				
				i--;
				j++;
			}
			
			System.out.println("");
		}
		
	}
	
	private static boolean isValid(int i, int j){
		if( i < 0 || i >= R || j >= C || j < 0)
			return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		int array[][] = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16},
				{17, 18, 19, 20}
		};
		
		R = array.length;
		C = array[0].length;
		
		diagonalOrder(array);
	}

}
