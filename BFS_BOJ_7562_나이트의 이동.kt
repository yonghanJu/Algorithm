// 2022-02-24
// https://www.acmicpc.net/problem/7562

import java.io.*
import java.util.*

var size =0
var sx = 0
var sy = 0
var ex =0
var ey=0
val dx = intArrayOf(-2,-1,1,2,2,1,-1,-2)
val dy = intArrayOf(1,2,2,1,-1,-2,-2,-1)
lateinit var graph:Array<IntArray>
lateinit var st:StringTokenizer
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val repeat = readLine().toInt()
    repeat(repeat){
         size = readLine().toInt()
         st = StringTokenizer(readLine())
         sx = st.nextToken().toInt()
         sy = st.nextToken().toInt()
         st = StringTokenizer(readLine())
         ex = st.nextToken().toInt()
         ey = st.nextToken().toInt()
        graph = Array(size){IntArray(size)}

        bw.write("${bfs()}\n")
    }
    bw.flush()
    bw.close()
}

fun bfs():Int{
    val q = ArrayDeque<Pair<Int,Int>>()
    q.addFirst(Pair(sx,sy))
    graph[sx][sy]=1

    while(q.isEmpty().not()){
        val cur = q.removeLast()
        if(cur.first == ex && cur.second == ey) return graph[ex][ey] - 1
        for(i in 0..7){
            val nx = cur.first + dx[i]
            val ny = cur.second + dy[i]

            if(nx in 0 until size && ny in 0 until size && graph[nx][ny]==0){
                q.addFirst(Pair(nx,ny))
                graph[nx][ny] = graph[cur.first][cur.second]+1
            }
        }
    }
    return 0
}
