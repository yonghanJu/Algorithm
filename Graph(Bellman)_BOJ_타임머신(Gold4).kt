// https://www.acmicpc.net/problem/11657
// 2023-09-01

fun main() {
    val s = Solution()
    val (n, m) = readln().split(' ').map { it.toInt() }

    s.solution(n, List(m) { readln().split(' ').map { it.toInt() } })
}

class Solution {
    fun solution(n: Int, list: List<List<Int>>) {
        val dest = MutableList(n + 1) { Long.MAX_VALUE }.apply { set(1, 0) }
        val edges = List(n + 1) { mutableListOf<Pair<Int, Int>>() }
        list.forEach {
            edges[it[0]].add(Pair(it[1], it[2]))
        }

        var iter = 0
        while (iter < n) {
            val savedDest = dest.toList()

            for (node in 1..n) {
                edges[node].forEach { (to, cost) ->
                    if (dest[node] != Long.MAX_VALUE && dest[to] > dest[node] + cost) dest[to] = dest[node] + cost
                }
            }

            if (dest == savedDest) break
            iter++
        }

        if (iter == n) {
            println("-1")
        } else {
            dest.replaceAll {
                if (it == Long.MAX_VALUE) -1 else it
            }
            for (i in 2..n) {
                println(dest[i])
            }
        }
    }
}
