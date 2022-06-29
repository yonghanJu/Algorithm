// 2022-06-29
// https://programmers.co.kr/learn/courses/30/lessons/12914 (멀리 뛰기)

class Solution {
    fun solution(n: Int): Long {
        if(n==1) return 1L // 배열 선언시 인덱스 조심!!!
        val dp = Array(n+1){LongArray(2)}
        dp[1][1]=1L
        dp[2][1]=1L
        dp[2][0]=1L
        for(i in 3..n){
            dp[i][1] = (dp[i-1][1] + dp[i-1][0])%1234567L
            dp[i][0] = (dp[i-2][1] + dp[i-2][0])%1234567L
        }
        return (dp[n][1] + dp[n][0])%1234567L
    }
}
