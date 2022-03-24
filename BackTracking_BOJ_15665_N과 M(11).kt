// 2022-03-24
// https://www.acmicpc.net/problem/15665

import java.io.*
import java.util.*

var n =0
var m =0
lateinit var list:List<Int>
lateinit var map:HashMap<String,Boolean>
lateinit var stack:Stack<Int>
lateinit var answer: MutableList<String>
lateinit var isNot:BooleanArray

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val nm = readLine().split(' ')
    n = nm[0].toInt()
    m = nm[1].toInt()
    map = HashMap()
    answer = mutableListOf()
    stack = Stack()
    list = readLine().split(' ').map{it.toInt()}.toSortedSet().toList()
    n = list.size
    isNot = BooleanArray(n)
    bt(0,0)
    val sb =  StringBuilder()
    answer.forEach { sb.append(it).append('\n') }
    println(sb)
}

fun bt(size:Int,idx:Int){
    if(size == m){
        val sb = StringBuilder()
        stack.forEach { sb.append(it).append(' ') }
        val str = String(sb)
        map[str] ?: answer.add(str)
        map[str]= true
        return
    }
    if(idx == n) return
    for(i in 0 until n){
        stack.add(list[i])
        bt(size+1, i)
        stack.pop()
    }
}
