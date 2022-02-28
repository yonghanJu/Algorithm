// 2022-02-28
// https://www.acmicpc.net/problem/2468

import java.io.*
import java.util.*

var n =0
val dx = intArrayOf(1,-1,0,0)
val dy = intArrayOf(0,0,1,-1)
lateinit var save:Array<IntArray>
lateinit var graph:Array<IntArray>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var max =0
    n = readLine().toInt()
    save = Array(n){readLine().split(' ').map{it.toInt()}.toIntArray()}

    for(h in 0..100){
        var cnt =0
        graph = Array(n){save[it].clone()}
        for(i in 0 until n){
            for(j in 0 until n) cnt +=bfs(i,j,h)
        }
        if(max < cnt) max = cnt

    }

    println(max)
}

fun bfs(x:Int,y:Int,h:Int):Int{
    if(graph[x][y] <= h) return 0
    val q = ArrayDeque<Pair<Int,Int>>()
    q.addFirst(Pair(x,y))
    graph[x][y] = 0

    while(q.isEmpty().not()){
        val cur = q.removeLast()

        for(i in 0..3){
            val nx = cur.first + dx[i]
            val ny = cur.second + dy[i]
            if(nx in 0 until n  && ny in 0 until n && graph[nx][ny] > h ){
                graph[nx][ny]=0
                q.addFirst(Pair(nx,ny))
            }
        }
    }

    return 1
}
