
public class BinaryString {

	BinaryString(String string){
		for(byte s: string.getBytes()){
			System.out.print(Integer.toBinaryString(s) + " ");
		}
		
		System.out.println("");
	}
	
	BinaryString(Integer number){
		System.out.println(Integer.toBinaryString(number));
	}
	
	//In this example we'll do and OR for each character in the string with the number  8675309
	BinaryString(String string, Integer integer){
		String integerString = Integer.toBinaryString(integer);
		
		for(byte b: string.getBytes()){
			int temp = b | integer;
			System.out.println(Integer.toBinaryString(b) + " OR " + Integer.toBinaryString(integer)
			+ " = " + Integer.toBinaryString(temp) + " = " + temp);	
		}
	}
	
	// Doing recursively
	public static void integerToBinary(int n) {
		if(n < 2){
			System.out.print(n);
		}else  {
			/*
			 * 43 to binary is:                   101011
			 * integerToBinary of 21 (43 / 2) ==> 10101
			 * 		integerToBinary of 10
			 * 			integerToBinary of 5
			 * 				integerToBinary of 2
			 * 					integerToBinary of 1
			 * 					integerToBinary of 0
			 * 				integerToBinary of 1
			 * 			integerToBinary of 0
			 * 		integerToBinary of 1
			 * +
			 * integerToBinary of  1 (43 % 2) ==>      1
			 */
			int lastDigit = n % 2;
			int restOfDigit = n / 2;
			integerToBinary(restOfDigit);
			integerToBinary(lastDigit);
			
		}
			
	}
	
	public static void main(String[] args){
		BinaryString example = new BinaryString("Hello");
		System.out.println("");
		
		BinaryString number = new BinaryString(4);
		
		BinaryString binaryStringOR = new BinaryString("HelloWord", 8675309);
		
		System.out.println("43 to binary is: ");
		integerToBinary(43);
	}
}
