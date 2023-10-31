import java.util.PriorityQueue

// https://www.acmicpc.net/problem/1202
// 2023-10-30

fun main() {
    val (n, k) = readln().split(' ').map { it.toInt() }
    val mvList = List(n) { readln().split(' ').map { it.toInt() } }.sortedBy { it[0] }
    val kList = List(k) { readln().toInt() }.sortedBy { it }
    var answer = 0L
    val pq = PriorityQueue(compareBy<Int> { -it })
    var idx = 0
    kList.forEach { kk ->
        while (idx < n && mvList[idx][0] <= kk) pq.add(mvList[idx++][1])
        answer += pq.poll()?.toLong() ?: 0L
    }
    println(answer)
}
