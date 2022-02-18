// 2022-02-18
// https://www.acmicpc.net/problem/1735

import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n1, m1) = readLine().split(' ').map{it.toInt()}
    val (n2, m2) = readLine().split(' ').map{it.toInt()}
    val lcm = gcd(maxOf(m1,m2), minOf(m1,m2))
    val n = n1*m2/lcm + n2*m1/lcm
    val m = m1*m2/lcm
    val gcd = gcd(maxOf(n,m), minOf(n,m))
    println("${n/gcd} ${m/gcd}")
}

fun gcd(a:Int, b:Int):Int{
    return if(b == 0) a else gcd( maxOf(b,a%b),minOf(b,a%b))
}
