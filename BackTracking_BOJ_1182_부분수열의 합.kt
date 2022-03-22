// 2022-03-22
// https://www.acmicpc.net/problem/1182

import java.io.*
import java.util.*

var n =0
var s =0
var answer =0

lateinit var list:List<Int>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N,S) = readLine().split(' ').map{it.toInt()}
    s = S
    list = readLine().split(' ').map{it.toInt()}
    n = list.size

    bt(0,0,false)
    bt(0,list[0],true)
    println(answer)
}

fun bt(idx:Int,sum:Int, isAdd:Boolean){
    if(idx == n) return
    if(isAdd && sum == s) answer++
    bt(idx+1, sum, false)
    if(idx+1<n)bt(idx+1, sum+list[idx+1], true)
}
