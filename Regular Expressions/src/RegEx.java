import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {

	public static void main(String[] args){
		// This will match a sequence of 1 or more uppercase and lowercase 
		// English letters as well as spaces. Space character = \s
		String myRegExString = "[a-zA-z\\s]+";
		
		// This is the string we will check to see if our regex matches:
		String myString = "Asuncion is a great place to visit in summer...";
		
		// Create a Pattern object (compiled RegEx) and save it as 'p'
		Pattern p = Pattern.compile(myRegExString);
		
		// We need a Matcher to match our compiled RegEx to a String
		Matcher m = p.matcher(myString);
		
		// if our Matcher finds a match
		if(m.find()){
			// Print the match
			System.out.println(m.group());
			
			/*
			 * Notice that the ellipsis (...) at the end of the myString was not printed 
			 * as part of the match; that is because myRegExString only matches lowercase 
			 * and uppercase English letters and spaces—not punctuation. Thus, the ellipsis 
			 * serves as a boundary for the end of our matched text. 
			 */
		}
		
		
		String s = "Hello, Jorge, Joaquin, Vivi. This is New York!";
		Pattern p1 = Pattern.compile("\\p{Alpha}+");
		Matcher m1 = p1.matcher(s);
		
		while(m1.find()){
			System.out.println(m1.group());
		}
		
		String s1 = "Hello, GoodBye, Farewell";
		String s2 = "Hola, Adios, Hasta Luego";
		
		String delimiter = ",";
		
		String[] arrayS1 = s1.split(delimiter);
		String[] arrayS2 = s2.split(delimiter);
		
		for(String newS: arrayS1){
			System.out.println(newS);
		}
		
		for(String newS2: arrayS2){
			System.out.println(newS2);
		}
	}
}
