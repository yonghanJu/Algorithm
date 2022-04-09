// 2022-04-09
// https://www.acmicpc.net/problem/12094

import java.io.*
import java.util.*

var answer =0
var n =0
fun main():Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    val board = Array(n){readLine().split(' ').map{it.toInt()}.toIntArray()}
    var max =0
    for(i in 0 until n){
        for( j in 0 until n){
            max = maxOf(board[i][j], max)
        }
    }
    dfs(0,max, board)
    println(answer)
}

fun dfs(cnt:Int,max:Int, board:Array<IntArray>){
    if(cnt == 10){
        answer = maxOf(max,answer)
        return
    }
    var cMax = max
    var tmpBoard = Array(n){ board[it].clone() }
    // 좌
    for(i in 0 until n){
        var cur = 0
        var curM = 0
        for(j in 0 until n){
            if(tmpBoard[i][j]==0) continue
            if(j == cur){
                curM++
                continue
            }
            if(tmpBoard[i][j]==tmpBoard[i][cur]){
                tmpBoard[i][cur] *=2
                cMax = maxOf(cMax, tmpBoard[i][cur])
                tmpBoard[i][j]=0
                cur++
                curM = cur
            }else{
                cur =curM
                curM++
                if(curM-1==j) continue
                tmpBoard[i][curM-1]=tmpBoard[i][j]
                tmpBoard[i][j]=0
            }
        }
    }
    dfs(cnt+1,cMax, tmpBoard)

    cMax = max
    tmpBoard = Array(n){ board[it].clone() }
    // 우
    for(i in 0 until n){
        var cur = n-1
        var curM = n-1
        for(j in n-1 downTo 0){
            if(tmpBoard[i][j]==0) continue
            if(j == cur){
                curM--
                continue
            }
            if(tmpBoard[i][j]==tmpBoard[i][cur]){
                tmpBoard[i][cur] *=2
                cMax = maxOf(cMax, tmpBoard[i][cur])
                tmpBoard[i][j]=0
                cur--
                curM = cur
            }else{
                cur =curM
                curM--
                if(curM+1==j) continue
                tmpBoard[i][curM+1]=tmpBoard[i][j]
                tmpBoard[i][j]=0
            }
        }
    }

    dfs(cnt+1,cMax, tmpBoard)
    cMax = max

    tmpBoard = Array(n){ board[it].clone() }
    // 하
    for(i in 0 until n){
        var cur = n-1
        var curM = n-1
        for(j in n-1 downTo 0){
            if(tmpBoard[j][i]==0) continue
            if(j == cur){
                curM--
                continue
            }
            if(tmpBoard[j][i]==tmpBoard[cur][i]){
                tmpBoard[cur][i] *=2
                cMax = maxOf(cMax, tmpBoard[cur][i])
                tmpBoard[j][i]=0
                cur--
                curM = cur
            }else{
                cur =curM
                curM--
                if(curM+1==j) continue
                tmpBoard[curM+1][i]=tmpBoard[j][i]
                tmpBoard[j][i]=0
            }
        }
    }

    dfs(cnt+1,cMax, tmpBoard)

    cMax = max
    tmpBoard = Array(n){ board[it].clone() }
    // 상
    for(i in 0 until n){
        var cur = 0
        var curM = 0
        for(j in 0 until n){
            if(tmpBoard[j][i]==0) continue
            if(j == cur){
                curM++
                continue
            }
            if(tmpBoard[j][i]==tmpBoard[cur][i]){
                tmpBoard[cur][i] *=2
                cMax = maxOf(cMax, tmpBoard[cur][i])
                tmpBoard[j][i]=0
                cur++
                curM = cur
            }else{
                cur =curM
                curM++
                if(curM-1==j) continue
                tmpBoard[curM-1][i]=tmpBoard[j][i]
                tmpBoard[j][i]=0
            }
        }
    }
    dfs(cnt+1,cMax, tmpBoard)
}
