// 2022-04-21
// https://www.acmicpc.net/problem/1675

import java.math.*
import java.util.*
import kotlin.math.*

class Solution{

    fun solution(n:Int):Int{
        var num = BigInteger("1")
        for(i in 1..n) num *= BigInteger(i.toString())
        var answer = 0
        while(num%BigInteger.TEN==BigInteger.ZERO){
            num /= BigInteger.TEN
            answer ++
        }
        return answer
    }

}

fun main() {
    println(Solution().solution(readLine()!!.toInt()))
}
