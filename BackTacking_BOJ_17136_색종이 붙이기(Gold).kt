// 2022-04-06
// https://www.acmicpc.net/problem/17136

import java.io.*
import java.util.*
var cur =0
var answer = Int.MAX_VALUE
var paper =intArrayOf(0,5,5,5,5,5)
lateinit var board:Array<IntArray>
fun main():Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    board = Array(10){readLine().split(' ').map{it.toInt()}.toIntArray()}

    dfs(0,0)
    println(if(answer == Int.MAX_VALUE) -1 else answer)
}

fun dfs(x:Int, y:Int){
    var nx = x
    var ny = y+1
    if(ny==10){
        ny = 0
        nx++
    }

    if(x==10){
        answer = minOf(answer,cur)
        return
    }

    if(board[x][y]==0){
        dfs(nx,ny)
        return
    }

    for(s in 1..5){
        if(paper[s]==0) continue
        if(isSquare(x,y,s).not()) continue
        paper[s]--
        for(i in x until x+s){
            for(j in y until y+s){
                board[i][j]=0
            }
        }
        cur++
        dfs(nx,ny)
        cur--
        for(i in x until x+s){
            for(j in y until y+s){
                board[i][j]=1
            }
        }
        paper[s]++
    }
}

fun isSquare(x:Int, y:Int,size:Int):Boolean{
    if(x+size>10 || y+size > 10) return false
    for(i in x until x+size){
        for(j in y until y+size){
            if(board[i][j]==0) return false
        }
    }
    return true
}
