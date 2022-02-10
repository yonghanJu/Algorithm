// 2022-02-10
// https://www.acmicpc.net/problem/3986

import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    var answer =0

    repeat(n){
        val str = readLine()
        val stack = Stack<Char>()

        for(c in str){
            when(c){
                'A' -> if(!stack.isEmpty() && stack.peek()=='A') stack.pop() else stack.add('A')
                'B' -> if(!stack.isEmpty() && stack.peek()=='B') stack.pop() else stack.add('B')
            }
        }
        if(stack.empty()) answer++

    }
    print(answer)
}
