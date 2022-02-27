// 2022-02-26
// https://www.acmicpc.net/problem/2667

import java.io.*
import java.util.*

val dx = intArrayOf(-1, 0,1,0)
val dy = intArrayOf(0,1,0,-1)
lateinit var graph:Array<MutableList<Int>>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val answer = mutableListOf<Int>()
    graph = Array(n){readLine().toCharArray().map{it-'0'}.toMutableList()}

    for(i in 0 until n){
        for(j in 0 until n) {
            val a = bfs(i,j,n)
            if(a>0) answer.add(a)
        }
    }
    answer.sort()
    println(answer.size)
    answer.forEach{ println(it) }
}

fun bfs(x:Int, y:Int, n:Int):Int{
    if(graph[x][y]==0) return -1
    val q = ArrayDeque<Pair<Int,Int>>()
    var cnt = 0
    q.addFirst(Pair(x,y))
    graph[x][y] = 0

    while(q.isEmpty().not()){
        val cur = q.removeLast()
        cnt++
        for(i in 0..3){
            val nx = cur.first + dx[i]
            val ny = cur.second + dy[i]
            if(nx in 0 until n && ny in 0 until n && graph[nx][ny] == 1){
                graph[nx][ny] = 0
                q.addFirst(Pair(nx,ny))
            }
        }
    }

    return cnt
}
