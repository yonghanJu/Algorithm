// 2022-05-28
// https://www.acmicpc.net/problem/1302

import java.util.*

class Solution {
    fun solution(arr:Array<String>) {
        val map = HashMap<String,Int>()
        arr.forEach {
            if(map[it]==null) {
                map[it] = 1
            }else{
                map[it] = map[it]!!+1
            }
        }
        print(map.entries.sortedWith(compareBy<Map.Entry<String,Int>>{-it.value}.thenBy{it.key})[0].key)
    }
}

fun main() {
    val n = readLine()!!.toInt()
    Solution().solution(Array(n){readLine()!!})
}
