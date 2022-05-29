// 2022-05-29
// https://www.acmicpc.net/problem/11055

import java.util.*

class Solution {
    var answer = 0
    lateinit var dp:IntArray
    fun solution(n:Int, arr:IntArray) {
        dp = arr.clone()
        answer = dp[0]

        for(i in arr.indices){
            var max = dp[i]
            for( j in 0 until i){
                if(arr[i] > arr[j]){
                    max = maxOf(max, dp[j]+arr[i])
                }
            }
            dp[i]=max
            answer = maxOf(answer, max)
        }
        print(answer)
    }
}

fun main() {
    val n = readLine()!!.toInt()
    Solution().solution( n, readLine()!!.split(' ').map{it.toInt()}.toIntArray() )
}
