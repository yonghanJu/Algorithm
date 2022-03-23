// 2022-03-23
// https://www.acmicpc.net/problem/15663

import java.io.*
import java.util.*

var n =0
var m =0
lateinit var list:List<Int>
lateinit var set:MutableList<String>
lateinit var map:HashMap<String,Boolean>
lateinit var stack:Stack<Int>
lateinit var isVisited:BooleanArray

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val nm = readLine().split(' ')
    n = nm[0].toInt()
    m = nm[1].toInt()
    list = readLine().split(' ').map{it.toInt()}.sorted()
    set = mutableListOf()
    map = HashMap()
    stack = Stack()
    isVisited = BooleanArray(n)

    bt(0,0)
    set.forEach{ println(it) }
}

fun bt(size:Int,idx:Int){
    if(size == m) {
        val sb = StringBuilder()
        stack.forEach { sb.append(it).append(' ') }
        if(map[String(sb)]==null){
            set.add(String(sb))
            map[String(sb)]=true
        }
        return
    }else if(idx == n) return

    for(i in 0 until n){
        if(isVisited[i].not()){
            isVisited[i]=true
            stack.add(list[i])
            bt(size+1,i)
            isVisited[i]=false
            stack.pop()
        }
    }
}
