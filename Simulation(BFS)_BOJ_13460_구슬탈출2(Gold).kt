// 2022-04-14
// https://www.acmicpc.net/problem/13460

import java.io.*
import java.util.*

var n =0
var m =0

val dx = intArrayOf(0,0,1,-1)
val dy = intArrayOf(1,-1,0,0)

data class Data(val rx:Int, val ry: Int, val bx:Int, val by: Int, val cnt:Int)

lateinit var board:Array<CharArray>
fun main():Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val nm= readLine().split(' ')
    n = nm[0].toInt()
    m = nm[1].toInt()

    var rX = 0
    var rY = 0
    var bX =0
    var bY =0
    board = Array(n){readLine().toCharArray()}
    for(i in 0 until n){
        for(j in 0 until m) {
            if(board[i][j]=='B'){
                bX=i
                bY=j
                board[i][j]='.'
            }else if(board[i][j]=='R'){
                rX=i
                rY=j
                board[i][j]='.'
            }
        }
    }

    println(dfs(0,rX,rY,bX,bY))
}

fun dfs(depth:Int,rx:Int,ry:Int,  bx:Int, by:Int):Int{

    val q = ArrayDeque<Data>()
    q.addFirst(Data(rx,ry,bx,by,0))
    val isVisited = Array(n){Array(m){Array(n){BooleanArray(m)} } }
    isVisited[rx][ry][bx][by]=true

    while(q.isEmpty().not()){

        val cur = q.removeLast()
        if(board[cur.bx][cur.by]=='O') continue
        if(board[cur.rx][cur.ry]=='O') {
            return cur.cnt
        }
        if(cur.cnt==10) continue

        for(dir in 0..3){ // 우, 좌, 하, 상
            var crx = cur.rx
            var cry = cur.ry
            var cbx = cur.bx
            var cby = cur.by

            var cr =0
            var cb =0
            while( board[crx + dx[dir]][cry+dy[dir]] != '#' && board[crx][cry]!='O'){
                cr++
                crx += dx[dir]
                cry += dy[dir]
            }
            while(board[ cbx+ dx[dir]][cby+dy[dir]] != '#' &&board[cbx][cby]!='O' ){
                cb++
                cbx += dx[dir]
                cby += dy[dir]
            }

            if(crx==cbx && cry==cby){
                if(board[crx][cry]=='O') continue
                else if(cr<cb){
                    cbx -= dx[dir]
                    cby -= dy[dir]
                }else{
                    crx -= dx[dir]
                    cry -= dy[dir]
                }
            }


            if(isVisited[crx][cry][cbx][cby]) continue
            isVisited[crx][cry][cbx][cby] = true
            q.addFirst(Data(crx,cry,cbx,cby,cur.cnt+1))
        }
    }

    return -1
}
