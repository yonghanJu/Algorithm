// 2022-02-10
// https://www.acmicpc.net/problem/5430

import java.io.*
import java.util.*


fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val sb = StringBuilder()

    outer@for(i in 0 until n){
        val op = readLine()
        val s = readLine()
        val str = readLine()
        val dq:Deque<Int> = ArrayDeque( if(str.length !=2) str.substring(1,str.length-1).split(','). map{ it.toInt()} else listOf())
        var dir = true
        for(c in op) {
            if (c == 'R') dir = !dir
            else if (dq.isEmpty()) {
                sb.append("error\n")
                continue@outer
            } else if (dir) dq.pollFirst() else dq.pollLast()

        }

        sb.append((if(!dir) dq.reversed() else dq).toString().replace(" ","")).append('\n')
    }

    print(sb)
}
