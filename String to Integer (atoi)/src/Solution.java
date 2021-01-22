/**
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is
 * found. Then, starting from this character takes an optional initial plus or minus sign followed by as many numerical
 * digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, which are ignored and have no
 * effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence
 * exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 *
 * Only the space character ' ' is considered a whitespace character.
 * Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range:
 * [−231,  231 − 1]. If the numerical value is out of the range of representable values, 231 − 1 or −231 is returned.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println("Result 1: " + myAtoi("245"));
        System.out.println("Result 1: " + Integer.MIN_VALUE);
        System.out.println("Result 2: " + myAtoi("    245"));
        System.out.println("Result 3: " + myAtoi("    245 dsadsa"));
        System.out.println("Result 4: " + myAtoi("    245 321321"));
        System.out.println("Result 5: " + myAtoi("a312321"));
        System.out.println("Result 6: " + myAtoi("     "));
        System.out.println("Result 6: " + myAtoi("     -43"));
        System.out.println("Result 7: " + myAtoi("-431"));
        System.out.println("Result 8: " + myAtoi("+431"));
        System.out.println("Result 9: " + myAtoi("-91283472332"));
        System.out.println("Result 9: " + myAtoi("-2147483647"));


    }

    public static int myAtoi(String str) {
        // 1. I need to check first if the string is null or is empty
        if (str == null || str.isEmpty()) {
            return 0;
        }

        // 2. There I need to discards as many whitespace characters as necessary
        int i = 0;
        int sign = 1;
        int length = str.length();

        while (i < length && str.charAt(i) == ' ') {
            i++;
        }

        if (i >= length) {
            return 0;
        }

        // 3. Then I need to check the sign of the number (if exists)
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            sign = str.charAt(i++) == '+' ? 1 : -1;
        }

        // 4. Using Horner's rule I can generate the Integer
        long result = 0;
        while (i < length && Character.isDigit(str.charAt(i))) {
            result = result * 10 + (str.charAt(i++) - '0');
            /**
             * Example: 325
             *  res = 0
             *  res = 3
             *  res = 30 + 2 = 32
             *  res = 320 + 5
             */
            // 5. The result could be greater than MAX_INT or smaller than MIN_INT so I need to store the result in a Long
            // value
            // 6. If the value is greater than MAX_INT or MIN_INT I return MAX or MIN
            if (result > Integer.MAX_VALUE || (result * sign) < Integer.MIN_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }

        // 7. Else, I return the value as a Integer
        return (int)(result * sign);

    }
}
