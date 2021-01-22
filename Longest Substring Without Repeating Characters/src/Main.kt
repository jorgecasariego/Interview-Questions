/**
 * Example:
 *  abca
 *     r
 *   l
 *
 *  set: a
 *  lenght: 3
 */
fun lengthOfLongestSubstring(s: String): Int {
    var maxLenght = 0
    val set = mutableSetOf<Char>()
    var left = 0
    var right = 0

    while(right < s.length) {
        if(!set.contains(s[right])) {
            set.add(s[right])
            right++

            maxLenght = Math.max(maxLenght, set.size)
        } else {
            set.remove(s[left])
            left++
        }
    }

    return maxLenght
}

/**
 * For this problem the most intuitive way is doing brute force
 */
fun main() {

    val length = lengthOfLongestSubstring("Hello")

    println("Max Length is $length")
}