import java.util.*

// https://www.acmicpc.net/problem/17420
// 2023-10-23

val n = readln().toInt()
val gifts = readln().split(' ').map { it.toInt() }.toMutableList()
val plans = readln().split(' ').map { it.toInt() }
var answer = 0L

fun main() {
    val pq = PriorityQueue(compareBy<Triple<Int, Int, Int>> { it.third }.thenBy { it.second })
    for (idx in gifts.indices) {
        val it = gifts[idx]
        var ex = 0
        if (plans[idx] > gifts[idx]) {
            ex = (plans[idx] - gifts[idx]) / 30 + if((plans[idx] - gifts[idx]) % 30 == 0) 0 else 1
            answer += ex.toLong()
        }
        gifts[idx] = it + 30 * ex
        pq.add(Triple(idx, gifts[idx], plans[idx]))
    }
    var max = 0
    while (pq.isNotEmpty()) {
        var p = pq.poll()
        if (max > p.second) {
            val ex = (max - p.second) / 30 + if((max - p.second) % 30 == 0) 0 else 1
            answer += ex.toLong()
            p = p.copy(second = p.second + 30 * ex)
            pq.add(p)
        } else {
            max = p.second
        }
    }
    println(answer)
}
