// 2022-03-02
// https://www.acmicpc.net/problem/5014

import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (F, S, G, U, D) = readLine().split(' ').map{it.toInt()}
    val q = ArrayDeque<Pair<Int,Int>>()
    val isVisited = BooleanArray(F+1)
    q.addFirst(Pair(S,0))
    isVisited[S] = true

    while(q.isEmpty().not()){
        val cur = q.removeLast()
        if(cur.first == G) print(cur.second).let{return}

        if(cur.first+U in 1..F && isVisited[cur.first+U].not()){
            q.addFirst(Pair(cur.first+U,cur.second+1))
            isVisited[cur.first+U] = true
        }
        if(cur.first-D in 1..F && isVisited[cur.first-D].not()){
            q.addFirst(Pair(cur.first-D,cur.second+1))
            isVisited[cur.first-D] = true
        }
    }
    print("use the stairs")
}
