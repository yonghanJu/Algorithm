// 2022-02-18
// https://www.acmicpc.net/problem/1850

import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n1, n2) = readLine().split(' ').map{it.toLong()}
    val repeat = gcd(maxOf(n1,n2),minOf(n1,n2))
    val sb = StringBuilder()
    for( i in 0 until repeat) sb.append(1)
    print(sb)
}

fun gcd(a:Long, b:Long):Long{
    return if(b == 0L) a else gcd( maxOf(b,a%b),minOf(b,a%b))
}
