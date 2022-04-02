// 2022-04-02
// https://www.acmicpc.net/problem/14499

import java.io.*
import java.util.*

var r = 0
var c = 0
var x = 0
var y = 0
var imc = 0

val dx = intArrayOf(0,0,0,-1,1)
val dy = intArrayOf(0,1,-1,0,0)
lateinit var im:List<Int>
lateinit var board:List<IntArray>
fun main():Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val dices = Dices()
    val rc = readLine().split(' ').map{it.toInt()}
    var sb = StringBuilder()
    r = rc[0]
    c = rc[1]
    x = rc[2]
    y = rc[3]
    imc = rc[4]
    board = List(r){readLine().split(' ').map{it.toInt()}.toIntArray()}
    im = readLine().split(' ').map{it.toInt()}
    for(i in im){
        val nx = x+dx[i]
        val ny = y+dy[i]
        if((nx in 0 until r && ny in 0 until c).not()) continue
        x = nx
        y = ny
        dices.move(i)
        if(board[x][y]==0){
            board[x][y]= dices.back
        }else{
            dices.back = board[x][y]
            board[x][y]=0
        }

        sb.append(dices.front).append('\n')
    }
    println(sb)
}

class Dices(){

    var up = 0
    var down = 0
    var right = 0
    var left = 0
    var front = 0
    var back = 0

    fun move(dir:Int){
        val tmp= front
        when(dir){
            1->{
                front = left
                left = back
                back = right
                right = tmp
            }
            2->{
                front = right
                right = back
                back = left
                left = tmp
            }
            3->{
                front = down
                down = back
                back = up
                up = tmp
            }
            4->{
                front = up
                up = back
                back = down
                down = tmp
            }
        }
    }
}
