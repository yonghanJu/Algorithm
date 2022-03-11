// 2022-03-12
// https://www.acmicpc.net/problem/17142

import java.io.*
import java.util.*


var n=0
var m =0
var z=0
var answer =Int.MAX_VALUE
val dx = intArrayOf(1,-1,0,0)
val dy = intArrayOf(0,0,1,-1)
lateinit var q:ArrayDeque<Pair<Int,Int>>
lateinit var isVisited:Array<IntArray>
lateinit var graph:Array<IntArray>
lateinit var list:MutableList<Pair<Int,Int>>
lateinit var mList:MutableList<Pair<Int,Int>>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N,M) = readLine().split(' ').map{it.toInt()}
    n = N
    m = M
    graph = Array(n){readLine().split(' ').map{it.toInt()}.toIntArray()}
    list = mutableListOf()
    mList = MutableList(m){Pair(0,0)}
    for(i in 0 until n){
        for( j in 0 until n) {
            if(graph[i][j]==2) {
                list.add(Pair(i,j))
            }
            else if(graph[i][j]==0) z++
        }
    }
    for(index in list.indices ) bf(index,0)
    println(if(answer==Int.MAX_VALUE) -1 else if(z==0) 0 else answer)
}

fun bf(index:Int, depth:Int){
    mList[depth] = list[index]
    if(depth==m-1) {
        answer  = minOf(answer, bfs())
        return
    }
    for(i in index+1..list.lastIndex){
        bf(i,depth+1)
    }
}

fun bfs():Int{
    var cnt =0
    var zc =0
    isVisited = Array(n){IntArray(n)}
    q = ArrayDeque<Pair<Int, Int>>().apply {
        mList.forEach{p->
            isVisited[p.first][p.second]=1
            addFirst(p)
        }
    }

    while(q.isEmpty().not()){
        val cur = q.removeLast()
        if(graph[cur.first][cur.second] == 0) {
            zc++
            cnt = isVisited[cur.first][cur.second]
        }
        for(i in 0..3){
            val nx = cur.first+dx[i]
            val ny = cur.second+dy[i]

            if((nx in 0 until n && ny in 0 until n).not()) continue
            if(isVisited[nx][ny] != 0) continue
            if(graph[nx][ny] == 1) continue
            isVisited[nx][ny] = isVisited[cur.first][cur.second]+1
            q.addFirst(Pair(nx,ny))
        }
    }

    return if(zc<z) Int.MAX_VALUE else cnt-1
}
