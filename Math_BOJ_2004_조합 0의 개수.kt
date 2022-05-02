// 2022-05-03
// https://www.acmicpc.net/problem/2004

class Solution{
    fun solution(n:Int, M:Int):Int{
        var m = if(M*2>n) M else n-M
        return minOf(fac(n,2)-fac(n-m,2)-fac(m,2),fac(n,5)-fac(n-m,5)- fac(m,5))
    }

    fun fac(factorial:Int, divider:Int):Int{
        var n = factorial
        var value = 0
        while( n > 0){
            n/=divider
            value+=n
        }
        return value
    }
}

fun main() {
    val str = readLine()!!.split(' ')
    println(Solution().solution(str[0].toInt(), str[1].toInt()))
}
