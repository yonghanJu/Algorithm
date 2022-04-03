// 2022-04-03
// https://www.acmicpc.net/problem/16236

import java.io.*
import java.util.*

data class Data(val x:Int, val y:Int, val cnt:Int)

var n =0
var sharkSize = 2
var eat = 0
var curX = 0
var curY = 0
var answer = 0
val dx = intArrayOf(-1,0,0,1)
val dy = intArrayOf(0,-1,1,0)

lateinit var board:Array<MutableList<Int>>

fun main():Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    board = Array(n){ mutableListOf() }
    repeat(n){it1->
        val st = StringTokenizer(readLine())
        repeat(n){it2->
            val c = st.nextToken().toInt()
            board[it1].add(c)
            if(c==9){
                curX = it1
                curY = it2
                board[curX][curY] = 0
            }
        }
    }

    while(bfs(curX,curY)){}
    println(answer)
}

fun bfs(startX:Int, startY:Int):Boolean{
    val q = ArrayDeque<Data>()
    val isVisited = Array(n){BooleanArray(n)}
    q.addFirst(Data(startX,startY,0))
    isVisited[startX][startY]=true

    while(q.isEmpty().not()){
        var cur = q.removeLast()

        if(board[cur.x][cur.y] in 1 until sharkSize){

            while(q.isEmpty().not()){
                val tmp = q.removeLast()
                if((cur.cnt == tmp.cnt && board[tmp.x][tmp.y]  in 1 until sharkSize).not()) continue
                if(tmp.x < cur.x) cur = tmp
                else if(tmp.x==cur.x && tmp.y < cur.y) cur = tmp
            }

            eat++
            board[cur.x][cur.y] = 0
            curX = cur.x
            curY = cur.y
            answer += cur.cnt
            if(eat==sharkSize){
                sharkSize++
                eat = 0
            }
            return true
        }

        for(i in 0..3){
            val nx = cur.x + dx[i]
            val ny = cur.y + dy[i]

            if((nx in 0 until n && ny in 0 until n).not()) continue
            if(isVisited[nx][ny]) continue
            if(board[nx][ny] > sharkSize) continue

            isVisited[nx][ny]=true
            q.addFirst(Data(nx,ny,cur.cnt+1))
        }
    }

    return false
}
