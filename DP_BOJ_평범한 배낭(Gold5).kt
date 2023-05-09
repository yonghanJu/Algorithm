// https://www.acmicpc.net/problem/12865
// 2023-05-09

fun main() {
    val s = Solution()
    println(s.solution())
}

class Solution {
    fun solution(): Int {
        val (n, k) = readln().split(' ').map { it.toInt() }
        val list = List(n + 1) { if (it == 0) listOf(0) else readln().split(' ').map { it.toInt() } }.sortedBy { it[0] }
        val dp = List(n + 1) { IntArray(k + 1) } // dp[물건수][무게] = 최대가치(무조건 최대무게가 최대 가치는 아님)

        for (i in 1..n) { // 물건 수
            for (j in 1..k) { // 무게
                if (j - list[i][0] >= 0) {
                    dp[i][j] = maxOf(dp[i - 1][j - list[i][0]] + list[i][1], dp[i - 1][j])
                } else {
                    dp[i][j] = dp[i - 1][j]
                }
            }
        }

        return dp[n][k]
    }
}
