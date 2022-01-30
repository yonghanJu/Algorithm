// 2022-01-29
// https://www.acmicpc.net/problem/1158

import java.io.*
import java.util.*

data class Pair(val height:Int, var width:Int)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {


    val nk = readLine().split(' ').map { it.toInt() }
    val answer = IntArray(nk[0])
    val queue:Queue<Int> = LinkedList((1..nk[0]).toList())
    var index =0
    while(!queue.isEmpty()){
        repeat(nk[1]-1) {queue.add(queue.poll())}
        answer[index++] = queue.poll()
    }
    val tmp =answer.toList().toString()
    print('<'+tmp.substring(1,tmp.length-1)+'>')
}
