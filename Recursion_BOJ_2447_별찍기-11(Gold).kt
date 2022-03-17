// 2022-03-17
// https://www.acmicpc.net/problem/2447

import java.io.*
import java.math.BigInteger

var n =0
lateinit var graph:Array<CharArray>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()
    n = readLine().toInt()
    graph = Array(n){CharArray(it*2+1){' '} }
    re(0,0,n)
    for(i in 0 until n){
        for(j in 0..n-i-2) sb.append(' ')
        sb.append(graph[i])
        for(j in 0..n-i) sb.append(' ')
        sb.append('\n')
    }
    println(sb)
}

fun re(x:Int, y:Int, size:Int){
    if(size == 3){
        graph[x][y] = '*'
        graph[x+1][y] = '*'
        graph[x+1][y+2] = '*'
        for(i in 0..4 )graph[x+2][y+i] = '*'
        return
    }
    re(x,y,size/2)
    re(x+size/2,y,size/2)
    re(x+size/2,y+size,size/2)
}
