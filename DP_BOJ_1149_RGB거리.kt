// 2022-06-03
// https://www.acmicpc.net/problem/1149

import java.util.*

class Solution {
    fun solution(arr:Array<IntArray>){
        val answer = Array(arr.size){IntArray(3){Int.MAX_VALUE} }
        answer[0][0]=arr[0][0]
        answer[0][1]=arr[0][1]
        answer[0][2]=arr[0][2]

        for(i in 1..arr.lastIndex){
            for(j in 0..2){
                for(k in 0..2){
                    if(j==k) continue
                    answer[i][j] = minOf(answer[i-1][k]+arr[i][j], answer[i][j])
                }
            }
        }
        println(answer.last().minOrNull())
    }
}

fun main() {
    Solution().solution(Array(readLine()!!.toInt()){ readLine()!!.split(' ').map{it.toInt()}.toIntArray() })
}
