// 2022-02-18
// https://www.acmicpc.net/problem/14490

import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,m) = readLine().split(':').map{it.toInt()}
    val lcm = f(maxOf(n,m), minOf(n,m))
    print("${n/lcm}:${m/lcm}")
}

fun f(a:Int, b:Int):Int{
    return if(b == 0 ) a else f( maxOf(b,a%b),minOf(b,a%b))
}
