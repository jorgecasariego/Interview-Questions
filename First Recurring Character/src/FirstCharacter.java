import java.util.HashMap;

/*
 * Giving this "ABCDBAR" find the first Recurring Character 
 * 
 * Complexity = O(n)
 */
public class FirstCharacter {
	static HashMap<Character, Integer> memory;
	
	public static Character findFirstRecurring(String characters){
		for(int i=0; i<characters.length(); i++){
			Character key = characters.charAt(i);
			if(memory.containsKey(key)){
				return key;
			}
			memory.put(key, 1);
		}
		
		return null;
	}
	
	
	public static void main(String[] args){
		memory = new HashMap<Character, Integer>();
		
		Character character = findFirstRecurring("ABCDBAR");
		if(character != null){
			System.out.println("First recurring letter is: " + character);
		} else {
			System.out.println("There is not recurring character on giving String");
		}
	}
}
