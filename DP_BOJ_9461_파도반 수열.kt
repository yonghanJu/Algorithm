// 2022-06-02
// https://www.acmicpc.net/problem/DP_BOJ_9461_

import java.util.*

class Solution {
    val list = LongArray(101)
    init{
        list[1] = 1
        list[2] = 1
        list[3] = 1
        list[4] = 2
        list[5] = 2
        for(i in 6..100){
            list[i] = list[i-1] + list[i-5]
        }
    }
    fun solution(n:Int){
        println(list[n])
        return
    }
}

fun main() {
    repeat(readLine()!!.toInt()){
        val s = Solution()
        s.solution(readLine()!!.toInt())
    }
}
