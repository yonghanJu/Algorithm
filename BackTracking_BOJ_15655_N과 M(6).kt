// https://www.acmicpc.net/problem/15655

import java.io.*
import java.util.*

var n =0
var m =0
var answer =0

lateinit var list:List<Int>
lateinit var isVisited:BooleanArray

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N,M) = readLine().split(' ')
    n = N.toInt()
    m = M.toInt()
    list = readLine().split(' ').map{it.toInt()}.sorted()
    isVisited = BooleanArray(n)

    bt(0,0)
}

fun bt(size:Int,idx:Int){
    if(size == m) {
        for(i in isVisited.indices){
            if(isVisited[i]) print("${list[i]} ")
        }
        println()
        return
    }
    if(idx == n) return

    isVisited[idx] = true
    bt(size+1, idx+1)
    isVisited[idx] = false
    bt(size, idx+1)
}
