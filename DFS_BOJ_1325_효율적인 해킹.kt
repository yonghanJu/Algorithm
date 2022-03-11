// 2022-03-10
// https://www.acmicpc.net/problem/1325

import java.io.*
import java.util.*

var max = 0
lateinit var graph:Array<MutableList<Int>>
lateinit var isVisited:IntArray
lateinit var visited:BooleanArray

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,m) = readLine().split(' ').map{it.toInt()}
    graph = Array(n+1){ mutableListOf() }
    repeat(m){
        val (a,b) = readLine().split(' ').map{it.toInt()}
        graph[a].add(b)
    }

    var max = 0
    isVisited = IntArray(n+1)
    for(i in 1..n) {
        visited = BooleanArray(n+1)
        dfs(i)
    }
    isVisited.forEach{max = maxOf(it,max)}

    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    isVisited.forEachIndexed() {idx,it-> if(it==max)bw.write("$idx ") }
    bw.flush()
    bw.close()
}

fun dfs(i:Int):Int{
    visited[i]=true

    for(p in graph[i]) {
        if(visited[p]) continue
        isVisited[p] +=1
        dfs(p)
    }

    return  isVisited[i]
}
