// https://www.acmicpc.net/problem/11049
// 2023-05-30

fun main() {
    val s = Solution()

    val list = List(readln().toInt()) { readln().split(' ').map { it.toInt() } }

    println(s.solution(list))
}

class Solution {
    val map = mutableMapOf<Pair<Int, Int>, Int?>()
    fun solution(list: List<List<Int>>): Int {
        for (i in 1..list.lastIndex) {
            map[Pair(i, i)] = 0
        }

        val dp = List(list.size) { IntArray(list.size) }
        for (size in 1..list.lastIndex) {
            for (index in 0..list.lastIndex - size) {
                var min = Int.MAX_VALUE
                for (i in index until index + size) {
                    min = minOf(
                        min,
                        dp[index][i] + dp[i + 1][index + size] + list[index][0] * list[i][1] * list[index + size][1],
                    )
                }
                dp[index][index + size] = min
            }
        }
        return dp[0][list.lastIndex]
    }
}
