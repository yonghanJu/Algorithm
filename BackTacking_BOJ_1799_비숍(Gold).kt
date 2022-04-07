// 2022-04-07
// https://www.acmicpc.net/problem/1799

import java.io.*
import java.util.*

var answer = intArrayOf(0,0)
var n = 0
lateinit var isVisited: HashMap<Pair<Boolean,Int>,Boolean>
lateinit var board:Array<IntArray>
fun main():Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    board = Array(n){readLine().split(' ').map{it.toInt()}.toIntArray()}
    isVisited = HashMap()

    dfs(0,0,0,0)
    dfs(0,1,0,1)
    println(answer[0]+answer[1])
}

fun dfs(x:Int, y:Int,cnt:Int,w:Int){
    var nx = x
    var ny = y
    if(ny>=n){
        nx++
        ny = (ny+1)%2
    }
    if(nx>=n){
        answer[w] = maxOf(answer[w], cnt)
        return
    }

    if(isVisited[Pair(false,nx-ny)] != true && isVisited[Pair(true, nx+ny)] != true && board[nx][ny]==1){
        isVisited[Pair(false,nx-ny)] = true
        isVisited[Pair(true,nx+ny)] = true
        dfs(nx,ny+2,cnt+1,w)
        isVisited[Pair(false,nx-ny)] = false
        isVisited[Pair(true,nx+ny)] = false
    }

    dfs(nx,ny+2,cnt,w)
}

