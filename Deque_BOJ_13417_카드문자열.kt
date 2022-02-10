// 2022-02-10
// https://www.acmicpc.net/problem/13417

import java.io.*
import java.util.*


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val sb = StringBuilder()

    repeat(n){
        val size = readLine().toInt()
        val arr = readLine().split(' ')
        val dq:Deque<Char> = ArrayDeque()

        repeat(size){
            val c= arr[it][0]
            if(dq.isEmpty()) dq.addFirst(c)
            else{
                if( c> dq.peekFirst()) dq.addLast(c)
                else dq.addFirst(c)
            }
        }

        sb.append(dq.toCharArray()).append('\n')
    }

    print(sb)
}
