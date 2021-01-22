public class SolutionDivide {
    public static void main(String[] args) {
        System.out.println("Approach 1: " + divide1(6,2));

        System.out.println("Approach 1_1: " + divide1_1(60,10));
        System.out.println("Approach 1_1: " + divide1_1(-60,10));
        System.out.println("Approach 1_1: " + divide1_1(-60,10));
        System.out.println("Approach 1_1: " + divide1_1(-60,-10));

        System.out.println("Approach 1_1: " + divide1_1(-5,-2));

        System.out.println("Approach 2: " + divide2(60,10));
        System.out.println("Approach 2: " + divide2(-60,10));
        System.out.println("Approach 2: " + divide2(-60,10));
        System.out.println("Approach 2: " + divide2(-60,-10));

        System.out.println("Approach 2: " + divide2(93706,157));
    }

    /**
     * Aproach 1
     * ---------
     * The result of dividing the dividend by the divisor is the number of times we could subtract the divisor
     * from the dividend. A commonly used name for this result is the quotient.
     *
     * Observation: This doesn't work if one, or both, of the dividend or divisor are negative
     *
     * Trying to generalise this code to handle all four of the possible sign combinations is problematic, because some
     * are repeated addition instead of subtraction, and some have a <= 0 continuation case instead of >= 0.
     *
     * A logical solution here is to simply convert any negative inputs to positives, and then put a negative sign back
     * on at the end if needed. Recall that positive * negative = negative, and negative * negative = positive.
     * In other words, if there was exactly one negative sign in the inputs, the final result is negative.
     * Otherwise, it's positive.
     *
     * For example:
     *
     *  60 /  10 =  6
     * -60 /  10 = -6
     *  60 / -10 = -6
     * -60 / -10 =  6
     * @param dividend
     * @param divisor
     * @return
     */
    static public int divide1(int dividend, int divisor) {
        int quotient = 0;

        while (quotient < divisor) {
            quotient++;
            dividend = dividend - divisor;
        }

        return quotient;
    }

    /**
     * Approach 1_1:
     * We'll avoid using abs because if cause overflow.
     *  So for now, let's just use some conditionals so that we can count the negative signs at the same time as making
     *  the numbers positive. At the end, we'll then need to put the sign back on if needed.
     *
     *  Observation: Firstly, we haven't handled the -2147483648 / -1 case. Like we said in the Overview section,
     *  this case is best handled as a special case at the start of the algorithm.
     *
     * if (dividend == -2147483648 && divisor == -1) {
     *     return 2147483647;
     * }
     *
     * @param dividend
     * @param divisor
     * @return
     */
    static public int divide1_1(int dividend, int divisor) {
        // Count the number of negatives + convert parameters to positives.
        int negatives = 0;
        int subtractions = 0;

        if(dividend < 0) {
            negatives++;
            dividend = -dividend;
        }

        if (divisor < 0) {
            negatives++;
            divisor = -divisor;
        }

        while (dividend - divisor >= 0) {
            subtractions++;
            dividend = dividend - divisor;
        }

        // Convert back to negative if need
        if (negatives == 1) {
            subtractions = -subtractions;
        }

        return subtractions;
    }

    /**
     *
     * Approach 1_2:
     * Problems with other languages besides Java
     * The second issue doesn't happen in Java, but it will happen with the same algorithm in C—an integer overflow.
     * In Java, the math happens to combine perfectly with Java's overflow behaviour to give the correct answers.
     * Because our goal for this solution article is to develop portable algorithms that work with any
     * compiler/interpreter/language, we still want to fix this (and will need this same idea for our other approaches
     * anyway). Specifically, the potentially problematic code is on these lines:
     *
     * dividend = -dividend;
     * and
     *
     * divisor = -divisor;
     *
     * If dividend = -2147483648, then converting it to a positive number will behave differently depending on the
     * language/compiler/interpreter you're using. This is because the positive form (2147483648) is outside of the
     * 32-bit signed integer range.
     *
     * Treating this as an edge case is impractical—it affects billions of cases. We'll need a better way.
     *
     * The key observation to make is that the problems are occurring because there are more negative signed 32-bit
     * integers than there are positive signed 32-bit integers. Each positive signed 32-bit integer has a corresponding
     * negative signed 32-bit integer. However, the same is not true for negative signed 32-bit integers. The smallest
     * one, -2147483648, is alone. It is this number that causes the problems.
     *
     * The best solution is to work with negative, instead of positive, numbers. This is allows us to use the largest
     * possible range of numbers, and it covers all the ones we need.
     *
     * At the start of the algorithm, we'll instead convert both inputs to negative. Then, we'll need to modify the
     * loop so that it subtracts the negative divisor from the negative dividend. At the end, we'll need to convert
     * the result back to a positive if the number of negative signs in the input was not 1.
     *
     * The code for this is our complete approach 1, and can be found in the code box below.
     *
     * Complexity Analysis
     *
     * Let n be the absolute value of dividend.
     *
     * Time Complexity : O(n).
     *
     * Consider the worst case where the divisor is
     * 1. For any dividend n, we'll need to subtract
     * 1 a total of n times to get to 0. Therefore, the time complexity is O(n) in the worst case.
     *
     * Space Complexity :
     * O(1).
     *
     * We only use a fixed number of integer variables, so the space complexity is O(1).
     *
     * Seeing as
     * n can be up to 2^31, this algorithm is too slow on the largest test cases. We'll need to do better!
     */
    static public int divide1_2(int dividend, int divisor) {
        int subtractions = 0;

        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        /* We need to convert both numbers to negatives
         * for the reasons explained above.
         * Also, we count the number of negatives signs. */
        int negatives = 2;

        if (dividend > 0) {
            negatives--;
            dividend = -dividend;
        }

        if (divisor > 0) {
            negatives--;
            divisor = -divisor;
        }

        while (dividend - divisor <= 0) {
            subtractions++;
            dividend = dividend - divisor;
        }

        // Convert back to negative if need
        if (negatives != 1) {
            subtractions = -subtractions;
        }

        return subtractions;
    }

    /**
     * Approach 2: Repeated Exponential Searches
     *
     * Intuition
     *
     * Linear Search is too slow because at each step, we only subtract one copy of the divisor from the dividend.
     * A better way would be to try and subtract multiple copies of the divisor each time.
     *
     * One way of quickly increasing numbers, without using multiplication, is to double them repeatedly. So let's try
     * doubling the divisor until it no longer fits into the dividend.
     *
     * It'll be easiest to understand with an example, so let's say we have a dividend of 93706 and a divisor of 157.
     * We'll now just see what happens when we repeatedly double 157 until it's bigger than 93706.
     *
     * 157
     * 314
     * 628
     * 1256
     * 2512
     * 5024
     * 10048
     * 20096
     * 40192
     * 80384
     * 160768 # Too big
     *
     * From this, we know that we can fit 80384 into 93706, and that 80384 must be a multiple of 157. But how many
     * copies of 157 is this?
     *
     * Well, each time we double a number we also double the amount of copies of the original number. So because we
     * doubled 157 nine times, we must have had 2⁹ copies of 157. Indeed, 2⁹ · 157 = 80384. Yay!
     *
     * But, we still have some left over—in fact we have 93706 - 80384 = 13322 left over! That's still a lot of copies
     * of 157 we haven't counted! So what could we do about this? Well, if we work out how many times 157 fits into 13322,
     * we could just add that to 512 to get our result.
     *
     * How can we work out how many times 157 fits into 13322? Well, we just repeat the same process, adding to the
     * result as we go, until there's nothing left for 157 to fit into.
     *
     * If we do this, we'll find that 157 · 2⁶ = 10048 is the highest power that fits into 13322, leaving us with
     * 13322 - 10048 = 3274 and a quotient so far of 2⁶ + 2⁹ = 576 (if you noticed that 10048 looks very familiar,
     * well done. We'll be looking at this in approach 3).
     *
     * We repeat this process until the dividend is less than 157.
     *
     * Here is the algorithm in code (for this example we're pretending the numbers are positive, and we're ignoring
     * the "overflow" case. In the actual code, we use negatives numbers to prevent the overflow).

     int quotient = 0;
     // Once the divisor is bigger than the current dividend,
     // we can't fit any more copies of the divisor into it.
     while (dividend >= divisor) {
        // * Now that we're in the loop, we know it'll fit at least once as
        // * divivend >= divisor
        int powerOfTwo = 1;
        int value = quotient;

        // * Check if double the current value is too big. If not, continue doubling.
        // * If it is too big, stop doubling and continue with the next step
        while (value + value < dividend) {
            value += value;
            powerOfTwo += powerOfTwo;
        }

        // We have been able to subtract divisor another powerOfTwo times.
        quotient += powerOfTwo;

        // Remove value so far so that we can continue the process with remainder.
        dividend -= value;
     }

        return quotient;

     //*************************
     This algorithm is known as exponential search and is commonly used for searching sorted spaces of unknown size for
     the first value that past a particular condition. It it a lot like binary search, having the same time complexity
     of O(logn). I believe this is why this question is tagged as binary search (there is technically a way of using
     binary search, but it is a lot more complicated and gives no real efficiency gain, and so we won't be talking
     about it in this article.).

     Complexity Analysis

     Let n be the absolute value of dividend.

     Time Complexity :
     O(log^2 n)

     We started by performing an exponential search to find the biggest number that fits into the current dividend.
     This search took
     O(logn) operations.

     After doing this search, we updated the dividend by subtracting the number we found. In the worst case, we were
     left with a dividend slightly less than half of the previous dividend (if it was more than half, then we couldn't
     have found the maximum number that fit in by doubling!).

     So how many of these searches did we need to do? Well, with the dividend at least halving after each one,
     there couldn't have been more than O(logn) of them.

     So combined together, in the worst case, we have O(logn) searches with each search taking O(logn) time. This gives us
     O((logn)⋅(logn))=O(log^2 n) as our total time complexity.

     Space Complexity : O(1).

     Because only a constant number of single-value variables are used, the space complexity is O(1).
     */

    private static int HALF_INT_MIN = -1073741824;

    static public int divide2(int dividend, int divisor) {
        // Special case: overflow.
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        /* We need to convert both numbers to negatives.
         * Also, we count the number of negatives signs. */
        int negatives = 2;
        if (dividend > 0) {
            negatives--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negatives--;
            divisor = -divisor;
        }

        int substration = 0;
        /* Once the divisor is bigger than the current dividend,
         * we can't fit any more copies of the divisor into it. */
        while (divisor >= dividend) {
            /* We know it'll fit at least once as divivend >= divisor.
             * Note: We use a negative powerOfTwo as it's possible we might have
             * the case divide(INT_MIN, -1). */
            int powerOfTwo = -1;
            int value = divisor;
            /* Check if double the current value is too big. If not, continue doubling.
             * If it is too big, stop doubling and continue with the next step */
            while (value >= HALF_INT_MIN && value + value >= dividend) {
                value += value;
                powerOfTwo += powerOfTwo;
            }
            // We have been able to subtract divisor another powerOfTwo times.
            substration += powerOfTwo;
            // Remove value so far so that we can continue the process with remainder.
            dividend -= value;
        }

        /* If there was originally one negative sign, then
         * the quotient remains negative. Otherwise, switch
         * it to positive. */
        if (negatives != 1) {
            return -substration;
        }
        return substration;
    }
}
