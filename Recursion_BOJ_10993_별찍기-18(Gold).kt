// 2022-03-17
// https://www.acmicpc.net/problem/10993

import java.io.*
import java.math.BigInteger
import kotlin.math.pow

var n =0
lateinit var graph:Array<CharArray>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()
    n = readLine().toInt()
    val ls = 2.0.pow(n).toInt()-1
    graph = Array(ls){CharArray(ls*2-1){' '} }
    re(0,(ls*2-1)/2,n)

    // trimEnd() 함수를 통해 오른쪽 공백을 없에야 출력 형식이 맞습니다!! 조심할 것
    for(i in graph.indices){
        sb.append(String(graph[i]).trimEnd())
        if(i!=graph.lastIndex)sb.append('\n')
    }
    println(sb)
}

fun re(x:Int, y:Int, size:Int){
    if(size ==1) {
        graph[x][y] = '*'
        return
    }
    val ls = 2.0.pow(size).toInt()-1
    if(size%2==0){
        for(i in 0 until ls){
            graph[x][y+i]='*'
            graph[x][y-i]='*'
            graph[x+ls-1-i][y-i] = '*'
            graph[x+ls-1-i][y+i] = '*'
        }
        re(x+1, y, size-1)
    }else{
        for(i in 0 until ls){
            graph[x+i][y-i] = '*'
            graph[x+i][y+i] = '*'
            graph[x+ls-1][y+i] ='*'
            graph[x+ls-1][y-i] ='*'
        }
        re(x+2.0.pow(size-1).toInt()-1,y,size-1)
    }
}
