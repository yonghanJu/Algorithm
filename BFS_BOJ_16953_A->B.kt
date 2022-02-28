// 2022-02-28
// https://www.acmicpc.net/problem/16953

import java.io.*
import java.util.*

data class Pair(val first:Long, val second:Int)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (a,b) = readLine().split(' ').map{it.toLong()}
    println( bfs(a,b) )
}

fun bfs(a:Long, b:Long):Int{
    val q = ArrayDeque<Pair>()
    val isVisited = HashMap<Long,Boolean>()
    q.addFirst(Pair(a,1))
    isVisited[a] = true

    while(q.isEmpty().not()){
        val cur = q.removeLast()
        if(cur.first==b) return cur.second
        if(cur.first*2 <= b && isVisited[cur.first*2]==null){
            isVisited[cur.first*2] =true
            q.addFirst(Pair(cur.first*2, cur.second+1))
        }
        if(cur.first*10+1 <= b&& isVisited[cur.first*10+1]==null){
            isVisited[cur.first*10+1]=true
            q.addFirst(Pair(cur.first*10+1, cur.second+1))
        }
    }

    return -1
}
