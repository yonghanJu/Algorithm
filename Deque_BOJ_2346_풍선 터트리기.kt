// 2022-02-10
// https://www.acmicpc.net/problem/2346

import java.io.*
import java.util.*


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val token = StringTokenizer(readLine())
    val dq:Deque<Pair<Int,Int>> = ArrayDeque()
    repeat(n) {dq.add(Pair(it+1,token.nextToken().toInt()))}
    val sb = StringBuilder()

    repeat(n){
        val num = dq.pollFirst()
        sb.append(num.first).append(' ')
        if(dq.isEmpty()) print(sb).run {  return}
        if(num.second>0) repeat(num.second-1) {dq.addLast(dq.pollFirst())}
        else repeat(-num.second) {dq.addFirst(dq.pollLast())}
    }
}
