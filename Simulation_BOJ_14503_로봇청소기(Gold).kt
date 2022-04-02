// 2022-04-02
// https://www.acmicpc.net/problem/14503

import java.io.*
import java.util.*

var r =0
var c =0
var answer =0
var curX =0
var curY =0
var curD =0
val dx = intArrayOf(-1,0,1,0)
val dy = intArrayOf(0,1,0,-1)
lateinit var board:Array<IntArray>
fun main():Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val rc = readLine().split(' ')
    r = rc[0].toInt()
    c = rc[1].toInt()
    val xyd = readLine().split(' ')
    curX = xyd[0].toInt()
    curY = xyd[1].toInt()
    curD = xyd[2].toInt()
    board = Array(r){readLine().split(' ').map{it.toInt()}.toIntArray()}

    sol()
    println(answer)
}

fun sol(){
    one@while(true){
        //1
        if(board[curX][curY]==0){
            board[curX][curY]=-1
            answer++
        }

        //2.a,b
        for(i in 1..4){
            val nx = curX+dx[(curD-i+4)%4]
            val ny = curY+dy[(curD-i+4)%4]
            if(board[nx][ny] != 0 )continue
            curX = nx
            curY = ny
            curD = (curD-i+4)%4
            continue@one
        }

        //2.c,d
        curX += dx[(curD+2)%4]
        curY += dy[(curD+2)%4]
        if( board[curX][curY] == 1) break
    }
}
