// 2022-06-05
// https://www.acmicpc.net/problem/5525

import java.util.*

class Solution {
    fun solution(n:Int, input:String){
        var a = 0
        if(input.length < n*2+1) println(0).let{return}
        val answer = IntArray(input.length)
        if(input[0]=='I') answer[0]=1
        for(i in 1..answer.lastIndex){
            if(answer[i-1] != 0 && input[i-1] != input[i]) answer[i] = answer[i-1]+1
            else answer[i] = if(input[i]=='O') 0 else 1
            if(answer[i] >= 2*n+1 && answer[i]%2==1) a++
        }
        println(a)
    }
}

fun main() {
    val n = readLine()!!.toInt()
    readLine()!!.toInt()
    Solution().solution(n, readLine()!!)
}
