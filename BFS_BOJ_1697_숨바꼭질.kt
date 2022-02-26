// 2022-02-26
// https://www.acmicpc.net/problem/1697

import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, k) = readLine().split(' ').map{it.toInt()}

    print(bfs(n,k))
}

fun bfs(start:Int, end:Int):Int{
    val q = ArrayDeque<Pair<Int,Int>>()
    val isVisited = BooleanArray(100001)
    q.addFirst(Pair(start,0))
    isVisited[start] = true

    while(q.isEmpty().not()){
        val cur = q.removeLast()
        if(cur.first==end) return cur.second
        if(cur.first-1 >=0 && isVisited[cur.first-1].not()){
            isVisited[cur.first-1]=true
            q.addFirst(Pair(cur.first-1,cur.second+1))
        }
        if(cur.first+1 <=100000 && isVisited[cur.first+1].not()){
            isVisited[cur.first+1]=true
            q.addFirst(Pair(cur.first+1,cur.second+1))
        }
        if(cur.first*2 <=100000 && isVisited[cur.first*2].not()){
            isVisited[cur.first*2]=true
            q.addFirst(Pair(cur.first*2,cur.second+1))
        }
    }

    return 0
}
