import java.util.*;

public class LetterSolution {

    static Map<String, String> phone = new HashMap<String, String>(){{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<String> result = (ArrayList<String>) letterCombinations("23");

        System.out.println("Combinations: " + result.toString());

    }

    /**
     * digits: 23
     *                          2
     *           /              |               \
     *           a              b               c
     *           3              3               3
     *        /  |   \      /   |   \       /   |   \
     *      ad  ae   af     ad ae   af      ad  ae   af
     */
    public static List<String> letterCombinations(String digits) {
        if (digits.length() > 0) {
            backtrack("", digits);
        }
        
        return result;
    }

    /**
     * Test: ab
     * 1) combination: "" - digits: "23"
     * 2) combination: "a" - digits: "3"
     * 2) combination: "ad" - digits: ""
     * @return
     */
    public static void backtrack(String combination, String digits) {
        if (digits.length() == 0) {
            result.add(combination);
        } else {
            // 1) digit = 2
            // 2) digit = 3
            String digit = digits.substring(0,1);

            // 1) letters = "def"
            String letters = phone.get(digit);

            for (int i = 0; i < letters.length(); i++) {
                // 1) i = 0 - backtrack(""+a, 3)
                // 1) i = 1 - backtrack(""+b, 3)
                // 1) i = 2 - backtrack(""+c, 3)

                // 2) i = 0 - backtrack("a"+d, 3)
                // 2) i = 1 - backtrack("a"+e, 3)
                // 2) i = 2 - backtrack("a"+f, 3)
                backtrack(combination + letters.charAt(i), digits.substring(1));
            }
        }
    }
}
