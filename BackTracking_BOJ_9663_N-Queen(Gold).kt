// 2022-03-26
// https://www.acmicpc.net/problem/9663

import java.io.*
import java.util.*
import kotlin.collections.HashMap

var n = 0
var answer =0
lateinit var table: Array<IntArray>
fun main():Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    table = Array(n){IntArray(n)}
    dfs(0)
    println(answer)
}

fun dfs(x:Int){
    if(x == n) {
        answer ++
        return
    }

    for(y in 0 until n){
        if(table[x][y] > 0) continue

        for(t in 1 until n-x){
            if(y+t<n) table[x+t][y+t]++
            if(y-t>=0)table[x+t][y-t]++
            table[x+t][y] ++
        }
        dfs(x+1)

        for(t in 1 until n-x){
            if(y+t<n)table[x+t][y+t] --
            if(y-t>=0)table[x+t][y-t] --
            table[x+t][y] --
        }
    }
}
