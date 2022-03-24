// 2022-03-24
// https://www.acmicpc.net/problem/15664

import java.io.*
import java.util.*

var n =0
var m =0
lateinit var list:List<Int>
lateinit var isVisited:BooleanArray
lateinit var map:HashMap<String,Boolean>
lateinit var answer: MutableList<String>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val nm = readLine().split(' ')
    n = nm[0].toInt()
    m = nm[1].toInt()
    map = HashMap()
    answer = mutableListOf()
    isVisited = BooleanArray(n)
    list = readLine().split(' ').map{it.toInt()}.sorted()

    bt(0,0)
    answer.forEach { println(it) }
}

fun bt(size:Int,idx:Int){
    if(size == m){
        val sb= StringBuilder()
        for(i in list.indices){
            if(isVisited[i]) sb.append(list[i]).append(' ')
        }
        val str = String(sb)
        map[str]?: answer.add(str)
        map[str] = true
        return
    } else if(idx == n) return

    for(i in idx until n){
        isVisited[i] = true
        bt(size+1, i+1)
        isVisited[i] = false
        bt(size, idx+1)
    }
}
