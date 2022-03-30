// 2022-03-29
// https://www.acmicpc.net/problem/1987

import java.io.*
import java.util.*

var r =0
var c =0
var answer = 0

val dx = intArrayOf(1,-1,0,0)
val dy = intArrayOf(0,0,1,-1)

lateinit var board:Array<CharArray>
lateinit var isVisited:BooleanArray
fun main():Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val rc = readLine().split(' ')
    r = rc[0].toInt()
    c = rc[1].toInt()

    board = Array(r){readLine().toCharArray()}
    isVisited=BooleanArray(26)
    isVisited[board[0][0]-'A']=true
    dfs(0,0,1)
    println(answer)
}

fun dfs(x:Int, y:Int, cnt:Int){
    for(i in 0..3){
        val nx = x+dx[i]
        val ny = y+dy[i]

        if((nx in board.indices && ny in board[0].indices).not()) continue
        if(isVisited[board[nx][ny]-'A']) continue
        isVisited[board[nx][ny]-'A']=true
        dfs(nx,ny,cnt+1)
        isVisited[board[nx][ny]-'A']=false
    }
    answer = maxOf(answer, cnt)
}
