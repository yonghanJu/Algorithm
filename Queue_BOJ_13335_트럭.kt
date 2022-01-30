// 2022-01-29
// https://www.acmicpc.net/problem/13335

import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    var n = 0
    var w = 0
    var L = 0
    var curL = 0
    var answer = 0
    readLine().split(' ').run {
        n =get(0).toInt()
        w = get(1).toInt()
        L = get(2).toInt()
    }

    val queue:Queue<Int> = LinkedList(IntArray(w){0}.toList())
    val arr = readLine().split(' ').map { it.toInt() }
    repeat(n){
        var count =0

        while(curL-queue.peek()+arr[it] > L){
            curL -= queue.poll()
            count++
            answer++
        }
        repeat(count) {queue.add(0)}
        queue.add(arr[it])
        curL+=arr[it]
        curL -=queue.poll()
        answer++
    }

    print(answer+w)
}
