// 2022-04-04
// https://www.acmicpc.net/problem/16197

import java.io.*
import java.util.*

data class Data(val xC1:Int, val yC1:Int, val xC2:Int, val yC2:Int, val cnt:Int)

var answer = -1
var n =0
var m =0
val dx = intArrayOf(1,-1,0,0)
val dy = intArrayOf(0,0,1,-1)
lateinit var board:Array<CharArray>

fun main():Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val nm =readLine().split(' ')
    n = nm[0].toInt()
    m = nm[1].toInt()
    board = Array(n){readLine().toCharArray()}
    val list = intArrayOf(-1,-1,-1,-1)
    for(i in 0 until n){
        for(j in 0 until m){
            if(board[i][j]=='o'){
                if(list[0]==-1){
                    list[0]=i
                    list[1]=j
                }else{
                    list[2]=i
                    list[3]=j
                    break
                }
            }
        }
    }

    bfs(list)
    println(answer)
}

fun bfs(list:IntArray){
    val q = ArrayDeque<Data>()
    val isVisited = Array(n+2){Array(m+2){Array(n+2){BooleanArray(m+2)}}}
    q.addFirst(Data(list[0],list[1],list[2],list[3],0))
    isVisited[list[0]+1][list[1]+1][list[2]+1][list[3]+1]=true

    while(q.isEmpty().not()){
        var cc =0
        val cur = q.removeLast()
        if(cur.cnt>10) break
        
        if((cur.xC1 in board.indices && cur.yC1 in board[0].indices).not()) cc++
        if((cur.xC2 in board.indices && cur.yC2 in board[0].indices).not()) cc++
        if(cc==2) continue
        else if(cc==1){
            answer = cur.cnt
            break
        }

        for(i in 0..3){
            var nxc1 = cur.xC1+dx[i]
            var nxc2 = cur.xC2+dx[i]
            var nyc1 = cur.yC1+dy[i]
            var nyc2 = cur.yC2+dy[i]
            if(nxc1 in 0 until n && nyc1 in 0 until m && board[nxc1][nyc1] == '#' ) {
                nxc1 = cur.xC1
                nyc1 = cur.yC1
            }
            if(nxc2 in 0 until n && nyc2 in 0 until m &&board[nxc2][nyc2] == '#' ) {
                nxc2 = cur.xC2
                nyc2 = cur.yC2
            }
            if(nxc1==cur.xC1 && nxc2==cur.xC2 && nyc1==cur.yC1 && nyc2==cur.yC2 ) continue
            if(nxc1 == nxc2 && nyc1 == nyc2) continue
            if(isVisited[nxc1+1][nyc1+1][nxc2+1][nyc2+1]) continue
            q.addFirst(Data(nxc1,nyc1,nxc2,nyc2,cur.cnt+1))
        }
    }
}
