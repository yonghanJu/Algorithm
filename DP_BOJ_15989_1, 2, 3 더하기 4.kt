// 2022-11-08
// https://www.acmicpc.net/problem/15989

class Solution {
    fun solution(number: Int){
        if(number == 1) {
            println(1)
            return
        }
        if(number == 2) {
            println(2)
            return
        }
        if(number==3) {
            println(3)
            return
        }
        val dp = Array(4){IntArray(number + 1)}

        dp[1][1] = 1
        dp[1][2] = 1
        dp[2][2] = 1
        dp[3][3] = 1
        dp[1][3] = 1
        dp[2][3] = 1

        for(i in 4 .. number) {
            dp[1][i] = dp[1][i-1]
            dp[2][i] = dp[1][i-2] + dp[2][i-2]
            dp[3][i] = dp[1][i-3] + dp[2][i-3] + dp[3][i-3]
        }
        println(dp[2][number] + dp[3][number] + dp[1][number])
    }
}

fun main() {
    repeat(readLine()!!.toInt()) {
        Solution().solution(readLine()!!.toInt())
    }
}
