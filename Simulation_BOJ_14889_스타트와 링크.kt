// 2022-05-23
// https://www.acmicpc.net/problem/14889

import java.util.*
import kotlin.math.abs

class Solution {
    var answer = Int.MAX_VALUE
    var N = 0
    lateinit var isVisited:BooleanArray
    fun solution(table:Array<IntArray>) {
        N = table.size
        isVisited = BooleanArray(table.size)
        dfs(0,table)
        print(answer)
    }

    fun dfs(count:Int,table:Array<IntArray>){
        if(count == N){
            var aSum =0
            var bSum =0
            val aList = mutableListOf<Int>()
            val bList = mutableListOf<Int>()
            for(i in 0 until N){
                if(isVisited[i]) aList.add(i)
                else bList.add(i)
            }
            if(aList.size != bList.size) return

            for(i in 0 until N/2){
                for(j in i+1 until N/2){
                    aSum += table[aList[i]][aList[j]]
                    aSum += table[aList[j]][aList[i]]
                }
            }

            for(i in 0 until N/2){
                for(j in i+1 until N/2){
                    bSum += table[bList[i]][bList[j]]
                    bSum += table[bList[j]][bList[i]]
                }
            }
            answer = minOf(answer, Math.abs(aSum-bSum))
            return
        }

        for(i in count until N){
            isVisited[i]=true
            dfs(i+1, table)
            isVisited[i]=false
        }
    }
}

fun main() {
    val n = readLine()!!.toInt()
    Solution().solution(Array(n){ readLine()!!.split(' ').map{it.toInt()}.toIntArray() } )
}
