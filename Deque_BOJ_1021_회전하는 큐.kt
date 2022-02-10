// 2022-02-09
// https://www.acmicpc.net/problem/10866

import java.io.*
import java.util.*


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var (n, m) = readLine().split(' ').map { it.toInt() }
    val dq:Deque<Int> = LinkedList((1..n).toList())
    val arr = readLine().split(' ').map{it.toInt()}
    var answer =0

    for( i in arr ){
        if(dq.indexOf(i) <= n/2) {
            while(dq.peekFirst()!=i) dq.addLast(dq.pollFirst()).run{answer++}
            dq.pollFirst()
        }else{
            while(dq.peekFirst()!=i) dq.addFirst(dq.pollLast()).run{answer++}
            dq.pollFirst()
        }
        n--
    }
    println(answer)
}
