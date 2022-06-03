// 2022-06-03
// https://www.acmicpc.net/problem/1912

import java.util.*

class Solution {
    fun solution(arr:IntArray){
        for(i in 1 .. arr.lastIndex){
            arr[i] = maxOf(arr[i], arr[i-1]+arr[i])
        }
        println(arr.maxOrNull())
    }
}

fun main() {
    readLine()!!
    Solution().solution(readLine()!!.split(' ').map{it.toInt()}.toIntArray())
}
