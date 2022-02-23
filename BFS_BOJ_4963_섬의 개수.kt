// 2022-02-23
// https://www.acmicpc.net/problem/4963

import java.io.*
import java.util.*

lateinit var graph:Array<IntArray>
val nh = arrayOf(-1, -1, -1, 0, 1, 1, 1, 0)
val nw = arrayOf(-1, 0, 1, 1, 1, 0, -1, -1)
var w =0
var h =0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine())
    w = st.nextToken().toInt()
    h = st.nextToken().toInt()

    while(w != 0 || h != 0){
        var answer =0
        graph = Array(h){readLine().split(' ').map{it.toInt()}.toIntArray()}

        for (i in 0 until h){
            for(j in 0 until w) answer += bfs(i, j)
        }

        println(answer)
        st = StringTokenizer(readLine())
        w = st.nextToken().toInt()
        h = st.nextToken().toInt()
    }


}

fun bfs(he: Int, wi: Int):Int{
    if(graph[he][wi] == 0) return 0
    val queue = ArrayDeque<Pair<Int,Int>>()
    queue.addFirst(Pair(he,wi))
    graph[he][wi] = 0

    while(queue.isEmpty().not()){
        val cur = queue.removeLast()

        for(dir in 0 until 8){ // 좌상단 부터 시계방향
            val newH = cur.first + nh[dir]
            val newW = cur.second + nw[dir]

            if(newH in 0 until h && newW in 0 until w && graph[newH][newW]==1){
                queue.addFirst(Pair(newH,newW))
                graph[newH][newW] = 0
            }
        }
    }
    return 1
}
