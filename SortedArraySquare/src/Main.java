import java.util.Arrays;

/*
    Problem

    You have a sorted array of integers. Write a function that returns a sorted array containing the squares of those
    integer.

    Important to ask if the array of integers could be negative!
 */
public class Main {
    public static void main(String[] args) {

        int [] numbers = {-3, -2, 0, 1, 4 };
        int [] sorted = sortedSquaredArray(numbers);
        int [] sorted2 = sortedSquaredArray2(numbers);

        System.out.println("Solution 1: " + Arrays.toString(sorted));
        System.out.println("Solution 2: " + Arrays.toString(sorted2));
    }

    /*
        [-3, -2, 0, 1, 4] = [0, 1, 4, 9, 16]

        [9, 4, 0, 1, 16]

     */
    static int[] sortedSquaredArray(int[] numbers) {

        int[] squareNumbers = new int[numbers.length];

        // O(N)
        for (int i = 0; i < numbers.length; i++) {
            squareNumbers[i] = numbers[i] * numbers[i];
        }

        // The problem: the complexity of this is O(NlogN) -> Quicksort
        Arrays.sort(squareNumbers);

        return squareNumbers;
    }

    /*
            [-5, -3, 0, 1, 2]
                     ^  ^
                  ^
             [4,9,25]

             {-3, -2, 0, 1, 4 }
                   ^     ^
                      ^
             [9,16]

             Solution: the solutions could be to have 2 pointers. One to the left and 1 to the right. Then compare
             the absolute value of boths pointers and check which one is greater. Then add the greater number to the end
             of the array.

             Complexity: Lineal complexity: O(n)
     */
    static int[] sortedSquaredArray2(int[] numbers) {

        int[] squareNumbers = new int[numbers.length];
        int leftPointer = 0;
        int rightPointer = numbers.length - 1;

        for (int i = numbers.length - 1; i >= 0 ; i--) {
            if (Math.abs(numbers[leftPointer]) > Math.abs(numbers[rightPointer])) {
                squareNumbers[i] = numbers[leftPointer] * numbers[leftPointer];
                leftPointer++;
            } else {
                squareNumbers[i] = numbers[rightPointer] * numbers[rightPointer];
                rightPointer--;
            }

        }

        return squareNumbers;
    }
}
