// 2022-06-02
// https://www.acmicpc.net/problem/24416

import java.util.*

class Solution {
    var answer1 = 0
    var answer2 = 0
    fun solution(n:Int){
        fib2(n)
        fib1(n)
        println("$answer1 $answer2")
    }

    fun fib1(n:Int){
        if(n == 1 || n==2) {
            answer1++
            return
        }
        else {
            fib1(n-1)
            fib1(n-2)
        }
    }

    fun fib2(n:Int){
        val f = IntArray(n+1)
        f[1]=1
        f[2]=1
        for(i in 3..n){
            f[i] = f[i-1]+f[i-2]
            answer2++
        }
    }
}

fun main() {
    Solution().solution( readLine()!!.toInt() )
}
