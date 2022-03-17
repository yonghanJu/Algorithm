// 2022-03-17
// https://www.acmicpc.net/problem/2447

import java.io.*
import java.math.BigInteger

var n =0
lateinit var graph:Array<CharArray>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    graph = Array(n){CharArray(n){' '} }
    re(0,0,n)
    graph.forEach{ println(String(it)) }
}

fun re(x:Int, y:Int, size:Int){
    if(size==3){
        graph[x][y]='*'
        graph[x][y+1]='*'
        graph[x][y+2]='*'
        graph[x+1][y]='*'
        graph[x+2][y]='*'
        graph[x+1][y+2]='*'
        graph[x+2][y+1]='*'
        graph[x+2][y+2]='*'
        return
    }
    re(x,y,size/3)
    re(x,y+size/3,size/3)
    re(x,y+size/3+size/3,size/3)
    re(x+size/3,y,size/3)
    re(x+size/3+size/3,y,size/3)
    re(x+size/3,y+size/3+size/3,size/3)
    re(x+size/3+size/3,y+size/3,size/3)
    re(x+size/3+size/3,y+size/3+size/3,size/3)
}
