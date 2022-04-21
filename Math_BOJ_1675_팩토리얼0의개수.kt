// 2022-04-21
// https://www.acmicpc.net/problem/1675

import java.math.*
import java.util.*
import kotlin.math.*

class Solution{

    fun solution(n:Int):Int{
        var t = 0
        var f  =0
        for(i in 2 ..n){
            var cur = i
            while(cur%2==0){
                t++
                cur/=2
            }
            while(cur%5==0){
                f++
                cur/=5
            }
        }
        return minOf(t,f)
    }

}

fun main() {
    println(Solution().solution(readLine()!!.toInt()))
}
