
public class SmallestNumber {
	
	/**
	 * n = 9
	 * result = {19}
	 * 
	 * n = 20, 20/5 = 4, 4/4 = 1
	 * result = {5, 4}
	 * m = 9, 8, 7, 6, 5, 4
	 * j = 0, 1, 2
	 * @param number
	 */
	public static void findSmallestNumber(int number){
		int MAX = 50;
		int i = 9, j = 0;
		int[] result = new int[MAX];
		
		if(number <= 9) {
			result[j] = number + 10;
			j++;
		} else {
			// we're going from 9 to 1 to divide the number
			for(int m=i; m>1; m--){
				while(number % m == 0){
					number = number / m;
					result[j] = m;
					j++;
				}
				
			}
		}
		
		if(j == 0){
			System.out.println(number + " is a prime number.");
		}
		
		// j = 2
		// k = 1
		for(int k=j-1; k >= 0; k--){
			System.out.print(result[k]);
		}
		
		System.out.println("");
	}

	public static void main(String[] args){
		findSmallestNumber(17);
		findSmallestNumber(80);
		findSmallestNumber(25);
		findSmallestNumber(36);
		findSmallestNumber(100);
	}
}
