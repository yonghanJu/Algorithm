// 2022-06-07
// https://www.acmicpc.net/problem/2156

import java.util.*

class Solution {
    fun solution(arr:IntArray){
        val answer = Array(arr.size){IntArray(3)}
        answer[0][0] = 0
        answer[0][1] = arr[0]
        answer[0][2] = 0
        for(i in 1..arr.lastIndex){
            answer[i][0] = maxOf(answer[i-1][0],answer[i-1][1],answer[i-1][2])
            answer[i][1] = answer[i-1][0]+arr[i]
            answer[i][2] = answer[i-1][1]+arr[i]
        }

        println(answer.last().maxOrNull())
    }
}

fun main() {
    Solution().solution(Array(readLine()!!.toInt()){readLine()!!.toInt()}.toIntArray())
}
