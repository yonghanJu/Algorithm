// 2022-02-18
// https://www.acmicpc.net/problem/2609

import java.io.*
import java.util.*

var a = 0
var b = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val tmp = readLine().split(' ')
    a = tmp[0].toInt()
    b = tmp[1].toInt()
    println(f(maxOf(a,b), minOf(a,b)))
    println(f2(a,b))

}

fun f(a:Int, b:Int):Int{
    return if(b == 0 ) a else f( maxOf(b,a%b),minOf(b,a%b))
}

fun f2(curA:Int, curB:Int):Int{
    return if(curA==curB) curB else if(curA>curB) f2(curA,curB+b) else f2(curA+a,curB)
}
