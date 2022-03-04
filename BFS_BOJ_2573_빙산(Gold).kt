// 2022-03-04
// https://www.acmicpc.net/problem/2573

import java.io.*
import java.util.*

data class Node(val i:Int, val j:Int, var w:Int)

var n =0
var m =0
val dx = intArrayOf(1,-1,0,0)
val dy = intArrayOf(0,0,1,-1)
lateinit var isVisited:Array<IntArray>
lateinit var graph:Array<IntArray>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val nm = readLine().split(' ')
    var cnt =0
    var answer =-1
    n = nm[0].toInt()
    m = nm[1].toInt()
    graph = Array(n){readLine().split(' ').map{it.toInt()}.toIntArray()}
    while(true){
        answer++
        cnt =0
        isVisited = Array(n){IntArray(m){-1}}
        for(i in graph.indices){
            for(j in graph[0].indices) {
                cnt += bfs(i,j)
            }
        }
        if(cnt != 1) break
    }

    println(if(cnt<2) 0 else answer)
}

fun bfs(i:Int, j:Int):Int{
    if(graph[i][j]<=0 || isVisited[i][j]!=-1) return 0

    val q = ArrayDeque<Pair<Int,Int>>()
    val list = mutableListOf(Pair(i,j))
    isVisited[i][j]=wC(i,j)
    q.addFirst(Pair(i,j))

    while(q.isEmpty().not()){
        val cur = q.removeLast()

        for(i in 0 ..3){
            val nx = cur.first + dx[i]
            val ny = cur.second + dy[i]
            if(nx in graph.indices && ny in graph[0].indices && isVisited[nx][ny]==-1 && graph[nx][ny]>0){
                isVisited[nx][ny]=wC(nx,ny)
                list.add(Pair(nx,ny))
                q.addFirst(Pair(nx,ny))
            }
        }
    }

    list.forEach{graph[it.first][it.second] -= isVisited[it.first][it.second]}

    return 1
}

fun wC(i:Int,j:Int):Int{
    var c = 0
    for(idx in 0 ..3){
        val nx = i + dx[idx]
        val ny = j + dy[idx]
        if(nx in graph.indices && ny in graph[0].indices && graph[nx][ny]<=0) c++
    }
    return c
}
