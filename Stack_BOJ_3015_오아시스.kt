// 2022-01-29
// https://www.acmicpc.net/problem/3015

import java.io.*
import java.util.*

data class Pair(val value:Int, var count:Int)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val stack = Stack<Pair>()
    val n = readLine().toInt()
    var answer:Long = 0

    repeat(n){
        val h = readLine().toInt()
        var dup= 1

        while (!stack.empty() && stack.peek().value <= h){
            val tmp = stack.pop()
            if(h == tmp.value) dup += tmp.count
            answer += tmp.count
        }

        if(!stack.empty())answer ++

        stack.add(Pair(h,dup))
    }

    print(answer)
}
