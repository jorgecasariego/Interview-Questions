/**
 * Given a 32-bit signed integer, reverse digits of an integer.

	Example 1:
	
	Input: 123
	Output:  321
	Example 2:
	
	Input: -123
	Output: -321
	Example 3:
	
	Input: 120
	Output: 21
	
	Note:
	Assume we are dealing with an environment which could only hold integers within the 
	32-bit signed integer range. For the purpose of this problem, assume that your function 
	returns 0 when the reversed integer overflows.
	
 * @author jorgecasariego
 *
 */
public class Main {
	public static void main(String args[]) {
		System.out.println("x is 123 and the reverse: " + reverse(123));
		System.out.println("x is -123 and the reverse: " + reverse(-123));
		System.out.println("x is -132132123 and the reverse: " + reverse(-132132123));
		System.out.println("x is 532321987 and the reverse: " + reverse(532321987));
	}
	
	static public int reverse(int x) {
        int lastDigit = 0;
        int reverseNumber = 0;
        int newNumber = 0;
        int type = 1;
        
        if( x < 0) {
            type = -1;
            x = -x;
        }

        while(x != 0) {
            lastDigit = x % 10;
            
            newNumber = reverseNumber * 10 + lastDigit;
            if(reverseNumber != (newNumber - lastDigit)/10){
                return 0;
            }
            
            reverseNumber = newNumber;
            x = x / 10;
        }
        
        return reverseNumber * type;
    }
}
