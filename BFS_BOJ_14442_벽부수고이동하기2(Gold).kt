// 2022-03-05
// https://www.acmicpc.net/problem/14442

import java.io.*
import java.util.*

data class Node(val x:Int, val y: Int, val cnt:Int)

val dx = intArrayOf(1,-1,0,0)
val dy = intArrayOf(0,0,1,-1)
lateinit var graph:Array<CharArray>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,m,k) = readLine().split(' ').map{it.toInt()}
    graph = Array(n){readLine().toCharArray()}

    println(bfs(n,m,k))
}

fun bfs(n:Int, m:Int, k:Int):Int{
    val q = ArrayDeque<Node>()
    val isVisited = Array(n){Array(m){IntArray(k+1){Int.MAX_VALUE} }}
    isVisited[0][0][0] = 1
    q.addFirst(Node(0,0,0))

    while(q.isEmpty().not()){
        val cur = q.removeLast()
        if(cur.x == n-1 && cur.y == m-1) return isVisited[n-1][m-1][cur.cnt]

        for(i in 0..3){
            val nx = cur.x+dx[i]
            val ny = cur.y+dy[i]
            if(nx in graph.indices && ny in graph[0].indices && isVisited[nx][ny][cur.cnt]==Int.MAX_VALUE && graph[nx][ny]=='0'){
                isVisited[nx][ny][cur.cnt] = isVisited[cur.x][cur.y][cur.cnt]+1
                q.addFirst(Node(nx,ny,cur.cnt))
            }
            if(nx in graph.indices && ny in graph[0].indices && cur.cnt < k && isVisited[nx][ny][cur.cnt+1] > isVisited[cur.x][cur.y][cur.cnt]+1 && graph[nx][ny]=='1'){
                isVisited[nx][ny][cur.cnt+1] = isVisited[cur.x][cur.y][cur.cnt]+1
                q.addFirst(Node(nx,ny,cur.cnt+1))
            }
        }
    }
    return -1
}
