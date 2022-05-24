// 2022-05-25
// https://www.acmicpc.net/problem/2293

import java.util.*
import kotlin.math.abs

class Solution {
    lateinit var answerList :IntArray
    lateinit var gList:IntArray
    var K = 0
    fun solution(k:Int, list:IntArray) {
        gList = list
        K = k
        answerList = IntArray(k+1)
        answerList[0]=1
        for(i in list.indices){
            for(j in list[i]..k){
                answerList[j] += answerList[j-list[i]]
            }
        }
        println(answerList[k])
    }
}

fun main() {
    val (n,k) = readLine()!!.split(' ')
    Solution().solution(k.toInt(), IntArray(n.toInt()){ readLine()!!.toInt() })
}
