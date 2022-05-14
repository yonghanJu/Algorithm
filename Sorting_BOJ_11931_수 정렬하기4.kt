// 2022-05-15
// https://www.acmicpc.net/problem/11931

import java.util.*

class Solution{
    fun solution(array:IntArray){
        val sb = StringBuilder()
        array.sortedBy{-it}.forEach { sb.append(it).append('\n') }
        print(sb)
    }
}

fun main() {
    val n = readLine()!!.toInt()
    val array = IntArray(n){ readLine()!!.toInt()}
    Solution().solution(array)
}
