/**
 * Optimized School Method 
 * We can do following optimizations:
 * 
 *   - Instead of checking till n, we can check till √n because a larger factor of n must be 
 *     a multiple of smaller factor that has been already checked.
 *   
 *   - The algorithm can be improved further by observing that all primes are of the form 6k ± 1, 
 *     with the exception of 2 and 3. This is because all integers can be expressed as (6k + i) 
 *     for some integer k and for i = -1, 0, 1, 2, 3, or 4; 2 divides (6k + 0), (6k + 2), (6k + 4); 
 *     and 3 divides (6k + 3). So a more efficient method is to test if n is divisible by 2 or 3, 
 *     then to check through all the numbers of form 6k ± 1.
 *     
 * @author jorgecasariego
 *
 */
public class Solution {
	// To test if a number is prime we need to control the following:
    // 1) if number <= 1 -> false
    // 2) if number <= 3 -> true
    // 3) if number % 2 == 0 || number % 3 == 0 --> false
    // 4) if number % 6k - 1 == 0 || number % 6k + 1 == 0 --> false
    // 5) else true
    public static boolean isPrime(int number) {
        if(number <= 1) return false;
        if(number <= 3) return true;
        if(number % 2 == 0 || number % 3 == 0) return false;

        for(int i = 5; i*i <= number; i = i + 6) {
            if(number % i == 0 || (number % (i + 2)) == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        int n = 7;
        System.out.println(isPrime(n) ? "Prime" : "Not prime");
        
        n = 5;
        System.out.println(isPrime(n) ? "Prime" : "Not prime");
        
        n = 1;
        System.out.println(isPrime(n) ? "Prime" : "Not prime");
        
        n = 0;
        System.out.println(isPrime(n) ? "Prime" : "Not prime");
        
        n = 21;
        System.out.println(isPrime(n) ? "Prime" : "Not prime");
        
        n = 11;
        System.out.println(isPrime(n) ? "Prime" : "Not prime");
        
        n = 71;
        System.out.println(isPrime(n) ? "Prime" : "Not prime");
        
        n = 5231;
        System.out.println(isPrime(n) ? "Prime" : "Not prime");
        
        n = 35;
        System.out.println(isPrime(n) ? "Prime" : "Not prime");
    	
        n = 10;
        System.out.println("SOLUTION 1: Number of primes less than " + n + " are: " + numberOfPrimes(n));
        
        n = 10;
        System.out.println("SOLUTION 2: Number of primes less than " + n + " are: " + countNumberOfPrimes(n));
        
    }
    
    // Problem 2: Count the number of primes less than a non-negative number, n
    public static int numberOfPrimes(int n) {
    	int counter = 0;
    	
    	
    	for(int i = 2; i < n; i++) {
    		if(isPrime(i)) {
    			counter++;
    		}
    	}
    	
    	return counter;
    }
    
    // Problem 2: Solution 2
    public static int countNumberOfPrimes(int n) {
    	boolean primes[] = new boolean[n];
    	// AL comienzo suponemos que todos son primos
    	for(int i = 0; i < n; i++) {
    		primes[i] = true;
    	}
    	
    	// Por regla vamos a ir hasta √n because a larger factor of n must be 
    	// a multiple of smaller factor that has been already checked.
    	// TEST: 1 2 3 4 5 6 7 8 9 10
    	//       T T T F T F T F F T
    	//			   ^   ^   ^ ^
    	//  i = 3	
    	//  i = 3  j = 3
    	//
    	for (int i = 2; i * i < n; i++) {
    		if(primes[i]) {
    			for(int j = i; j * i < n; j++) {
        			primes[i * j] = false;
        		}
    		}
    	}
    	
    	int counter = 0;
    	for(int i = 2; i < n; i++) {
    		if(primes[i]) {
    			counter++;
    		}
    	}
    	
    	return counter;
    	
    }
}
