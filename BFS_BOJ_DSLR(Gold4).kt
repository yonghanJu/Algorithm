// https://www.acmicpc.net/problem/9019
// 2023-09-07

fun main() {
    val s = Solution()
    repeat(readln().toInt()) {
        val (n1, n2) = readln().split(' ').map { it.toInt() }
        s.solution(n1, n2)
    }
}

class Solution {
    fun solution(n1: Int, n2: Int) {
        val isVisited = BooleanArray(10000)
        val q = ArrayDeque<Pair<String, Int>>()
        isVisited[n1] = true
        q.addFirst(Pair("", n1))
        while (q.isNotEmpty()) {
            val (str, n) = q.removeLast()
            if (n == n2) {
                println(str)
                return
            }
            val d = d(n)
            val s = s(n)
            val l = l(n)
            val r = r(n)
            if(isVisited[d].not()) {
                q.addFirst(Pair(str + "D", d))
                isVisited[d] = true
            }
            if(isVisited[s].not()) {
                q.addFirst(Pair(str + "S", s))
                isVisited[s] = true
            }
            if(isVisited[l].not()) {
                q.addFirst(Pair(str + "L", l))
                isVisited[l] = true
            }
            if(isVisited[r].not()) {
                q.addFirst(Pair(str + "R", r))
                isVisited[r] = true
            }
        }
    }
}

fun d(a: Int): Int = if (a * 2 > 9999) (a * 2) % 10000 else a * 2

fun s(a: Int) = if (a == 0) 9999 else a - 1

fun l(a: Int): Int {
    val d1 = a / 1000
    val d2 = (a % 1000) / 100
    val d3 = (a % 100) / 10
    val d4 = a % 10
    return ((d2 * 10 + d3) * 10 + d4) * 10 + d1
}

fun r(a: Int): Int {
    val d1 = a / 1000
    val d2 = (a % 1000) / 100
    val d3 = (a % 100) / 10
    val d4 = a % 10
    return ((d4 * 10 + d1) * 10 + d2) * 10 + d3
}
