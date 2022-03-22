// 2022-03-22
// https://www.acmicpc.net/problem/15654

import java.io.*
import java.util.*

var n =0
var m =0
var answer =0

lateinit var list:List<Int>
lateinit var isVisited:BooleanArray
lateinit var sb:StringBuilder
lateinit var stack:Stack<Int>
lateinit var answerList: MutableList<String>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(' ')

    answerList = mutableListOf()
    stack = Stack()
    n = N.toInt()
    m = M.toInt()

    list = readLine().split(' ').map{it.toInt()}.sorted()
    isVisited = BooleanArray(n)

    bt(0)
    answerList.forEach { println(it) }
}

fun bt(size:Int){
    if(size == m){
        sb = java.lang.StringBuilder()
        stack.forEach { sb.append(list[it]).append(' ') }
        answerList.add(String(sb))
        return
    }

    for(i in list.indices){
        if(isVisited[i].not()){
            isVisited[i] = true
            stack.add(i)
            bt(size+1)
            stack.pop()
            isVisited[i] = false
        }
    }
}
