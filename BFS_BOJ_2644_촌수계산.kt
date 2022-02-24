// 2022-02-24
// https://www.acmicpc.net/problem/2644

import java.io.*
import java.util.*

lateinit var graph:Array<MutableList<Int>>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val size = readLine().toInt()
    val (target1,target2) = readLine().split(' ').map{it.toInt()}
    val l = readLine().toInt()
    graph = Array(size+1){ mutableListOf() }
    repeat(l){
        val tmp = readLine().split(' ').map{it.toInt()}
        graph[tmp[0]].add(tmp[1])
        graph[tmp[1]].add(tmp[0])
    }

    print(bfs(target1,target2,size))
}

fun bfs(start: Int, end:Int,size:Int):Int{
    val q = ArrayDeque<Int>()
    val distance = IntArray(size+1)
    val isVisited = BooleanArray(size +1)

    q.addFirst(start)
    isVisited[start] = true

    while(q.isEmpty().not()){
        val cur = q.removeLast()
        if(cur==end) return distance[end]

        graph[cur].forEach{
            if(isVisited[it].not()){
                distance[it] = distance[cur]+1
                q.addFirst(it)
                isVisited[it] = true
            }
        }
    }
    return -1
}
