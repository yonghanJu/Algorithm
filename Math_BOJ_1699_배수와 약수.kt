// 2022-04-16
// https://www.acmicpc.net/problem/1699

import java.io.*
import java.util.*
import kotlin.math.*

class Solution{
    fun solution(a:Int, b:Int):String{
        return if(a>b && a%b==0) "multiple" else if(a<=b && b%a==0) "factor" else "neither"
    }
}

fun main():Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    var str= readLine().split(' ')
    while(str[0] != "0" || str[1]!= "0"){
        println(Solution().solution( str[0].toInt(), str[1].toInt() ))
        str = readLine().split(' ')
    }
}
