// 2022-02-18
// https://www.acmicpc.net/problem/5347

import java.io.*
import java.util.*

var a = 0
var b = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    repeat(n){
        val tmp = readLine().split(' ')
        a = maxOf(tmp[0].toInt(), tmp[1].toInt())
        b = minOf(tmp[0].toInt(), tmp[1].toInt())
        val l = f(a,b)
        println(a.toLong()*b/l)
    }
}

fun f(a:Int, b:Int):Int{
    return if(b == 0 ) a else f( maxOf(b,a%b),minOf(b,a%b))
}
