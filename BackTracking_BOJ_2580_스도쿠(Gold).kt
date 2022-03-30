// 2022-03-29
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

    dfs(0)
}

fun dfs(size:Int):Boolean{
    if(size == list.size){
        val sb = StringBuilder()
        board.forEach { l->
            l.forEach { sb.append(it).append(' ') }
            sb.append('\n')
        }
        print(sb)
        return true
    }

    for(i in possibleNum[0][list[size].first].toList()){
        for(j in possibleNum[1][list[size].second].toList()){
            for(k in possibleNum[2][(list[size].first/3)*3+(list[size].second/3)].toList()) {
                if(i==j && j==k){
                    possibleNum[0][list[size].first].remove(i)
                    possibleNum[1][list[size].second].remove(i)
                    possibleNum[2][(list[size].first/3)*3+(list[size].second/3)].remove(i)
                    board[list[size].first][list[size].second] = i

                    if(dfs(size+1)) return true

                    possibleNum[0][list[size].first].add(i)
                    possibleNum[1][list[size].second].add(i)
                    possibleNum[2][(list[size].first/3)*3+(list[size].second/3)].add(i)
                }
            }
        }
    }

    return false
}
