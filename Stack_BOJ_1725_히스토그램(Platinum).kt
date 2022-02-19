// 2022-01-29
// https://www.acmicpc.net/problem/1725

import java.io.*
import java.util.*

data class Pair(val height:Int, var width:Int)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    var answer = 0
    val stack = Stack<Pair>()

    repeat(n+1){
        val now = if(it != n) readLine().toInt() else 0
        var nowWidth = 1
        while(!stack.empty() && stack.peek().height > now){
            nowWidth += stack.peek().width
            answer = maxOf(stack.pop().height*(nowWidth-1), answer)
        }
        stack.add(Pair(now,nowWidth))
    }
    print(answer)
}
