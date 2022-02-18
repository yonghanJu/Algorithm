// 2022-02-18
// https://www.acmicpc.net/problem/13241

import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n1, n2) = readLine().split(' ').map{it.toInt()}
    val gcd = gcd(maxOf(n1,n2), minOf(n1,n2))
    print("${n1.toLong()*n2/gcd}")
}

fun gcd(a:Int, b:Int):Int{
    return if(b == 0) a else gcd( maxOf(b,a%b),minOf(b,a%b))
}
