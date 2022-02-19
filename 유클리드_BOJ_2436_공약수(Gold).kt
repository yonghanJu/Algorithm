// 2022-02-18
// https://www.acmicpc.net/problem/2436

import java.io.*
import kotlin.math.sqrt

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (gcd, lcm) = readLine().split(' ').map{it.toInt()}
    val target = lcm/gcd
    for(i in sqrt(target.toFloat()).toInt() downTo 1){
        if(target%i==0 && gcd(maxOf(i,target/i), minOf(i,target/i))==1) print( "${minOf(i,target/i)*gcd} ${maxOf(i,target/i)*gcd}").let { return }
    }
}

fun gcd(a:Int, b:Int):Int{
    return if(b == 0) a else gcd(b,a%b)
}
