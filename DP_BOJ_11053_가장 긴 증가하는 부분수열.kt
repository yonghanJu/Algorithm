// 2022-06-07
// https://www.acmicpc.net/problem/11053

import java.util.*

class Solution {
    fun solution(arr:IntArray){
        val answer = IntArray(arr.size){1}
        for(i in 1..arr.lastIndex){
            for(j in 0 until i){
                if(arr[j] < arr[i]){
                    answer[i] = maxOf(answer[i], answer[j]+1)
                }
            }
        }
        println(answer.toList())
    }
}

fun main() {
    readLine()
    Solution().solution(readLine()!!.split(' ').map{it.toInt()}.toIntArray())
}
