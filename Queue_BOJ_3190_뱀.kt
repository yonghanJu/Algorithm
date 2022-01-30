// 2022-01-30
// https://www.acmicpc.net/problem/3190

import java.io.*
import java.util.*

data class Pair(val row:Int, val col:Int)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val r = arrayOf(0,1,0,-1)
    val c = arrayOf(1,0,-1,0) // 동,남,서,북

    var curR = 1
    var curC = 1
    var curDir = 0
    val snake:Queue<Pair> = LinkedList()
    var time =0
    val n = readLine().toInt() // 보드 크기

    // 0=기본, 1=현재, 2=사과
    val board = Array(n+2){IntArray(n+2){0} }
    val k = readLine().toInt() // 사과 개수
    repeat(k){
        val app = readLine().split(' ')
        board[app[0].toInt()][app[1].toInt()] = 2
    }

    val l = readLine().toInt() // 이동횟수


    repeat(n+2){
        board[0][it] = 1
        board[n+1][it] = 1
        board[it][0] = 1
        board[it][n+1] = 1
    }

    board[1][1] = 1
    snake.add(Pair(1,1))
    repeat(l){
        val info = readLine().split(' ')
        while(time!=info[0].toInt()){
            if(board[curR+r[curDir]][curC+c[curDir]] == 1){
                print(time+1)
                return
            }
            snake.add(Pair(curR+r[curDir], curC+c[curDir]))
            time++
            if(board[curR+r[curDir]][curC+c[curDir]] == 0){
                board[snake.peek().row][snake.peek().col] = 0
                snake.poll()
            }
            board[curR+r[curDir]][curC+c[curDir]] = 1
            curR += r[curDir]
            curC += c[curDir]
        }
        // 방향전환
        curDir = if(info[1] == "L") ((curDir+4)-1)%4 else ((curDir+4)+1)%4
    }
