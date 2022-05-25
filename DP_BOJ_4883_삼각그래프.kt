// 2022-05-25
// https://www.acmicpc.net/problem/4883

import java.util.*

class Solution {
    val dx = intArrayOf(1,1,1,0)
    val dy = intArrayOf(-1,0,1,1)
    fun solution(n:Int, table:Array<IntArray>):Int {
        val answerTable = Array(n){IntArray(3){Int.MAX_VALUE} }
        answerTable[0][1]=table[0][1]
        for(i in table.indices){
            for(j in 0..2){
                for(d in 0..3){
                    val nx = i+dx[d]
                    val ny = j + dy[d]
                    if((nx in table.indices && ny in 0..2).not()) continue
                    if(i==0 && j==0) continue
                    answerTable[nx][ny] = minOf(table[nx][ny]+answerTable[i][j], answerTable[nx][ny])
                }
            }
        }
        return answerTable.last()[1]
    }
}

fun main() {

    var n = readLine()!!.toInt()
    var c = 1
    while(n!=0){
        print("$c. ")
        println( Solution().solution(n,Array(n){ readLine()!!.split(' ').map{it.toInt()}.toIntArray() }))
        n = readLine()!!.toInt()
        c++
    }
}
