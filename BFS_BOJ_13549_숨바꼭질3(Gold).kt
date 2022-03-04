// 2022-03-04
// https://www.acmicpc.net/problem/13549

import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,m) = readLine().split(' ').map{it.toInt()}
    val graph = IntArray(100001){Int.MAX_VALUE}
    val q = ArrayDeque<Pair<Int,Int>>()
    graph[n] =0
    q.add(Pair(n,0))

    while(q.isEmpty().not()){
        val cur= q.removeLast()
        if(cur.first == m) return print(cur.second)

        if(cur.first+1 <= 100000 && graph[cur.first+1] > cur.second+1){
            graph[cur.first+1] = cur.second+1
            q.addFirst(Pair(cur.first+1,cur.second+1))
        }
        if(cur.first-1 >=0 && graph[cur.first-1] > cur.second+1){
            graph[cur.first-1] = cur.second+1
            q.addFirst(Pair(cur.first-1,cur.second+1))
        }
        if(cur.first*2 <= 100000 && graph[cur.first*2] > cur.second){
            graph[cur.first*2] = cur.second
            q.add(Pair(cur.first*2, cur.second))
        }
    }

}
