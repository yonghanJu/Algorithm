// 2022-01-29
// https://www.acmicpc.net/problem/1966

import java.io.*
import java.util.*

data class Pair(val value:Int, val index:Int)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n =readLine().toInt()
    val arr = IntArray(n)

    repeat(n){
        var answer =0
        val target = readLine().split(' ')[1].toInt()
        var list = readLine().split(' ').map { i->i.toInt() }.toMutableList()
        val queue:Queue<Pair> = LinkedList(list.mapIndexed{index,i-> Pair(i,index)})
        list.sort()
        while (!(queue.peek().value == list.last() && queue.peek().index == target)){
            if(queue.peek().value == list.last()) {
                queue.poll()
                answer ++
                list.removeAt(list.lastIndex)
            }else queue.add(queue.poll())

        }
        arr[it] = ++answer
    }

    arr.forEach { println(it) }
}
