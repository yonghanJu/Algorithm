import java.lang.StringBuilder

// https://www.acmicpc.net/problem/9252
// 2023-09-06

fun main() {
    val s = Solution()
    s.solution(readln(), readln())
}

class Solution {
    fun solution(str1: String, str2: String) {
        val dp = List(str1.length + 1) { IntArray(str2.length + 1) }
        val indexArr1 = IntArray(str1.length)

        for (i in 1..str1.lastIndex + 1) {
            for (j in 1..str2.lastIndex + 1) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1
                    indexArr1[i - 1] = dp[i][j]
                } else {
                    dp[i][j] = maxOf(dp[i][j - 1], dp[i - 1][j])
                }
            }
        }

        var length = dp.last().last()
        val answer = CharArray(length)
        println(length)

        var i = str1.length
        var j = str2.length
        while (i > 0 && j > 0) {
            if (str1[i - 1] == str2[j - 1]) {
                answer[--length] = str1[i - 1]
                i--
                j--
            } else if (dp[i][j - 1] < dp[i - 1][j]) {
                i--
            } else {
                j--
            }
        }
        val sb = StringBuilder()
        answer.forEach {
            sb.append(it)
        }
        print(sb)
    }
}
