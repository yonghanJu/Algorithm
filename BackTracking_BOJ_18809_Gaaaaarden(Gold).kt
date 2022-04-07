// 2022-04-07
// https://www.acmicpc.net/problem/18809

import java.io.*
import java.util.*

var answer = 0
var n = 0
var m = 0
var g = 0
var r = 0
val dx = intArrayOf(0,0,1,-1)
val dy = intArrayOf(1,-1,0,0)
lateinit var listR: Stack<Pair<Int,Int>>
lateinit var listG: Stack<Pair<Int,Int>>
lateinit var list: MutableList<Pair<Int,Int>>
lateinit var garden: Array<IntArray>
fun main():Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val nm = readLine().split(' ')
    n = nm[0].toInt()
    m=nm[1].toInt()
    g=nm[2].toInt()
    r = nm[3].toInt()
    garden = Array(n){readLine().split(' ').map{it.toInt()}.toIntArray()}
    listR = Stack()
    listG = Stack()
    list= mutableListOf()
    for(i in 0 until n){
        for( j in 0 until m) if(garden[i][j]==2){
            list.add(Pair(i,j))
        }
    }

    bt(0)
    print(answer)
}

fun bt(idx:Int){
    if(g==0 && r ==0){
        bfs()
        return
    }

    for(i in idx..list.lastIndex){
        if(g>0){
            g--
            listG.add(Pair(list[i].first,list[i].second))
            bt(i+1)
            listG.pop()
            g++
        }
        if(r>0){
            r--
            listR.add(Pair(list[i].first,list[i].second))
            bt(i+1)
            listR.pop()
            r++
        }
    }
}


data class Data(val x:Int, val y :Int, val cnt:Int, val color:Int)

fun bfs(){
    var count =0
    val q = ArrayDeque<Data>()
    val isVisited = Array(2){Array(n){IntArray(m)}}
    val flower = Array(n){BooleanArray(m)}
    listG.forEach {
        q.addFirst(Data(it.first,it.second,1,0))
        isVisited[0][it.first][it.second]=1
    }
    listR.forEach {
        q.addFirst(Data(it.first,it.second,1,1))
        isVisited[1][it.first][it.second]=1
    }

    while(q.isEmpty().not()){
        val (x,y,cnt,color) = q.removeLast()
        if(isVisited[(color+1)%2][x][y] == isVisited[color][x][y]){
            if(flower[x][y].not())count++
            flower[x][y]=true
            continue
        }

        for(i in 0..3){
            val nx = x+dx[i]
            val ny = y+dy[i]

            if((nx in garden.indices && ny in garden[0].indices).not()) continue
            if(garden[nx][ny] == 0 || isVisited[color][nx][ny] != 0) continue

            isVisited[color][nx][ny]=cnt+1

            q.addFirst(Data(nx,ny,cnt+1,color))
        }
    }
    answer = maxOf(answer,count)
}
