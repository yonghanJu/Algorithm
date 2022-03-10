// 2022-03-10
// https://www.acmicpc.net/problem/3197

import java.io.*
import java.util.*

val dx = intArrayOf(1,-1,0,0)
val dy = intArrayOf(0,0,1,-1)

data class Node(val first:Int, val second:Int, val cnt:Int)

lateinit var graph:Array<CharArray>
lateinit var isVisited : Array<IntArray>
lateinit var swan : ArrayDeque<Pair<Int,Int>>
lateinit var q:ArrayDeque<Pair<Int,Int>>
lateinit var q2:ArrayDeque<Pair<Int,Int>>
lateinit var set:MutableSet<Pair<Int,Int>>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,m) = readLine().split(' ').map{it.toInt()}
    var day =1
    graph = Array(n){readLine().toCharArray()}

    swan = ArrayDeque()
    q = ArrayDeque()
    q2 = ArrayDeque()
    isVisited = Array(n){IntArray(m)}
    set = mutableSetOf()

    for(i in graph.indices){
        for(j in graph[0].indices){
            if(graph[i][j] =='L'){
                if(swan.isEmpty()){
                    swan.addFirst(Pair(i,j))
                    isVisited[i][j]=1
                }else{
                    isVisited[i][j]=2
                }
                q.addFirst(Pair(i,j))
            }else if(graph[i][j]=='.'){
                q.addFirst(Pair(i,j))
            }
        }
    }

    while(true){
        // 물 녹음
        while(q.isEmpty().not()){
            val cur = q.removeLast()
            for(i in 0..3){
                val nx = cur.first+dx[i]
                val ny = cur.second+dy[i]
                if((nx in graph.indices && ny in graph[0].indices).not()) continue
                else if(graph[nx][ny]=='.') continue
                else if(graph[nx][ny]=='X'){
                    graph[nx][ny] = '.'
                    q2.addFirst(Pair(nx,ny))
                }
            }
        }
        q = q2.clone()
        q2 = ArrayDeque()

        while(swan.isEmpty().not()){
            val cur= swan.removeLast()
            for(i in 0..3){
                val nx = cur.first+dx[i]
                val ny = cur.second+dy[i]
                if((nx in graph.indices && ny in graph[0].indices).not()) continue
                else if(isVisited[nx][ny] == 1) continue
                else if(isVisited[nx][ny]==2) println(day).let{return}
                else if(graph[nx][ny] == 'X') {
                    set.add(Pair(nx,ny))
                }
                else{
                    swan.addFirst(Pair(nx,ny))
                    isVisited[nx][ny] = 1
                }
            }
        }

        swan = ArrayDeque(set)
        set = mutableSetOf()
        day++
    }
}
