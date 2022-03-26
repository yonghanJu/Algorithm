// 2022-03-26
// https://www.acmicpc.net/problem/6603

import java.io.*
import java.util.*

var n = 0
lateinit var list:List<Int>
lateinit var isVisited:BooleanArray
val sb = StringBuilder()
fun main():Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    list = readLine().split(' ').map{it.toInt()}
    while(list.size != 1){
        isVisited = BooleanArray(50)
        bt(0,1)
        sb.append('\n')
        list = readLine().split(' ').map{it.toInt()}
    }
    println(sb)
}

fun bt(size:Int, idx:Int){
    if(size==6){
        isVisited.forEachIndexed{idx,it->
            if(it) sb.append(list[idx]).append(' ')
        }
        sb.append('\n')
        return
    }
    for(i in idx .. list.lastIndex){
        isVisited[i] = true
        bt(size+1,i+1)
        isVisited[i]=false
    }
}
