// 2022-03-04
// https://www.acmicpc.net/problem/2206

import java.io.*
import java.util.*

data class Node(val x:Int, val y:Int, val cnt:Int, val p:Boolean)

val dx= intArrayOf(1,-1,0,0)
val dy= intArrayOf(0,0,1,-1)
lateinit var graph:Array<CharArray>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,m) = readLine().split(' ').map{it.toInt()}
    graph = Array(n){readLine().toCharArray()}
    println(bfs(n,m))
}
fun bfs(n:Int, m:Int):Int{
    val q =ArrayDeque<Node>()
    val isVisited = Array(n){BooleanArray(m)}
    val isVisited2 = Array(n){BooleanArray(m)}
    var answer = Int.MAX_VALUE
    q.addFirst(Node(0,0,1,false))
    isVisited[0][0] = true

    while(q.isEmpty().not()){
        val cur = q.removeLast()
        if(cur.x == n-1 && cur.y==m-1) answer = minOf(answer, cur.cnt)

        for(i in 0..3){
            val nx = cur.x + dx[i]
            val ny = cur.y + dy[i]
            if(nx in 0 until n && ny in 0 until m ){
                if(cur.p && isVisited[nx][ny].not() && isVisited2[nx][ny].not() && graph[nx][ny]=='0'){
                    q.addFirst(Node(nx,ny,cur.cnt+1,true))
                    isVisited2[nx][ny]=true
                }else if(cur.p.not() && isVisited[nx][ny].not() && graph[nx][ny]=='0'){
                    q.addFirst(Node(nx,ny,cur.cnt+1,false))
                    isVisited[nx][ny]=true
                }else if(cur.p.not() && isVisited2[nx][ny].not() && graph[nx][ny] == '1'){
                    q.addFirst(Node(nx,ny,cur.cnt+1, true))
                    isVisited2[nx][ny]=true
                }
            }
        }
    }
    return if(answer == Int.MAX_VALUE) -1 else answer
}
