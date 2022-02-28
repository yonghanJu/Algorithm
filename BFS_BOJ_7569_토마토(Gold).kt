// 2022-02-28
// https://www.acmicpc.net/problem/7569

import java.io.*
import java.util.*
import kotlin.collections.ArrayDeque

data class T(val h:Int,val y:Int, val x:Int, val cnt:Int)

val dx = intArrayOf(1,-1,0,0,0,0)
val dy=  intArrayOf(0,0,1,-1,0,0)
val dh = intArrayOf(0,0,0,0,1,-1)
var m =0
var n =0
var h =0
lateinit var q:ArrayDeque<T>
lateinit var graph:Array<Array<IntArray>>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine())
    m = st.nextToken().toInt()
    n = st.nextToken().toInt()
    h = st.nextToken().toInt()

    graph = Array(h){Array(n){IntArray(m)}}
    q = ArrayDeque()

    for(i in 0 until h){
        for(j in 0 until n){
            st = StringTokenizer(readLine())
            for(k in 0 until m){
                graph[i][j][k] =st.nextToken().toInt()
                if(graph[i][j][k] == 1) q.addFirst(T(i,j,k,0))
            }
        }
    }
    val answer =bfs()
    for(i in 0 until h){
        for(j in 0 until n){
            for(k in 0 until m) if(graph[i][j][k]==0) println(-1).let{return}
        }
    }
    println(answer)
}

fun bfs():Int{
    var day =0

    while(q.isEmpty().not()){
        val cur = q.removeLast()
        day = cur.cnt

        for(i in 0..5){
            val nh = cur.h + dh[i]
            val ny = cur.y + dy[i]
            val nx = cur.x + dx[i]
            if(nh in 0 until h && ny in 0 until n && nx in 0 until m && graph[nh][ny][nx]==0){
                graph[nh][ny][nx] = 1
                q.addFirst(T(nh,ny,nx,cur.cnt+1))
            }
        }
    }

    return day
}
