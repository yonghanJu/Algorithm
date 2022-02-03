// 2022-02-03
// https://www.acmicpc.net/problem/17425

import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val arr = IntArray(n)
    val sb = StringBuilder()
    var max =0

    repeat(n){
        val x = readLine().toInt()
        arr[it] = x
        max = if(max>x) max else x
    }

    val answerArr = LongArray(max+1){it.toLong()}

    for(i in 1..max){
        var j = 2
        while(j*i<=max){
            answerArr[i*j] = answerArr[(i*j)] +i
            j++
        }
    }

    for(i in 2..answerArr.lastIndex) answerArr[i] += answerArr[i-1]

    arr.forEach { sb.append(answerArr[it]).append('\n') }
    println(sb)
}
