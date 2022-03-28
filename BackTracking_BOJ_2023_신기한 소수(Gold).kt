// 2022-03-28
// https://www.acmicpc.net/problem/2023

import java.io.*
import java.util.*
import kotlin.math.pow

var n  =0
var last = 0
var start =0
val sb = StringBuilder()
fun main():Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()

    dfs(0,0)

    println(sb)
}

fun dfs(size:Int, num:Int){
    if(size == n){
        sb.append(num).append('\n')
    }

    for(i in 1..9 ){
        if(isPrime(num*10+i)) dfs(size+1, num*10+i)
    }
}

fun isPrime(num:Int):Boolean{
    if(num == 1) return false
    for(i in 2 until num){
        if(num%i==0) return false
    }
    return true
}
