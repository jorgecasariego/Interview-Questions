
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
    	
        
    }
}
