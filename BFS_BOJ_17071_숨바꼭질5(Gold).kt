// 2022-03-08
// https://www.acmicpc.net/problem/17071

import java.io.*
import java.util.*

data class Node(val x:Int, val time:Int)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,k) = readLine().split(' ').map{it.toInt()}
    val isVisited = Array(500001){IntArray(2){-1} }
    val q = ArrayDeque<Node>()
    q.addFirst(Node(n,0))
    isVisited[n][0] = 0

    while(q.isEmpty().not()){
        val cur= q.removeLast()
        val nt = cur.time+1
        if(cur.x-1>=0 && isVisited[cur.x-1][nt%2] == -1){
            q.addFirst(Node(cur.x-1, nt))
            isVisited[cur.x-1][nt%2] = nt
        }
        if(cur.x+1<=500000&& isVisited[cur.x+1][nt%2] == -1){
            q.addFirst(Node(cur.x+1, nt))
            isVisited[cur.x+1][nt%2] = nt
        }
        if(cur.x*2<=500000&& isVisited[cur.x*2][nt%2] == -1){
            q.addFirst(Node(cur.x*2, nt))
            isVisited[cur.x*2][nt%2] = nt
        }
    }

    var K = k
    var answer = 0
    var time = 0
    while(K<=500000){
        if(isVisited[K][time%2] != -1 && isVisited[K][time%2] <= time ){
            println(time)
            return
        }
        time++
        K+=time
    }
    println(-1)
}
