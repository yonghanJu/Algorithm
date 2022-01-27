// 2022-01-27
// https://www.acmicpc.net/problem/2493

import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    readLine()
    val sb = StringBuilder()
    val stack = Stack<Pair<Int,Int>>()

    readLine().split(" ").mapIndexed{ index, s -> Pair(index+1,s.toInt()) }.forEach{
        while(!stack.empty() && stack.peek().second < it.second) stack.pop()
        if(stack.isEmpty()) sb.append("0 ")
        else sb.append("${stack.peek().first} ")
        stack.add(it)
    }
    print(sb)
}
