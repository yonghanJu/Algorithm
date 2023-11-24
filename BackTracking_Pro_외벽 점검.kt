class Solution {
    var answer = Int.MAX_VALUE
    val answerMap = mutableMapOf<Set<Int>, Int>()

    fun solution(n: Int, weak: IntArray, dist: IntArray): Int {
        dfs(0, weak.toSet(), dist.sortedBy { -it }, n)

        return if (answer == Int.MAX_VALUE) -1 else answer
    }

    fun dfs(distIndex: Int, remainWeaks: Set<Int>, dist: List<Int>, n: Int) {
        if ((answerMap[remainWeaks] ?: Int.MAX_VALUE) <= distIndex) return
        answerMap[remainWeaks] = distIndex

        if (remainWeaks.isEmpty()) {
            answer = minOf(distIndex, answer)
            return
        }
        if (distIndex == dist.size) {
            return
        }

        remainWeaks.forEach { startIndex ->
            val endIndex = startIndex + dist[distIndex]

            val remain = if (endIndex >= n) {
                remainWeaks.filter { (it in (startIndex until n) || it in (0..endIndex - n)).not() }.toSet()
            } else {
                remainWeaks.filter { (it in (startIndex..endIndex)).not() }.toSet()
            }
            dfs(distIndex + 1, remain, dist, n)
        }
        dfs(distIndex + 1, remainWeaks, dist, n)
    }
}
