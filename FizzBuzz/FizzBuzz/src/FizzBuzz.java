
//Prints numbers 1 - 100, 25 values per line.
//Numbers that are multiples of 3 are replaced with Fizz
//Numbers that are mulitples of 5 are replaced with Buzz
//Numbers that are multiples of both 3 and 5 are replaced with FizzBuzz
public class FizzBuzz {

	public static void fizzBuzz(int number){
		StringBuilder textToPrint = new StringBuilder();
		
		// Time complexity is O(n).
		for(int i=1; i<=number; i++){
			if(i % 15 == 0){
				textToPrint.append("FizzBuzz");
			} else if(i % 3 == 0){
				textToPrint.append("Fizz");
			} else if(i % 5 == 0 ){
				textToPrint.append("Buzz");
			} else {
				textToPrint.append(String.valueOf(i));
			}
			
			textToPrint.append(" ");
			
			if(textToPrint.length() % 25 == 0){
				textToPrint.append("\n");
			}
		}
		
		System.out.println(textToPrint);
	}
	
	public static void main(String[] args){
		fizzBuzz(15);
	}
}
