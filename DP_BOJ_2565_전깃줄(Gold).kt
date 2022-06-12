// 2022-06-12
// https://www.acmicpc.net/problem/2565

import java.util.*

class Solution {
    fun solution(arr:List<IntArray>){
        val answer = IntArray(arr.size){1}

        for(i in 1 .. arr.lastIndex){
            for(j in 0 until i){
                if(arr[i][1] > arr[j][1]){
                    answer[i]= maxOf(answer[i], answer[j]+1)
                }
            }
        }

        println(arr.size-answer.maxOrNull()!!)
    }
}

fun main() {
    val n = readLine()!!.toInt()
    Solution().solution(Array(n){readLine()!!.split(' ').map{it.toInt()}.toIntArray()}.sortedBy { it[0] })
}
