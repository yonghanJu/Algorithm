// 2022-04-12
// https://www.acmicpc.net/problem/11866

import java.io.*
import java.util.*

fun main():Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,k)= readLine().split(' ').map{it.toInt()}
    val deq = ArrayDeque<Int>()
    repeat(n){
        deq.addFirst(it+1)
    }
    val sb = StringBuilder("<")
    while(deq.isEmpty().not()){
        repeat(k-1){
            deq.addFirst(deq.removeLast())
        }
        sb.append(deq.removeLast())
        if(deq.isEmpty().not())sb.append(',').append(' ')
    }
    sb.append('>')
    println(sb)
}
