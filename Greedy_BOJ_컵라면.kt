import java.util.*

// https://www.acmicpc.net/problem/1781
// 2023-10-29

val n = readln().toInt()
val input = List(n) { readln().split(' ').map { it.toInt() } }

fun main() {
    val pq = PriorityQueue(compareBy<List<Int>> { it[0] }.thenBy { -it[1] })
    val pqAns = PriorityQueue<Int>()
    input.forEach {
        pq.add(it)
    }
    var time = 0
    while (pq.isNotEmpty()) {
        val cur = pq.poll()
        if (time < cur.first()) {
            pqAns.add(cur[1])
            time++
        } else {
            if(pqAns.peek() < cur[1]) {
                pqAns.poll()
                pqAns.add(cur[1])
            }
        }
    }
    println(pqAns.sum())
}
