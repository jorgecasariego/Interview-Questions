/**
 	An image is represented by a 2-D array of integers, each integer representing the pixel value of the 
 	image (from 0 to 65535).

	Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, 
	and a pixel value newColor, "flood fill" the image.
	
	To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally 
	to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally 
	to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of 
	the aforementioned pixels with the newColor.
	
	At the end, return the modified image.
	
	Example 1:
	
	Input: 
	image = [[1,1,1],[1,1,0],[1,0,1]]
	sr = 1, sc = 1, newColor = 2
	Output: [[2,2,2],[2,2,0],[2,0,1]]
	
	Explanation: 
	From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
	by a path of the same color as the starting pixel are colored with the new color.
	Note the bottom corner is not colored 2, because it is not 4-directionally connected
	to the starting pixel.
	
	Note:
	- The length of image and image[0] will be in the range [1, 50].
	- The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
	- The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
	
 * @author jorgecasariego
 *
 */
public class Main {
	
	public static void main(String[] args) {
		int[][] image = new int[3][3];
		image[0] = new int[] {1, 1, 1};
		image[1] = new int[] {1, 1, 0};
		image[2] = new int[] {1, 0, 1};
		
		int sr = 1;
		int sc = 1;
		int newColor = 2;
		
		int[][] result = floodFill(image, sr, sc, newColor);
		
		for(int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	/*
	 	Time complexity: O(n), where N is the number of pixels in the image. We might process every pixel.
	 	Space complexity: O(n), the size of the implicit call stack when calling dfs.
	 */
	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // If the actual pixel is newColor we don't have more to do
        if (image[sr][sc] == newColor) {
            return image;
        }
        
        // Will do here DFS to flood all the pixels from the starting pixel
        dfs(image, sr, sc, image[sr][sc], newColor);
        
        return image;
        
    }
    
    public static void dfs (int[][] image, int i, int j, int color, int newColor) {
        if (
            i < 0 ||                 // TOP
            i >= image.length ||     // BOTTOM
            j < 0 ||                 // LEFT
            j >= image[i].length ||  // RIGHT
            image[i][j] == newColor) {
            return;
        }
        
        if (image[i][j] == color) {
            image[i][j] = newColor;
        
            dfs(image, i-1, j, color, newColor);  //TOP
            dfs(image, i+1, j, color, newColor);  //BOTTOM
            dfs(image, i, j-1, color, newColor);  //LEFT
            dfs(image, i, j+1, color, newColor);  //RIGHT
        }
        
    }

}
