// 2022-03-07
// https://www.acmicpc.net/problem/16920

import java.io.*
import java.util.*

data class Node(val x:Int, val y:Int, val cnt:Int)

val dx = intArrayOf(1,-1,0,0)
val dy = intArrayOf(0,0,1,-1)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,m,p) = readLine().split(' ').map{it.toInt()}
    val S = readLine().split(' ').map{it.toInt()}
    val graph = Array(n){readLine().toCharArray()}
    val answer = IntArray(p)
    val qList = Array(p){ArrayDeque<Node>()}
    for(i in graph.indices){
        for(j in graph[0].indices){
            if(graph[i][j] != '.' && graph[i][j] !='#') qList[graph[i][j]-'0'-1].addFirst(Node(i,j,0))
        }
    }

    while(true){
        var isDone=0

        for(p in S.indices){
            val queue = ArrayDeque<Node>()
            while(qList[p].isEmpty().not()){
                val cur = qList[p].removeLast()
                if(cur.cnt == S[p]){
                    queue.addFirst(Node(cur.x,cur.y,0))
                    continue
                }
                answer[p]++
                for(i in 0..3){
                    val nx = cur.x+dx[i]
                    val ny = cur.y+dy[i]
                    if((nx in graph.indices && ny in graph[0].indices).not()) continue
                    if(graph[nx][ny]=='.'){
                        graph[nx][ny] = graph[cur.x][cur.y]
                        qList[p].addFirst(Node(nx,ny,cur.cnt+1))
                        isDone++
                    }
                }
            }
            qList[p] = queue
        }

        if(isDone==0) break
    }
    answer.forEach { print("$it ") }
}
