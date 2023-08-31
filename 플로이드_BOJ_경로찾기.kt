import java.lang.StringBuilder

// https://www.acmicpc.net/problem/11403
// 2023-08-31

fun main() {
    val s = Solution()
    s.solution(List(readln().toInt()) { readln().split(' ').map { it.toInt() } })
}

class Solution {
    fun solution(table: List<List<Int>>) {
        val d = List(table.size) { table[it].toMutableList() }

        for (node in d.indices) {
            for (i in d.indices) {
                for (j in d.indices) {
                    if (node == i || node == j) continue
                    if (d[i][j] == 1) continue
                    if (d[i][node] == 1 && d[node][j] == 1) d[i][j] = 1
                }
            }
        }

        d.forEach { list ->
            val sb = StringBuilder()
            list.forEach {
                sb.append(it)
                sb.append(' ')
            }
            println(sb)
        }
    }
}
