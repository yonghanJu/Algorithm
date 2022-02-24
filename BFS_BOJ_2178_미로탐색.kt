// 2022-02-24
// https://www.acmicpc.net/problem/2178

import java.io.*
import java.util.*

var n = 0
var m = 0
val xm = listOf(-1,0,1,0)
val ym = listOf(0,1,0,-1)
lateinit var graph:Array<CharArray>

data class Pair(val first:Int, val second:Int, val level:Int)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val nm = readLine().split(' ')
    n = nm[0].toInt()
    m = nm[1].toInt()

    graph = Array(n){readLine().toCharArray()}

    println(bfs())
}

fun bfs():Int{
    val queue = ArrayDeque<Pair>()
    queue.addFirst(Pair(0,0,1))
    graph[0][0]= '0'

    while(queue.isEmpty().not()){
        val cur = queue.removeLast()
        if(cur.first==n-1 && cur.second == m-1) return cur.level
        for(i in 0..3){
            val nx = cur.first + xm[i]
            val ny = cur.second + ym[i]

            if(nx in 0 until n && ny in 0 until m && graph[nx][ny]=='1'){
                queue.addFirst(Pair(nx,ny, cur.level+1))
                graph[nx][ny]='0'
            }
        }
    }
    return 0
}
