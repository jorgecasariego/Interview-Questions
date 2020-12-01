/**
* Write a function to find the longest common prefix string amongst an array of strings.
*
* If there is no common prefix, return an empty string "".
*
* Example 1:
*
* Input: ["flower","flow","flight"]
* Output: "fl"
* Example 2:
*
* Input: ["dog","racecar","car"]
* Output: ""
* Explanation: There is no common prefix among the input strings.
* Note:
*
* All given inputs are in lowercase letters a-z.
*/
fun main() {
    val output1 = longestCommonPrefix(listOf<String>("flower","flow","flight").toTypedArray())
    val output2 = longestCommonPrefix(listOf<String>("aa","a").toTypedArray())

    println(output1)
    println(output2)
}

fun longestCommonPrefix(strs: Array<String>): String {
    var output = ""

    if (strs.isEmpty()) {
        return output
    }

    val firstWord = strs[0].toCharArray()

    // "flower" | "flow","flight"
    firstWord.forEachIndexed { index, letter ->
        // "flow","flight"
        for (wordIndex in 1 until strs.size) {
            if (index >= strs[wordIndex].length)
                return output

            if (strs[wordIndex][index] != letter)
                return output
        }

        output += letter
    }

    return output
}