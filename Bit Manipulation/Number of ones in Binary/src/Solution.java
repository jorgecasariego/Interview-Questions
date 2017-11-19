
public class Solution {

	// I'll do a bitwise using &
	public static void ones(int n){
		int sum = 0;
		
		// TEST - AND (&)
		//	0	0	- 0 
		//	0	1	- 0
		//	1	0	- 0
		//	1	1	- 1
		
		while(n > 0){
			sum += n & 1;
			n >>= 1;
		}
		
		System.out.println("The amount of 1's is " + sum);
	}
	
	
	public static void main(String[] args) {
		
		ones(5); 		// 5 -> 0x101
		
	}
}
