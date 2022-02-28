// 2022-02-28
// https://www.acmicpc.net/problem/14502

import java.io.*
import java.util.*

data class X(val x:Int, val y:Int)

val dx = intArrayOf(1,-1,0,0)
val dy = intArrayOf(0,0,1,-1)
var n =0
var m =0

lateinit var graph:Array<IntArray>
lateinit var queue:ArrayDeque<X>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine())
    n = st.nextToken().toInt()
    m = st.nextToken().toInt()

    graph = Array(n){IntArray(m)}
    val q = ArrayDeque<X>()
    var answer =n*m
    var out =0
    for(i in 0 until n){
        st = StringTokenizer(readLine())
        for( j in 0 until m){
            val t =st.nextToken().toInt()
            graph[i][j] = t
            if(t==2) q.addFirst(X(i,j))
            if(t==0) out++
        }
    }

    for(i in 0 until n*m-2){
        if(graph[i/m][i%m] != 0) continue
        for(j in i+1 until n*m-1){
            if(graph[j/m][j%m] != 0 || i==j) continue
            for(k in j+1 until n*m){
                if(graph[k/m][k%m] != 0 || k==j) continue
                queue = ArrayDeque()
                q.forEach { queue.add(it) }
                answer = minOf(answer,bfs(i/m,i%m,j/m,j%m,k/m,k%m))
            }
        }
    }

    println(out-3-answer)
}

fun bfs(x1:Int,y1:Int,x2:Int,y2:Int,x3:Int,y3:Int):Int{
    val isVisited = Array(n){BooleanArray(m)}
    var cnt = -queue.size
    while(queue.isEmpty().not()){
        val cur = queue.removeLast()
        cnt++
        for(i in 0..3){
            val nx= cur.x + dx[i]
            val ny = cur.y + dy[i]
            if(nx in 0 until n && ny in 0 until m && isVisited[nx][ny].not() && graph[nx][ny]==0){
                if((nx==x1 && ny == y1) || (nx==x2 && ny == y2) || (nx==x3 && ny == y3)) continue
                queue.addFirst(X(nx,ny))
                isVisited[nx][ny] = true
            }
        }
    }

    return cnt
}
