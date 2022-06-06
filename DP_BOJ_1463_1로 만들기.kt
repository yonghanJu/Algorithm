// 2022-06-06
// https://www.acmicpc.net/problem/1463

import java.util.*

class Solution {
    fun solution(n:Int){
        val answer = IntArray(n+1){Int.MAX_VALUE}
        answer[1]=0
        for(i in 2 ..n){
            answer[i] = minOf(answer[i], answer[i-1]+1)
            if(i%2 ==0) answer[i] = minOf(answer[i], answer[i/2]+1)
            if(i%3 ==0) answer[i] = minOf(answer[i], answer[i/3]+1)
        }
        print(answer[n])
    }
}

fun main() {
    Solution().solution(readLine()!!.toInt())
}
