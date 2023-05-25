// https://www.acmicpc.net/problem/2015
// 2023-05-26

fun main() {
    val s = Solution()

    val (n, m) = readln().split(' ').map { it.toInt() }
    val mList = readln().split(' ').map { it.toInt() }
    val cList = readln().split(' ').map { it.toInt() }

    println(s.solution(m, mList, cList))
}

class Solution {
    fun solution(m: Int, mList: List<Int>, cList: List<Int>): Int {
        var answer = 0

        val dp = IntArray(10001)

        for (j in mList.indices) {
            for (i in 10000 downTo 0) {
                if (i - cList[j] >= 0 && dp[i - cList[j]] > 0 && dp[i] < dp[i - cList[j]] + mList[j]) {
                    dp[i] = dp[i - cList[j]] + mList[j]
                }
                if (i == cList[j] && dp[i] < mList[j]) {
                    dp[i] = mList[j]
                }
            }
        }

        outer@ for (i in 0..10000) {
            if (dp[i] >= m) {
                answer = i
                break@outer
            }
        }

        return answer
    }
}
