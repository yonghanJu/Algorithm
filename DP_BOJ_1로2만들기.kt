import java.lang.StringBuilder

// https://www.acmicpc.net/problem/12852
// 2023-09-03

fun main() {
    val s = Solution()
    s.solution(readln().toInt())
}

class Solution {
    fun solution(n: Int) {
        val dp = MutableList(n + 1) { Pair(Int.MAX_VALUE, 0) } // depth, prev
        dp[1] = Pair(0, -1)
        for (i in 1..n) {
            if (dp[i].second == 0) continue
            if (i * 3 <= n && dp[i * 3].first > dp[i].first + 1) dp[i * 3] = Pair(dp[i].first + 1, i)
            if (i * 2 <= n && dp[i * 2].first > dp[i].first + 1) dp[i * 2] = Pair(dp[i].first + 1, i)
            if (i + 1 <= n && dp[i + 1].first > dp[i].first + 1) dp[i + 1] = Pair(dp[i].first + 1, i)
        }

        val sb = StringBuilder("${dp.last().first}\n")
        var index = n
        while (index != -1) {
            sb.append("$index ")
            index = dp[index].second
        }
        println(sb)
    }
}
