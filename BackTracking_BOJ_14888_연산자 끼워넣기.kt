// 2022-03-26
// https://www.acmicpc.net/problem/14888

import java.io.*
import java.util.*

var n =0
var max = Int.MIN_VALUE
var min = Int.MAX_VALUE
lateinit var stack:Stack<Int>
lateinit var numList:List<Int>
lateinit var opList:IntArray
fun main():Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    numList = readLine().split(' ').map{it.toInt()}
    opList = readLine().split(' ').map{it.toInt()}.toIntArray()
    stack = Stack()

    dfs(0)
    println(max)
    println(min)
}

fun dfs(opCnt:Int){
    if(opCnt==n-1){
        var value = numList[0]
        stack.forEachIndexed{ idx,it->
            when(it){
                0-> value += numList[idx+1]
                1-> value -= numList[idx+1]
                2-> value *= numList[idx+1]
                3-> value /= numList[idx+1]
            }
        }
        max = maxOf(max, value)
        min = minOf(min, value)
    }

    for(i in 0..3){
        if(opList[i]>0){
            opList[i]--
            stack.add(i)
            dfs(opCnt+1)
            stack.pop()
            opList[i]++
        }
    }
}
