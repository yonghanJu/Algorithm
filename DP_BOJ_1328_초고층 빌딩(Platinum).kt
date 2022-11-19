// 2022-11-19
// https://www.acmicpc.net/problem/1328

class Solution {
    fun solution(input: List<Int>) {
        val (n, l, r) = input

        // dp[개수][왼쪽 본 개수][오른쪽 본 개수], 높은 건물 순으로 박음
        val dp = List(n + 1) { List(n + 1) { LongArray(n + 1) } }

        dp[1][1][1] = 1
        for (i in 1..n) {
            dp[n][n][1] = 1
            dp[n][1][n] = 1
        }

        for (i in 2..n) {
            for (l in 1..n) {
                for (r in 1..n) {
                    dp[i][l][r] = (dp[i - 1][l - 1][r] % 1000000007 + dp[i - 1][l][r - 1] % 1000000007 + (i - 2) * dp[i - 1][l][r] % 1000000007)  % 1000000007
                }
            }
        }

        // c % mod = (a%mod + b%mod) % mod

        println(dp[n][l][r] % 1000000007)
    }
}

fun main() {
    Solution().solution(readLine()!!.split(" ").map { it.toInt() })
}
