// 2022-02-18
// https://www.acmicpc.net/problem/9613

import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    repeat(n){
        var answer =0L
        val tmp = readLine().split(' ').map{it.toInt()}
        for(i in 1 until tmp[0]){
            for(j in i+1..tmp[0]){
                answer += lcm(maxOf(tmp[i],tmp[j]), minOf(tmp[i],tmp[j]))
            }
        }
        println(answer)
    }
}

fun lcm(a:Int, b:Int):Int{
    return if(b == 0) a else lcm( maxOf(b,a%b),minOf(b,a%b))
}
