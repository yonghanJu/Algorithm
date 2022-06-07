// 2022-06-07
// https://www.acmicpc.net/problem/10844

import java.util.*

class Solution {
    fun solution(n:Int){
        val answer = Array(n+1){IntArray(10)}
        answer[1].fill(1)
        answer[1][0]=0
        for(i in 2..n){
            answer[i][0] = answer[i-1][1]
            answer[i][9] = answer[i-1][8]
            for(j in 1..8){
                answer[i][j] = (answer[i-1][j-1]+answer[i-1][j+1])% 1000000000
            }
        }
        println(answer.last().run{
            var sum =0
            this.forEach{
                sum+=it
                sum%=1000000000
            }
            sum
        })
    }
}

fun main() {
    Solution().solution(readLine()!!.toInt())
}
