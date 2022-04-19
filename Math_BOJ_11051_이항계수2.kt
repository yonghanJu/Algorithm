// 2022-04-19
// https://www.acmicpc.net/problem/11051

import java.math.*
import java.util.*
import kotlin.math.*

class Solution{

    lateinit var list:Array<IntArray>

    fun solution(n:Int, r:Int):Int{
        list = Array(n+1){IntArray(r+1){-1}}
        return re(n,r)
    }

    fun re(n:Int, r:Int):Int{
        if(n==r || r==0)  return 1
        if(list[n][r]>0) return list[n][r]
        var a = list[n-1][r-1]
        var b = list[n-1][r]
        if(a==-1) a = re(n-1,r-1) % 10007
        if(b==-1) b =re(n-1,r) % 10007
        list[n-1][r-1] = a
        list[n-1][r] = b
        return (a+b) % 10007
    }
}

fun main() {
    val str = readLine()!!.split(' ')
    println(Solution().solution(str[0].toInt(), str[1].toInt()))
}
