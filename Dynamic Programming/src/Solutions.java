import java.util.HashSet;
import java.util.PriorityQueue;

public class Solutions {
	public static long change(int dollar, int[] coins) {
		if(dollar == 0)  return 1;
		if(coins.length == 0) return 0;
		
		long[] store = new long[dollar + 1];
		store[0] = 1;		//There's always 1 way to make $0
		
		for(int coin : coins){
			for(int i = 0; i < store.length - coin; i++) {
				store[i+coin] += store[i];
			}
		}
		
		return store[dollar];
	}

    public static void main(String[] args) {
        int n = 4;
        int coins[] = {1, 2, 3};
        
        System.out.println(change(n, coins));
    }
}
