import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] A = { 3, 1, 2, 4 };

		System.out.println("Resultado: " + Arrays.toString(sortArrayByParity(A)));
	}

	public static int[] sortArrayByParity(int[] A) {
		// TEST: [3,1,2,4] -> [2,1,3,4] -> [2,4,3,1]
		// ^
		// i = 3
		// nextEvenIndex = 1
		// temp = A[nextEvenIndex] = 1
		// A[nextEvenIndex] = A[i] = 4
		// A[i] = temp = 4

		int nextEvenIndex = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 == 0) {
				int temp = A[nextEvenIndex];
				A[nextEvenIndex] = A[i];
				A[i] = temp;
				nextEvenIndex++;
			}
		}

		return A;
	}
}
