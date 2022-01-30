// 2022-01-30
// https://www.acmicpc.net/problem/3078

import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val nk = readLine().split(' ')
    val k = nk[1].toInt()
    var size = 0
    val queue:Queue<Int> = LinkedList()
    val list = IntArray(21){0}
    var answer:Long =0

    repeat(nk[0].toInt()){ // 루프 시작
        val length = readLine().length // 글자 수
        if(size > k){ // 큐 사이즈가 k 보다 길면
            list[queue.poll()] -=1
            size--
        }
        answer += list[length] // 쌍 개수 추가
        queue.add(length)
        list[length] +=1
        size++
    }
    println(answer)
}
