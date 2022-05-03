// 2022-05-03
// www.acmicpc.net/problem/16234

import java.util.*

class Solution{

    var N =0
    var R =0
    var C =0
    val dx = intArrayOf(1,-1,0,0)
    val dy = intArrayOf(0,0,1,-1)
    lateinit var isVisited:Array<BooleanArray>
    lateinit var list:Array<MutableList<Int>>
    fun solution(n:Int, r:Int, c:Int, _list:Array<List<Int>>):Int{
        N = n
        R = r
        C = c
        list = Array(n){ _list[it].toMutableList() }

        var isMoved = false
        var answer =0
        while(true){

            isVisited = Array(N){BooleanArray(N)}
            for(i in 0 until N){
                for(j in 0 until N){
                    if(bfs(i,j)) isMoved=true
                }
            }

            if(isMoved.not()) break
            else isMoved = false
            answer ++
        }
        return answer
    }

    fun bfs(r:Int, c:Int):Boolean{
        if(isVisited[r][c]) return false
        val queue = ArrayDeque<Pair<Int,Int>>()
        isVisited[r][c]=true
        queue.addFirst(Pair(r,c))
        var re = false
        var total = 0
        var num = 0
        val saveList = mutableListOf<Pair<Int,Int>>()

        while(queue.isEmpty().not()){
            val (curX, curY) = queue.removeLast()
            saveList.add(Pair(curX,curY))
            total+=list[curX][curY]
            num++
            for(i in 0..3){
                val nx = dx[i] + curX
                val ny = dy[i] + curY

                if((nx in 0 until N && ny in 0 until N).not() ) continue
                if(isVisited[nx][ny]) continue
                if(Math.abs( list[curX][curY] - list[nx][ny] ) in R..C ){
                    isVisited[nx][ny]=true
                    queue.addFirst(Pair(nx,ny))
                    re=true
                }
            }
        }

        saveList.forEach {
            list[it.first][it.second] = total/num
        }

        return re
    }
}

fun main() {
    val nrc = readLine()!!.split(' ')
    val list = Array(nrc[0].toInt()){readLine()!!.split(' ').map{it.toInt()}}
    println(Solution().solution(nrc[0].toInt(), nrc[1].toInt(), nrc[2].toInt(), list))
}
