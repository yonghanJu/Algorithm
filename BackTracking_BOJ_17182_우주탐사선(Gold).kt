// 2022-04-01
// https://www.acmicpc.net/problem/17182

import java.io.*
import java.util.*


var answer =Int.MAX_VALUE
var n =0
var start = 0
lateinit var isVisited:BooleanArray
lateinit var graph:Array<IntArray>
fun main():Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val ns = readLine().split(' ')
    n = ns[0].toInt()
    start = ns[1].toInt()
    graph = Array(n){readLine().split(' ').map{it.toInt()}.toIntArray()}
    isVisited = BooleanArray(n)
    isVisited[start]=true
    dfs(start, 0, 1)
    println(answer)
}

fun dfs(cur:Int, dis:Int, size:Int){
    if(size == n){
        answer = minOf(answer, dis)
        return
    }
    for(i in 0 until n){
        if(i==cur) continue
        if(isVisited[i]) continue
        var min = graph[cur][i]
        for(j in 0 until n){
            min = minOf(min, graph[cur][j] + graph[j][i])
        }
        isVisited[i]=true
        dfs(i,dis+min,size+1)
        isVisited[i]=false
    }
}
