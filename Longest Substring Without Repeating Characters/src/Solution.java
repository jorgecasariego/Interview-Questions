import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int length = lengthOfLongestSubstring("Hello");
        System.out.println("legth: " + length);
    }

    private static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        Set<Character> letters = new HashSet<>();

        while (right < s.length()) {
            if (!letters.contains(s.charAt(right))) {
                letters.add(s.charAt(right));
                right++;
                maxLength = Math.max(maxLength, letters.size());
            } else {
                letters.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }
}
