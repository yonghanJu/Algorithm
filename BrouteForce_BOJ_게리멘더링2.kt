// https://www.acmicpc.net/problem/17779
// 2023-10-11

val n = readln().toInt()
val table = List(n + 1) { if (it == 0) listOf() else listOf(0) + readln().split(' ').map { it.toInt() } }
fun main() {
    var answer = Int.MAX_VALUE
    val t = List(n) { IntArray(n) }
    for (d1 in 1..n) {
        for (d2 in 1..n) {
            for (x in 1..n) {
                for (y in 1..n) {
                    val rList = IntArray(5)
                    for (i in 1..n) {
                        for (j in 1..n) {
                            if (j > i - x + y && j > -i + x + y && j < i - x + y + 2 * d1 && j < -i + x + y + 2 * d2) {
                                if (x == 4 && y == 2 && d1 == 1 && d2 == 1) t[i - 1][j - 1] = 5
                                rList[0] += table[i][j]
                            } else if (i in 1 until x && j in 1..y + d1) {
                                if (x == 4 && y == 2 && d1 == 1 && d2 == 1) t[i - 1][j - 1] = 1
                                rList[1] += table[i][j]
                            } else if (i in 1..x - d1 + d2 && j in y + d1 + 1..n) {
                                if (x == 4 && y == 2 && d1 == 1 && d2 == 1) t[i - 1][j - 1] = 2
                                rList[2] += table[i][j]
                            } else if (i in x..n && j in 1 until y + d2) {
                                if (x == 4 && y == 2 && d1 == 1 && d2 == 1) t[i - 1][j - 1] = 3
                                rList[3] += table[i][j]
                            } else if (i in x - d1 + d2 + 1..n && j in y + d2..n) {
                                if (x == 4 && y == 2 && d1 == 1 && d2 == 1) t[i - 1][j - 1] = 4
                                rList[4] += table[i][j]
                            }
                        }
                    }
                    answer = minOf(answer, rList.sorted().let { it.last() - it.first() })
                }
            }
        }
    }
    println(answer)
}
