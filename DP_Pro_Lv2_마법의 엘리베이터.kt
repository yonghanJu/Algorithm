import kotlin.math.*

class Solution {
    fun solution(storey: Int): Int {
        var answer: Int = 0
        
        val dp = List(storey.toString().length) { IntArray(2) }
        dp[0][0] = storey % 10
        dp[0][1] = 10 - storey % 10 // [1] 을 선택하면 0 출발 or 9출발 하겠다 이거임
        var s = storey / 10
        
        for(i in 1..dp.lastIndex) {
            dp[i][0] = minOf(dp[i-1][0] + s % 10, dp[i-1][1] + s % 10 + 1)
            
            dp[i][1] = minOf(dp[i-1][0] + 10 - s % 10, dp[i-1][1] + 9 - s % 10)
            s /= 10
        }
        
        return minOf(dp.last()[0], dp.last()[1] + 1)
    }
}
