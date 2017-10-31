
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
	
	public static void main(String[] args){
		BinaryString example = new BinaryString("Hello");
		System.out.println("");
		
		BinaryString number = new BinaryString(4);
		
		BinaryString binaryStringOR = new BinaryString("HelloWord", 8675309);
	}
}
