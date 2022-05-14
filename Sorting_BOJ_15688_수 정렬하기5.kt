// 2022-05-15
// https://www.acmicpc.net/problem/15688

import java.util.*

class Solution{
    fun solution(n:Int){
        val sb = StringBuilder()
        val arr = IntArray(2000001)
        for(i in 1..n){
            arr[readLine()!!.toInt()+1000000]++
        }
        arr.forEachIndexed { idx,it->
            for(i in 0 until it){ sb.append(idx-1000000).append('\n')}
        }
        print(sb)
    }
}

fun main() {
    val n = readLine()!!.toInt()
    Solution().solution(n)
}
