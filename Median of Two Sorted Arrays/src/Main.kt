/**
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

Follow up: The overall run time complexity should be O(log (m+n)).

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Example 3:

Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000
Example 4:

Input: nums1 = [], nums2 = [1]
Output: 1.00000
Example 5:

Input: nums1 = [2], nums2 = []
Output: 2.00000


Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
 */
fun main() {
    val numbs1: IntArray = intArrayOf()
    val numbs2: IntArray = intArrayOf(2, 3)

    println("Result is ${findMedianSortedArrays(numbs1, numbs2)}")
}

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    var i = 0
    var j = 0

    val lengthNum1 = nums1.size
    val lengthNum2 = nums2.size

    val num3: ArrayList<Int> = arrayListOf()

    while(lengthNum1 > 0 && i < lengthNum1 && lengthNum2 > 0 && j < lengthNum2) {
        if (nums1[i] <= nums2[j]) {
            num3.add(nums1[i])
            i++
        } else {
            num3.add(nums2[j])
            j++
        }
    }

    if (i == lengthNum1) {
        while(j < lengthNum2) {
            num3.add(nums2[j])
            j++
        }
    } else {
        while(i < lengthNum1) {
            num3.add(nums1[i])
            i++
        }
    }

    return if (num3.size % 2 != 0 || num3.size == 1)
        num3[num3.size / 2].toDouble()
    else
        (num3[(num3.size / 2) - 1].toDouble() + num3[num3.size / 2].toDouble())/2

}