/// 2022-03-07
// https://www.acmicpc.net/problem/16933

import java.io.*
import java.util.*

data class Node(val x:Int, val y: Int, val cnt:Int, val day:Int)

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
    val isVisited = Array(n){Array(m){Array(k+1){IntArray(2)} }}
    isVisited[0][0][0][0] = 1
    q.addFirst(Node(0,0,0,0))

    while(q.isEmpty().not()){
        val (x,y,cnt,day) = q.removeLast()
        if(x == n-1 && y == m-1) return isVisited[n-1][m-1][cnt][day]



        // 이동
        for(i in 0..3){
            val nx = x+dx[i]
            val ny = y+dy[i]
            if((nx in graph.indices && ny in graph[0].indices).not()) continue

            if(graph[nx][ny]=='0'){
                if(isVisited[nx][ny][cnt][1-day] != 0) continue
                isVisited[nx][ny][cnt][1-day] = isVisited[x][y][cnt][day]+1
                q.addFirst(Node(nx,ny,cnt,1-day))
            }
            else{
                if(cnt == k) continue
                if(day==0){
                    if(isVisited[nx][ny][cnt+1][1-day] != 0) continue
                    isVisited[nx][ny][cnt+1][1-day] = isVisited[x][y][cnt][day]+1
                    q.addFirst(Node(nx,ny,cnt+1,1-day))
                }
                else{
                    if(isVisited[x][y][cnt][1-day] != 0) continue
                    isVisited[x][y][cnt][1-day] = isVisited[x][y][cnt][day]+1
                    q.addFirst(Node(x,y,cnt,1-day))
                }
            }
        }
    }
    return -1
}
