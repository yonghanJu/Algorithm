// 2022-03-08
// https://www.acmicpc.net/problem/11967

import java.io.*
import java.util.*

val dx = intArrayOf(1,-1,0,0)
val dy = intArrayOf(0,0,1,-1)
lateinit var graph:Array<Array<MutableSet<Pair<Int,Int>>?>>
lateinit var isVisited:Array<BooleanArray>
lateinit var canGo:Array<BooleanArray>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,m) = readLine().split(' ').map{it.toInt()}
    var answer =1
    var b= 1

    canGo = Array(n+1){BooleanArray(n+1)}
    graph = Array(n+1){Array(n+1){mutableSetOf()}}
    repeat(m){
        val tmp = readLine().split(' ').map{it.toInt()}
        graph[tmp[0]][tmp[1]]!!.add(Pair(tmp[2], tmp[3]))
    }

    canGo[1][1]= true
    while(true){
        var now =0
        val q = ArrayDeque<Pair<Int,Int>>()
        isVisited = Array(n+1){BooleanArray(n+1)}
        q.addFirst(Pair(1,1))
        isVisited[1][1] = true

        while(q.isEmpty().not()){
            val cur = q.removeLast()
            now++
            graph[cur.first][cur.second]?.let{
                for(p in graph[cur.first][cur.second]!!){
                    if(canGo[p.first][p.second] .not()){
                        b++
                        canGo[p.first][p.second] = true
                    }
                }
                graph[cur.first][cur.second] = null

            }

            for(i in 0..3){
                val nx = cur.first+dx[i]
                val ny = cur.second+dy[i]
                if((nx in 1..n && ny in 1..n).not()) continue
                if(canGo[nx][ny].not()) continue
                if(isVisited[nx][ny]) continue
                q.addFirst(Pair(nx,ny))
                isVisited[nx][ny] = true
            }
        }

        if(now==answer) break
        answer = now
    }

    println(b)
}
