import java.util.HashMap;
import java.util.Map;

/**
 * La sucesión comienza con los números 0 y 1,2​ y a partir de estos, «cada término es la suma de los dos anteriores»
 * 
 * “Memoization is an optimization technique used primarily to speed up computer programs by storing the results of 
 * expensive function calls and returning the cached result when the same inputs occur again.”
 * 
 * @author jorgecasariego
 *
 */
public class Fibonacci {

	private static Map<Integer, Integer> memo = new HashMap<>();
	
	public static int fibMemoization(int n){
		if(n == 0 || n == 1){
			return n;
		}
		
		if(!memo.containsKey(n)){
			memo.put(n, fibMemoization(n-1) + fibMemoization(n-2));
		}
		
		return memo.get(n);
		
	}
	
	public static int fib(int n){
		if(n == 0 || n == 1){
			return n;
		} else {
			return fib(n-1) + fib(n-2);
		}
	}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int result = fib(40);
		long endTime = System.currentTimeMillis();
		System.out.println("Result normal fib is: " + result + " Time: " + (endTime-startTime));
		
		startTime = System.currentTimeMillis();
		result = fibMemoization(40);
		endTime = System.currentTimeMillis();
		
		System.out.println("Result fib with memoization is: " + result + " Time: " + (endTime-startTime));
	}
}
