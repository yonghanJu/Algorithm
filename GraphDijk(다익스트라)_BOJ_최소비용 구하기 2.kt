import java.lang.StringBuilder
import java.util.*

// https://www.acmicpc.net/problem/11779
// 2023-09-17

fun main() {
    val n = readln().toInt()
    val list = List(readln().toInt()) { readln().split(' ').map { it.toInt() } }
    val graph = List(n + 1) { mutableListOf<Pair<Int, Int>>() }.apply {
        list.forEach { info ->
            get(info[0]).add(Pair(info[1], info[2]))
        }
    }
    val (start, end) = readln().split(' ').map { it.toInt() }

    val pq = PriorityQueue<Info>(compareBy { it.cost })
    val dist = MutableList(n + 1) { Pair(-1, Int.MAX_VALUE) }.apply { set(start, Pair(0, 0)) } // Pair(from, cost)

    graph[start].forEach {
        pq.add(Info(it.first, start, it.second))
    }

    while (pq.isEmpty().not()) {
        // 방문
        val (cur, from, cost) = pq.poll()
        if (dist[cur].second != Int.MAX_VALUE) continue
        dist[cur] = Pair(from, cost)

        if (cur == end) {
            break
        }

        graph[cur].forEach { p ->
            if (dist[p.first].second == Int.MAX_VALUE) pq.add(Info(p.first, cur, p.second + cost))
        }
    }

    val sb = StringBuilder()
    sb.append("${dist[end].second}\n")
    var index = end
    val answerList = mutableListOf<Int>()
    while (index != 0) {
        answerList.add(index)
        index = dist[index].first
    }
    sb.append("${answerList.size}\n")
    for(i in answerList.lastIndex downTo 0) {
        sb.append(answerList[i])
        sb.append(' ')
    }
    println(sb)
}

data class Info(
    val cur: Int,
    val from: Int,
    val cost: Int,
)
