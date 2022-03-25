// 2022-03-25
// https://www.acmicpc.net/problem/15666

import java.io.*
import java.util.*
import kotlin.math.abs

var answer =0
var n =0
lateinit var list:List<Int>
lateinit var stack:Stack<Int>
lateinit var isVisited:BooleanArray

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val nm = readLine()
    n = nm.toInt()
    list = readLine().split(' ').map{it.toInt()}
    stack = Stack()
    isVisited = BooleanArray(n)
    n = list.size

    bt(0)
    println(answer)
}

fun bt(size:Int){
    if(size == n){
        val tmp = stack.toList()
        var i =0
        var ta = 0
        while(i<n-1){
            ta += abs(tmp[i]-tmp[i+1])
            i++
        }
        answer = maxOf(answer,ta)
        return
    }

    for(i in list.indices){
        if(isVisited[i]) continue
        isVisited[i] = true
        stack.add(list[i])
        bt(size+1)
        isVisited[i]= false
        stack.pop()
    }
}
