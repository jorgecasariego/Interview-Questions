import com.sun.xml.internal.fastinfoset.util.StringArray
import java.lang.StringBuilder

/*
    0               4               8               12
    P(0)            A(1)            H(2)            N(3)

    1       3       5       7       9       11      13
    A(4)   P(5)     L(6)   S(7)     I(8)   I(9)     G(10)

    2               6               10
    Y(11)           I(12)           R(13)

    newIndex = oldIndex * numRows + numRows
*/
fun convert(s: String, numRows: Int): String {
    var downAndUp = true
    var count = 0
    val arrays = Array(numRows){ StringBuilder() }
    val result = StringBuilder()

    if (numRows == 1 || numRows > s.length) {
        return s
    }

    s.forEach { letter ->
        arrays[count].append(letter)

        if (downAndUp) count++
        else count--

        if (count == 0 || count == numRows - 1) {
            downAndUp = !downAndUp
        }
    }

    arrays.forEach {
        result.append(it.toString())
    }

    return result.toString()
}

fun main() {
    val s = "PAYPALISHIRING"
    println("$s : ${convert(s, 3)}")
}
