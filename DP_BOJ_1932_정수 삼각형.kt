// 2022-06-04
// https://www.acmicpc.net/problem/1932

import java.util.*

class Solution {
    fun solution(arr:Array<IntArray>){
        for(i in 1..arr.lastIndex){
            for(j in arr[i].indices){
                val a = if(j-1<0) 0 else arr[i-1][j-1]
                val b = if(j in arr[i-1].indices)arr[i-1][j] else 0
                arr[i][j] = maxOf(a+arr[i][j], b+arr[i][j])
            }
        }1
        println(arr.last().maxOrNull())
    }
}

fun main() {
    Solution().solution(Array(readLine()!!.toInt()){ readLine()!!.split(' ').map{it.toInt()}.toIntArray() })
}
