// 2022-06-02
// https://www.acmicpc.net/problem/1904

import java.util.*

class Solution {
    fun solution(n:Int){
        val tile = IntArray(n+1)
        if(n == 1){
            println(1)
            return
        }
        tile[1] = 1
        tile[2] = 2
        for(i in 3..n){
            tile[i] = (tile[i-1] + tile[i-2])%15746
        }
        println(tile[n])
    }
}

fun main() {
    Solution().solution(readLine()!!.toInt())
}
