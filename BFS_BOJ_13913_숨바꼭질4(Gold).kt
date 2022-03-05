// 2022-03-05
// https://www.acmicpc.net/problem/13913

import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var (a,b) = readLine().split(' ').map{it.toInt()}
    val q = ArrayDeque<Pair<Int,Int>>()
    val answer = mutableListOf<Int>()
    val isVisited = IntArray(100001){-1}
    q.addFirst(Pair(a,0))
    isVisited[a] = a

    while(q.isEmpty().not()){
        val cur = q.removeLast()
        if(cur.first==b) {
            println(cur.second)
            var pop = cur.first
            while(pop != a){
                answer.add(pop)
                pop = isVisited[pop]
            }
            answer.add(a)
            break
        }

        if(cur.first-1>=0 && isVisited[cur.first-1] == -1){
            isVisited[cur.first-1] = cur.first
            q.addFirst(Pair(cur.first-1, cur.second+1))
        }
        if(cur.first+1<=100000 && isVisited[cur.first+1] == -1){
            isVisited[cur.first+1] = cur.first
            q.addFirst(Pair(cur.first+1, cur.second+1))
        }

        if(cur.first*2<=100000 && isVisited[cur.first*2]==-1){
            isVisited[cur.first*2] = cur.first
            q.addFirst(Pair(cur.first*2, cur.second+1))
        }
    }

    for(i in answer.size-1 downTo 0) print("${answer[i]} ")
}
