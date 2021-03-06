// 2022-02-23
// https://www.acmicpc.net/problem/1012

import java.io.*
import java.util.*
import kotlin.collections.ArrayDeque

lateinit var table:Array<Array<Int>>
var answer = 0
var M =0
var N =0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val testCase = readLine().toInt()
    repeat(testCase){
        var (m, n, k) = readLine().split(' ').map{it.toInt()} // m가로, n세로
        M=m
        N=n
        answer = 0
        table = Array(m){ Array(n){0} }
        repeat(k){
            val (m1, n1) = readLine().split(' ').map { it.toInt() }
            table[m1][n1]=1
        }

        for(i in 0 until M){
            for(j in 0 until N) {
                if(table[i][j]==1) answer+=bfs(i,j)
            }
        }
        println(answer)
    }
}

fun bfs(m: Int, n: Int): Int{
    if(table [m][n] == 0) return 0

    val queue:Queue<Pair<Int,Int>> = LinkedList()
    queue.add(Pair(m,n))
    table[m][n] = 0

    while(!queue.isEmpty()){
        val node = queue.poll()

        if(node.first>0 && table[node.first-1][node.second]==1) {
            queue.add(Pair(node.first-1,node.second))
            table[node.first-1][node.second] = 0
        }
        if(node.first<M-1 && table[node.first+1][node.second]==1) {
            queue.add(Pair(node.first+1,node.second))
            table[node.first+1][node.second] = 0
        }
        if(node.second>0 && table[node.first][node.second-1]==1) {
            queue.add(Pair(node.first,node.second-1))
            table[node.first][node.second-1] = 0
        }
        if(node.second<N-1 && table[node.first][node.second+1]==1) {
            queue.add(Pair(node.first,node.second+1))
            table[node.first][node.second+1] = 0
        }
    }

    return 1
}

