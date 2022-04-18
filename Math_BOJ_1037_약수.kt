// 2022-04-18
// https://www.acmicpc.net/problem/1037

import java.io.*
import java.util.*
import kotlin.math.*

class Solution{
    fun solution(n:Int, list:IntArray) = if(n%2==1) list[n/2]*list[n/2] else list[n/2-1]*list[n/2]
}

fun main():Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    println(Solution().solution(readLine().toInt(), readLine().split(' ').map{it.toInt()}.sorted().toIntArray()))
}
