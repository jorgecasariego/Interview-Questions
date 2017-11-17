import java.util.HashMap;

public class Solution {

	static HashMap<Integer, Integer> memo = new HashMap<>();
    
    public static int numberOfWays(int n) {
        if(n == 0)      return 1;
        else if(n < 0)  return 0;
        
        // If we know the value, we don't call the recursive method again. 
        // We return the value saved in the hash
        int key = (n - 1) + (n - 2) + (n - 3);
        
        if(!memo.containsKey(key)) {
            memo.put(key, numberOfWays(n - 1) + numberOfWays(n - 2) + numberOfWays(n - 3));
        }
        
        return memo.get(key);
        
    }
    
    
    public static void main(String[] args) {
    	long initialTime = System.currentTimeMillis();
        
    	System.out.println(numberOfWays(35));
    	
    	long finalTime = System.currentTimeMillis();
    	
    	System.out.println("Seconds: " + (finalTime - initialTime));
        
    }
}
