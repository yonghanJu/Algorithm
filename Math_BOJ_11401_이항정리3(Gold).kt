// 2022-06-22
// https://www.acmicpc.net/problem/11401

import java.lang.Math.pow
import java.util.*

class Solution {
    fun solution(nk:List<Int>){

        val top = fac(nk[0])
        val down = fac(nk[0]-nk[1]) * fac(nk[1]) %1000000007
        println(top * pow(down, 1000000005) % 1000000007)
    }

    // 분할 정복이 들어가는 부분
    // base^expo를 계산할 때
    // expo가 짝수일 때 > base^(expo/2) * base^(expo/2)
    // 홀수일 때 > base^(expo/2) * base^(expo/2) * base
    fun pow(base:Long, expo:Int):Long{
        if(expo == 1){
            return base%1000000007
        }
        val middle = pow(base, expo/2)
        return if(expo%2==0) middle * middle%1000000007 else (middle * middle%1000000007) * base %1000000007
    }

    fun fac(n:Int):Long{
        if(n==1 || n==0) return 1L
        var cnt = n
        var result = 1L
        while(cnt>1){
            result = result * cnt % 1000000007
            cnt--
        }
        return result
    }
}

fun main() {
    Solution().solution(readLine()!!.split(' ').map{it.toInt()})
}
