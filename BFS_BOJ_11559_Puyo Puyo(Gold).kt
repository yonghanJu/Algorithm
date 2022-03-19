// 2022-03-20
// https://www.acmicpc.net/problem/11559

import java.io.*
import java.util.*

var answer =0
lateinit var graph:Array<LinkedList<Char>>
lateinit var isVisited: Array<BooleanArray>

val dx = intArrayOf(1,-1,0,0)
val dy = intArrayOf(0,0,1,-1)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    graph = Array(6){LinkedList()}
    repeat(12){
        val tmp =readLine()
        tmp.forEachIndexed{idx,it-> graph[idx].addFirst(tmp[idx])}
    }

    while(true){

        var isBoom =false
        for(w in 0..5){
            for(h in 0..11){
                if(bfs(w,h)) isBoom = true
            }
        }
        if(isBoom) answer++
        else break

        for(i in 0..5){
            val it = graph[i].listIterator()
            while(it.hasNext()){
                if(it.next()=='.'){
                    it.remove()
                }
            }
            while(graph[i].size!=12){
                graph[i].addLast('.')
            }
        }
    }
    println(answer)
}

fun bfs(x:Int, y:Int):Boolean{
    if(graph[x][y]=='.') return false

    val q:ArrayDeque<Pair<Int,Int>> = ArrayDeque()
    val tl = mutableListOf<Pair<Int,Int>>()
    isVisited = Array(6){BooleanArray(12)}

    isVisited[x][y]=true
    q.addFirst(Pair(x,y))

    while(q.isEmpty().not()){
        val (x,y) = q.removeLast()
        tl.add(Pair(x,y))

        for(i in 0..3){
            val nx = x+dx[i]
            val ny = y+dy[i]

            if((nx in 0..5 && ny in 0..11).not()) continue
            if(isVisited[nx][ny] || graph[nx][ny] != graph[x][y]) continue
            isVisited[nx][ny] =true
            q.addFirst(Pair(nx,ny))
        }
    }

    if(tl.size >= 4){
        tl.forEach{graph[it.first][it.second]='.'}
        return true
    }
    return false
}
