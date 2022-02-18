// 2022-02-18
// https://www.acmicpc.net/problem/17087

import java.io.*
import java.lang.Math.abs

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, s) = readLine().split(' ').map{it.toInt()}
    val an = readLine().split(' ').map{it.toInt()}
    if(n==1) print(kotlin.math.abs(s-an[0])).let{return}
    var gcd = gcd(maxOf( kotlin.math.abs(an[0]-s), kotlin.math.abs(an[1] - s)), minOf( kotlin.math.abs(an[0]-s), kotlin.math.abs(an[1] - s)))
    for(i in 1 until an.lastIndex) gcd = minOf(gcd,
        gcd(maxOf( kotlin.math.abs(an[i]-s), kotlin.math.abs(an[i+1] - s)), minOf( kotlin.math.abs(an[i]-s), kotlin.math.abs(an[i+1] - s)))
        )
    print(gcd)
}

fun gcd(a:Int, b:Int):Int{
    return if(b == 0) a else gcd( maxOf(b,a%b),minOf(b,a%b))
}
