// 2022-03-25
// https://www.acmicpc.net/problem/15666

import java.io.*
import java.util.*

var n =0
var m =0
lateinit var list:List<Int>
lateinit var stack:Stack<Int>
lateinit var answer: MutableList<String>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val nm = readLine().split(' ')
    n = nm[0].toInt()
    m = nm[1].toInt()
    list = readLine().split(' ').map{it.toInt()}.toSortedSet().toList()
    stack = Stack()
    answer = mutableListOf()
    n = list.size

    bt(0,0)
    val sb = StringBuilder()
    answer.forEach{sb.append(it).append('\n')}
    println(sb)
}

fun bt(size:Int, idx:Int){
    if(size == m){
        val sb = StringBuilder()
        stack.forEach { sb.append(it).append(' ') }
        answer.add(String(sb))
        return
    }
    if(idx == n) return

    for(i in idx .. list.lastIndex){
        stack.add(list[i])
        bt(size+1,i)
        stack.pop()
    }
}
