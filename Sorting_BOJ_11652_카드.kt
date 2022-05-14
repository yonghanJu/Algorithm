// 2022-05-15
// https://www.acmicpc.net/problem/11652

import java.util.*

class Solution{
    fun solution(array:LongArray){
        val map = HashMap<Long,Int>()
        array.forEach {
            if(map[it]==null) map[it]=1
            else map[it] = map[it]!!+1
        }
        var answer = 0L
        var cnt = 0
        map.forEach{ (k, v) ->
            if( v > cnt || (v == cnt && k<answer)){
                answer = k
                cnt = v
            }
        }
        print(answer)
    }
}

fun main() {
    val n = readLine()!!.toInt()
    Solution().solution(LongArray(n){readLine()!!.toLong()})
}
