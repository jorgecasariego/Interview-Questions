/**
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
 * The order of the alphabet is some permutation of lowercase letters.
 * <p>
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if
 * the given words are sorted lexicographicaly in this alien language.
 */
public class AlienDictionary {
    public static void main(String[] args) {
        String[] words = {"apple", "app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        boolean result = solution(words, order);
        System.out.println("Result: " + result);

        String[] words2 = {"hello","leetcode"};
        order = "hlabcdefgijkmnopqrstuvwxyz";
        result = solution(words2, order);
        System.out.println("Result: " + result);
    }

    static boolean solution(String[] words, String order) {
        int[] alphabet = new int[26];

        // With this we have the new index of every letter in the alien alphabet
        for (int i = 0; i < order.length(); i++) {
            alphabet[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int min = Math.min(word1.length(), word2.length());

            for (int j = 0; j < min; j++) {
                char char1 = word1.charAt(j);
                char char2 = word2.charAt(j);

                int i1 = alphabet[char1 - 'a'];
                int i2 = alphabet[char2 - 'a'];

                // abd vs abc
                if (alphabet[char1 - 'a'] > alphabet[char2 - 'a']) {
                    return false;
                } else if (alphabet[char1 - 'a'] < alphabet[char2 - 'a']) {
                    break;
                } else if (j == min - 1 && word1.length() > word2.length()) {
                    // If we didn't find a first difference, the
                    // words are like ("app", "apple").
                    return false;
                }

            }


        }

        return true;
    }

}
