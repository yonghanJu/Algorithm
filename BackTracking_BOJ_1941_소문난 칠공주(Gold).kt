// 2022-03-31
// https://www.acmicpc.net/problem/1941

import java.io.*
import java.util.*

val dx = intArrayOf(1,-1,0,0)
val dy = intArrayOf(0,0,1,-1)
var answer =0
lateinit var board:Array<CharArray>
lateinit var isVisited:Array<BooleanArray>
lateinit var list:MutableList<Pair<Int,Int>>
lateinit var stack:Stack<Pair<Int,Int>>
lateinit var map:HashMap<Set<Pair<Int,Int>>,Boolean>
fun main():Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    board = Array(5){readLine().toCharArray()}
    isVisited= Array(5){BooleanArray(5)}
    list = mutableListOf()
    stack=Stack()
    map = HashMap()
    board.forEachIndexed{i,b->
        b.forEachIndexed{j,it->
            if(it=='S') list.add(Pair(i,j))
        }
    }
    dfs(0,0,0)
    println(answer)
}

fun dfs(idx:Int,size:Int,s:Int){
    isVisited[idx/5][idx%5]=true
    var ns = s
    if(size == 0 && board[idx/5][idx%5]=='S')ns++
    if(size==0){
        stack.add(Pair(idx/5,idx%5))
    }
    if(size == 6){
        if(s>3) {
            if(map[stack.toSet()]==null){
                answer++
            }
            map[stack.toSet()]=true
        }
        return
    }

    for(p in stack.toList()){
        for(i in 0..3){
            val nx = p.first+dx[i]
            val ny = p.second+dy[i]
            if((nx in 0..4 && ny in 0..4).not()) continue
            if(isVisited[nx][ny]) continue
            isVisited[nx][ny]=true
            stack.add(Pair(nx,ny))
            dfs(idx,size+1,if(board[nx][ny]=='S') ns+1 else ns)
            stack.pop()
            isVisited[nx][ny]=false
        }
    }

    if(size==0 && idx<24){
        stack.pop()
        dfs(idx+1,size,s)
    }
}
