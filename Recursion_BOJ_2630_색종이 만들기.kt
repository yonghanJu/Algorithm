// 2022-03-14
// https://www.acmicpc.net/problem/2630

import java.io.*
import java.util.*

lateinit var sb:StringBuilder
lateinit var graph:Array<List<Int>>
var z =0
var o =0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    graph = Array(n){readLine().split(' ').map{it.toInt()}}

    re(0,0,n)
    println(z)
    println(o)
}

fun re(x:Int, y:Int, size:Int){
    var c =graph[x][y]
    for(i in x until x+size){
        for(j in y until y+size){
            if(c!=graph[i][j]){
                re(x,y,size/2)
                re(x+size/2,y,size/2)
                re(x,y+size/2,size/2)
                re(x+size/2, y+size/2,size/2)
                return
            }
        }
    }
    if(c==0) z ++ else o++
}
