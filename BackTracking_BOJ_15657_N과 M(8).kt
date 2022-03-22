// 2022-03-22
// https://www.acmicpc.net/problem/15657

import java.io.*
import java.util.*

var n =0
var m =0
var answer =0

lateinit var list:List<Int>
lateinit var stack:Stack<Int>
lateinit var sb:StringBuilder

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N,M) = readLine().split(' ')
    n = N.toInt()
    m = M.toInt()
    list = readLine().split(' ').map{it.toInt()}.sorted()
    stack = Stack()
    sb = StringBuilder()

    bt(0, 0)
    println(sb)
}

fun bt(size:Int, start:Int){
    if(size == m) {
        stack.forEach { sb.append(list[it]).append(' ')}
        sb.append('\n')
        return
    }

    for(i in start .. list.lastIndex){
        stack.add(i)
        bt(size+1, i)
        stack.pop()
    }
}
