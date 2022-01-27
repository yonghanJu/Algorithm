// 2022-01-27
// https://www.acmicpc.net/problem/9012

import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val n = readLine().toInt()

    outer@for(i in 0 until n){

        val stack = Stack<Char>()

        val str = readLine()
        for(c in str){
            if(c == '(') stack.push(c)
            else if(stack.size > 0 && stack.peek()=='(') stack.pop()
            else {
                bw.write("NO\n")
                continue@outer
            }
        }

        if(stack.size == 0) bw.write("YES\n") else bw.write("NO\n")
    }
    bw.flush()
    bw.close()
}
