// 2022-03-05
// https://www.acmicpc.net/problem/1600

import java.io.*
import java.util.*

val dx = intArrayOf(-2,-2,-1,1,2,2,1,-1,1,-1,0,0)
val dy = intArrayOf(-1,1,2,2,1,-1,-2,-2,0,0,1,-1)


data class Node(val x:Int, val y:Int, val cnt:Int)

var k =0
var h =0
var w = 0
lateinit var graph:Array<IntArray>
lateinit var isVisited:Array<Array<IntArray>>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    k = readLine().toInt()
    val wh = readLine().split(' ')
    h = wh[1].toInt()
    w = wh[0].toInt()
    graph = Array(h){readLine().split(' ').map{it.toInt()}.toIntArray()}
    isVisited = Array(k+1){Array(h){IntArray(w){Int.MAX_VALUE} }}

    println(bfs())
}

fun bfs():Int{
    isVisited[0][0][0] = 0
    val q = ArrayDeque<Node>()
    q.addFirst(Node(0,0,0))

    while(q.isEmpty().not()){
        val cur = q.removeLast()
        if(cur.x==h-1 && cur.y == w-1) return isVisited[cur.cnt][cur.x][cur.y]

        if(cur.cnt <k){
            for(i in 0..7){
                val nx = cur.x+dx[i]
                val ny = cur.y + dy[i]
                if(nx in graph.indices && ny in graph[0].indices && isVisited[cur.cnt+1][nx][ny] > isVisited[cur.cnt][cur.x][cur.y]+1 && graph[nx][ny]==0){
                    isVisited[cur.cnt+1][nx][ny] = isVisited[cur.cnt][cur.x][cur.y]+1
                    q.addFirst(Node(nx,ny,cur.cnt+1))
                }
            }
        }
        for( i in 8..11){
            val nx = cur.x+dx[i]
            val ny = cur.y+dy[i]
            if(nx in graph.indices && ny in graph[0].indices && isVisited[cur.cnt][nx][ny] > isVisited[cur.cnt][cur.x][cur.y]+1 && graph[nx][ny]==0){
                isVisited[cur.cnt][nx][ny] = isVisited[cur.cnt][cur.x][cur.y]+1
                q.addFirst(Node(nx,ny,cur.cnt))
            }
        }
    }

    return -1
}
