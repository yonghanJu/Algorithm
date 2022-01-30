// 2022-01-29
// https://www.acmicpc.net/problem/2164

import java.io.*
import java.util.*

fun main() = with(Scanner(System.`in`)) {

    val queue:Queue<Int> = LinkedList((1..nextInt()).toList())
    if(queue.size==1) print(1).apply { return }
    while(queue.size > 0){
        queue.poll()
        if (queue.size == 1){
            print(queue.peek())
            return
        }
        queue.add(queue.poll())
    }
}
