import java.lang.StringBuilder
import kotlin.math.abs

// https://www.acmicpc.net/problem/2618
// 2023-09-13

fun main() {
    val s = Solution()
    s.solution(readln().toInt(), List(readln().toInt()) { readln().split(' ').map { it.toInt() } })
}

class Solution {
    private var w = 0
    private var n = 0
    private lateinit var cache: List<IntArray>
    private lateinit var wList: List<List<Int>>
    fun solution(nn: Int, list: List<List<Int>>) {
        n = nn
        wList = list
        w = list.size
        cache = List(w + 1) { IntArray(w + 1) { -1 } }

        println(minCost(0, 0))
        println(tracePath())
    }

    private fun minCost(w1: Int, w2: Int): Int {
        val next = maxOf(w1, w2) + 1
        if (next > w) return 0

        if (cache[w1][w2] >= 0) return cache[w1][w2]

        cache[w1][w2] = minOf(dist(w1, next) + minCost(next, w2), dist(next, w2) + minCost(w1, next))

        return cache[w1][w2]
    }

    private fun dist(p1: Int, p2: Int): Int {
        val x1 = if (p1 == 0) 1 else wList[p1 - 1][0]
        val y1 = if (p1 == 0) 1 else wList[p1 - 1][1]
        val x2 = if (p2 == 0) n else wList[p2 - 1][0]
        val y2 = if (p2 == 0) n else wList[p2 - 1][1]
        return abs(x1 - x2) + abs(y1 - y2)
    }

    private fun tracePath(): StringBuilder {
        val sb = StringBuilder()
        var p1 = 0
        var p2 = 0
        var next = 1
        while (next <= w) {
            val c1 = dist(p1, next) + cache[next][p2]
            val c2 = dist(next, p2) + cache[p1][next]

            if (c1 < c2) {
                p1 = next
                sb.append('1')
                sb.append('\n')
            } else {
                p2 = next
                sb.append('2')
                sb.append('\n')
            }
            next++
        }

        return sb
    }
}
