// 2022-02-24
// https://www.acmicpc.net/problem/1926

import java.io.*
import java.util.*

lateinit var graph:Array<MutableList<Int>>
var max =0
val xDir = listOf(-1,0,1,0)
val yDir = listOf(0, 1, 0, -1)
var n =0
var m =0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val nm = readLine().split(' ').map{it.toInt()}
    n = nm[0]
    m = nm[1]
    graph = Array(n){ readLine().split(' ').map { it.toInt() }.toMutableList() }

    var answer =0
    for(i in 0 until n){
        for( j in 0 until m) {
            val p =bfs(i,j)
            answer += p.first
            max = maxOf(p.second,max)
        }
    }

    println(answer)
    println(max)
}

fun bfs(x:Int, y:Int): Pair<Int,Int>{
    if(graph[x][y] == 0 ) return Pair(0,0)
    val queue = ArrayDeque<Pair<Int,Int>>()
    queue.addFirst(Pair(x,y))
    graph[x][y] =0
    var size =0

    while(queue.isEmpty().not()){
        val cur = queue.removeLast()
        size++
        for(i in 0..3){
            val nx = cur.first + xDir[i]
            val ny = cur.second + yDir[i]

            if(nx>=0 && nx <n && ny >=0 && ny <m && graph[nx][ny]==1){
                queue.addFirst(Pair(nx,ny))
                graph[nx][ny] =0
            }
        }
    }

    return Pair(1,size)
}
