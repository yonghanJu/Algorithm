// 2022-04-19
// https://www.acmicpc.net/problem/1010

import java.math.*
import java.util.*
import kotlin.math.*

class Solution{
    fun solution(n:Int, r:Int):Int{
        var cur = BigInteger("1")
        for(i in 0 until  r){
            cur *= BigInteger((n-i).toString())
        }
        for(i in 1 .. r){
            cur /= BigInteger(i.toString())
        }
        return cur.toInt()
    }
}

fun main() {
    val n = readLine()!!.toInt()
    repeat(n){
        val str = readLine()!!.split(' ')
        println(Solution().solution(str[1].toInt(), str[0].toInt()))
    }
}
