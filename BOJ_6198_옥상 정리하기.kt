// 2022-01-27
// https://www.acmicpc.net/problem/6198

import java.io.*
import java.util.*

data class Pair(val value:Long, var count:Long)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val stack = Stack<Long>()
    val arr = LongArray(n)
    var answer:Long =0


    stack.add(Long.MAX_VALUE)
    repeat(n){
        val now = readLine().toLong()
        while(stack.peek()<=now) stack.pop()
        answer += stack.size-1
        stack.add(now)
    }
    println(answer)
}
