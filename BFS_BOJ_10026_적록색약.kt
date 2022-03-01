// 2022-03-02
// https://www.acmicpc.net/problem/10026

import java.io.*
import java.util.*

data class Pair(val first:Int, val second:Int, val color:Char)

var n =0
lateinit var graph:Array<CharArray>
lateinit var tmp:Array<CharArray>
val dx = intArrayOf(1,-1,0,0)
val dy = intArrayOf(0,0,1,-1)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    var answer =0
    graph = Array(n){readLine().toCharArray()}
    tmp = Array(n){graph[it].clone()}
    for(i in 0 until n){
        for(j in 0 until n) answer += bfs(i,j,1)
    }
    print("$answer ")
    answer =0
    graph = Array(n){tmp[it].clone()}
    for(i in 0 until n){
        for(j in 0 until n) answer += bfs(i,j,2)
    }
    print(answer)
}

fun bfs(x:Int, y:Int, type:Int):Int{
    if(graph[x][y]=='0') return 0
    var answer =0
    val q = ArrayDeque<Pair>()
    q.addFirst(Pair(x,y, graph[x][y]))
    graph[x][y] = '0'

    while(q.isEmpty().not()){
        val cur= q.removeLast()

        for(i in 0..3){
            val nx = cur.first + dx[i]
            val ny = cur.second + dy[i]
            if(nx in 0 until n && ny in 0 until n && graph[nx][ny]!='0'){
                if(cur.color == graph[nx][ny] && type==1) { // 기본
                    q.addFirst(Pair(nx,ny,cur.color))
                    graph[nx][ny]='0'
                }
                if( type == 2 &&((cur.color == 'G' && graph[nx][ny]=='R') || (cur.color == 'R' && graph[nx][ny]=='G') || cur.color == graph[nx][ny])) { // 색약
                    q.addFirst(Pair(nx,ny,cur.color))
                    graph[nx][ny]='0'
                }
            }
        }
    }
    return 1
}
