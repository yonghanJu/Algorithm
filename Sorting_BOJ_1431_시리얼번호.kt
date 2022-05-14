// 2022-05-15
// https://www.acmicpc.net/problem/1431

import java.util.*

class Solution{
    fun solution(array:Array<String>){
        val sb = StringBuilder()
        array.sortedWith( compareBy<String>{it.length}.thenBy{
            var cnt = 0
            it.forEach{ c-> if(c in '0'..'9') cnt += c-'0'}
            cnt
        }.thenBy{it}).forEach {sb.append(it).append('\n')}.let{ print(sb) }
    }
}

fun main() {
    val n = readLine()!!.toInt()
    Solution().solution(Array(n){readLine()!!})
}
