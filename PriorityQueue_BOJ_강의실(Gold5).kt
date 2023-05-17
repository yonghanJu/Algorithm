import java.util.*

// https://www.acmicpc.net/problem/1374
// 2023-05-17

fun main() {
    val s = Solution()
    println(s.solution())
}

class Solution {
    fun solution(): Int {
        val lectures = List(readln().toInt()) { readln().split(' ').map { it.toInt() } }.sortedBy { it[1] }

        var answer = 0
        val pq = PriorityQueue<List<Int>> { o1, o2 ->
            o1[2] - o2[2]
        }

        for (i in lectures.indices) {
            while(pq.isEmpty().not() && pq.peek()[2] <= lectures[i][1]) pq.poll()
            pq.add(lectures[i])
            answer = maxOf(answer, pq.size)
        }
        return answer
    }
}
