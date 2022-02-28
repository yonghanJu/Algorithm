// 2022-02-28
// https://www.acmicpc.net/problem/2583

import java.io.*
import java.util.*

val dx = intArrayOf(-1, 0,1,0)
val dy = intArrayOf(0,1,0,-1)
lateinit var graph:Array<BooleanArray>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (m,n,k) =readLine().split(' ').map{it.toInt()}
    val answer = mutableListOf<Int>()
    graph = Array(n){BooleanArray(m)}
    repeat(k){
        val line =readLine().split(' ').map{it.toInt()}
        for(i in line[0] until line[2]){
            for(j in line[1]  until  line[3]) graph[i][j] = true
        }
    }

    for(i in 0 until n){
        for(j in 0 until m) bfs(i,j,n,m)?.let { answer.add(it) }
    }
    println(answer.size)
    answer.sort()
    answer.forEach{print("$it ")}
}

fun bfs(x:Int, y:Int, n:Int, m:Int):Int?{
    if(graph[x][y]) return null
    graph[x][y] = true
    val q = ArrayDeque<Pair<Int,Int>>()
    var answer =0
    q.addFirst(Pair(x,y))

    while(q.isEmpty().not()){
        val cur= q.removeLast()
        answer++
        for(i in 0..3){
            val nx = cur.first+dx[i]
            val ny = cur.second + dy[i]

            if(nx in 0 until n && ny in 0 until m && graph[nx][ny].not()){
                graph[nx][ny] =true
                q.addFirst(Pair(nx,ny))
            }
        }
    }

    return answer
}
