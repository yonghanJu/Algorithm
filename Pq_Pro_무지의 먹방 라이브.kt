import java.util.PriorityQueue

fun main() {
    println(Solution().solution(intArrayOf(10, 2, 2, 3, 4, 10), 20))
}

class Solution {
    fun solution(food_times: IntArray, k: Long): Int {
        var count = 0L
        val pq = PriorityQueue(compareBy<Pair<Int, Int>> { it.second })
        food_times.forEachIndexed { idx, it ->
            pq.add(Pair(idx, it))
        }

        var sumTime = 0L
        while (pq.isEmpty().not()) {
            val tmp = mutableListOf<Pair<Int, Int>>()
            val peek = pq.peek()
            val size = pq.size
            while (pq.isEmpty().not() && peek.second == pq.peek().second) {
                val poll = pq.poll()
                tmp.add(poll)
            }
            if (k >= count + size * (peek.second - sumTime)) {
                count += size * (peek.second - sumTime)
                sumTime += peek.second - sumTime
            } else {
                tmp.forEach { pq.add(it) }
                break
            }
        }

        if (pq.isEmpty()) return -1

        val remainList = pq.toList().sortedBy { it.first }
        return remainList[((k - count) % remainList.size).toInt()].first + 1
    }
}
