// 2022-03-03
// https://www.acmicpc.net/problem/5427

import java.io.*
import java.util.*

data class Node(val x:Int, val y: Int)
val dx = intArrayOf(1,-1,0,0)
val dy = intArrayOf(0,0,1,-1)
var w =0
var h =0
lateinit var graph: Array<CharArray>
lateinit var fireVisited: Array<IntArray>
lateinit var visited: Array<IntArray>
lateinit var q1:ArrayDeque<Node>
lateinit var q2:ArrayDeque<Node>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st:StringTokenizer
    var repeat = readLine().toInt()
    repeat(repeat){
        st = StringTokenizer(readLine())
        w = st.nextToken().toInt()
        h = st.nextToken().toInt()
        graph = Array(h){readLine().toCharArray()}
        q1 = ArrayDeque()
        q2 = ArrayDeque()
        visited = Array(h){IntArray(w) }
        fireVisited = Array(h){IntArray(w) }
        for(i in 0 until h){
            for(j in 0 until w) {
                if(graph[i][j]=='@') q1.addFirst(Node(i,j)).let{visited[i][j]=1}
                else if(graph[i][j]=='*')q2.addFirst(Node(i,j)).let { fireVisited[i][j]=1 }
            }
        }
        println(bfs())
    }
}

fun bfs():String{
    var ans = Int.MAX_VALUE
    while(q2.isEmpty().not()){
        val cur = q2.removeLast()

        for(i in 0..3){
            val nx = cur.x + dx[i]
            val ny = cur.y + dy[i]

            if(nx in 0 until h && ny in 0 until w && graph[nx][ny]=='.' && fireVisited[nx][ny]==0){
                q2.addFirst(Node(nx,ny))
                fireVisited[nx][ny] = fireVisited[cur.x][cur.y]+1
            }
        }
    }

    while(q1.isEmpty().not()){
        val cur = q1.removeLast()
        if(cur.x ==0 || cur.x== h-1 || cur.y==0 || cur.y == w-1){
           if(visited[cur.x][cur.y] < fireVisited[cur.x][cur.y] || fireVisited[cur.x][cur.y]==0) ans = minOf(ans,visited[cur.x][cur.y])
        }
        for(i in 0..3){
            val nx = cur.x + dx[i]
            val ny = cur.y + dy[i]

            if(nx in 0 until h && ny in 0 until w && graph[nx][ny]=='.' && visited[nx][ny]==0){
                q1.addFirst(Node(nx,ny))
                visited[nx][ny] = visited[cur.x][cur.y]+1
            }
        }
    }

    return if(ans== Int.MAX_VALUE) "IMPOSSIBLE" else ans.toString()
}
