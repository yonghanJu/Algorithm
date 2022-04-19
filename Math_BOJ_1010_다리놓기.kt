// 2022-04-19
// https://www.acmicpc.net/problem/1010

import java.math.*
import java.util.*
import kotlin.math.*

class Solution{

    lateinit var list:Array<IntArray>

    fun solution(n:Int, r:Int):Int{
        var answer =0
        list = Array(n+1){IntArray(r+1){-1}}
        return re(n,r)
    }

    // 4C3 = 3C2 + 3C3
    fun re(n:Int, r:Int):Int{
        if(n==r || r==0)  return 1
        if(list[n][r]>0) return list[n][r]
        var a = list[n-1][r-1]
        var b = list[n-1][r]
        if(a==-1) a = re(n-1,r-1)
        if(b==-1) b =re(n-1,r)
        list[n-1][r-1] = a
        list[n-1][r] = b
        return a+b
    }
}

fun main() {
    val n = readLine()!!.toInt()
    repeat(n){
        val str = readLine()!!.split(' ')
        println(Solution().solution(str[1].toInt(), str[0].toInt()))
    }
}
