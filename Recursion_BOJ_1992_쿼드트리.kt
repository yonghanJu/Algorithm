// 2022-03-16
// https://www.acmicpc.net/problem/1992

import java.io.*
import java.math.BigInteger

lateinit var graph:Array<CharArray>
lateinit var sb: StringBuilder
var n = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val rn = readLine().toInt()
    sb = StringBuilder()
    n = rn
    graph = Array(n){readLine().toCharArray()}

    re(0,0,n)
    println(sb)
}

fun re(x:Int, y:Int, n:Int){
    var cur = graph[x][y]
    for(i in x until x+n){
        for(j in y until y+n){
            if(cur!=graph[i][j]){
                sb.append('(')
                re(x,y,n/2)
                re(x,y+n/2,n/2)
                re(x+n/2,y,n/2)
                re(x+n/2,y+n/2,n/2)
                sb.append(')')
                return
            }
        }
    }
    sb.append(cur)
}
