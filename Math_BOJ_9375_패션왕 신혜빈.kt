// 2022-04-20
// https://www.acmicpc.net/problem/9375

import java.math.*
import java.util.*
import kotlin.math.*

class Solution{

    var answer =0

    fun solution(n:Int, list:List<Int>):Int{
        answer =1
        if(list.size==1) return list[0]
        list.forEach { answer *= it+1 }
        return answer-1
    }
}

fun main() {
    val t =readLine()!!.toInt()
    repeat(t){
        val n = readLine()!!.toInt()
        val map = HashMap<String,Int>()
        repeat(n){
            val str= readLine()!!.split(' ')
            map[str[1]] = map.getOrDefault(str[1],0) + 1
        }
        println(Solution().solution(n, map.values.toList()))
    }
}
