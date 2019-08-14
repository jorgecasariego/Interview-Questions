import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		String s = "leetcode";
		
		System.out.println("Result: " + firstUniqChar(s));
		
		s = "loveleetcode";
		System.out.println("Result: " + firstUniqChar(s));
	}
	
	public static int firstUniqChar(String s) {
		HashMap<Character, Integer> counter = new HashMap<>();
        
        // TEST: leetcode
        //              ^
        // Hash [l = 1, e=2, t=1, c=1, o=1, d=1, e=1]
        //       if hash[key] == 1 return index
        for(int i = 0; i < s.length(); i++) {
            counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1 );
        }
        
        // TEST: loveleetcode
        //       ^
        // l = 2  o=2, v=1, e=4
        for(int i = 0; i < s.length(); i++) {
            if (counter.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        
        return -1;
	}
}
