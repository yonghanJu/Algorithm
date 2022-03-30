// 2022-03-30
// https://www.acmicpc.net/problem/2580

import java.io.*
import java.util.*

lateinit var board:Array<IntArray>
lateinit var possibleNum:Array<Array<MutableList<Int>>>
lateinit var list:MutableList<Pair<Int,Int>>
fun main():Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    board = Array(9){readLine().split(' ').map{it.toInt()}.toIntArray()}
    possibleNum = Array(3){Array(9){ mutableListOf(1,2,3,4,5,6,7,8,9)}}
    list = mutableListOf()

    for(i in 0..8){
       for(j in 0..8){
           if(board[i][j]==0) list.add(Pair(i,j))
           else{
               possibleNum[0][i].remove(board[i][j])
               possibleNum[1][j].remove(board[i][j])
               possibleNum[2][(i/3)*3+(j/3)].remove(board[i][j])
           }
       }
    }

    dfs(0,0)
}

fun dfs(x:Int, y:Int):Boolean{
    var curX = x
    var curY = y
    if(y==9){
        curX++
        curY=0
    }
    if(curX==9){
        val sb = StringBuilder()
        board.forEach { l->
            l.forEach { sb.append(it).append(' ') }
            sb.append('\n')
        }
        print(sb)
        return true
    }

    if(board[curX][curY] != 0) return dfs(curX,curY+1)

    for( n in 1..9){
        if(check(curX,curY,n).not()) continue
        board[curX][curY]=n
        if(dfs(curX, curY+1)) return true
        board[curX][curY]=0
    }
    return false
}

fun check(x:Int,y:Int,num:Int):Boolean{
    for(i in 0..8) if(board[x][i]==num || board[i][y]==num) return false
    for(i in (x/3)*3..(x/3)*3+2){
        for(j in (y/3)*3..(y/3)*3+2) if(board[i][j]==num) return false
    }
    return true
}
