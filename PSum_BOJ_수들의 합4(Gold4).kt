// https://www.acmicpc.net/problem/2015
// 2023-05-22

fun main() {
    val s = Solution()

    val (n, k) = readln().split(' ').map { it.toInt() }
    val list = readln().split(' ').map { it.toInt() }

    println(s.solution(n, k, list))
}

class Solution {
    fun solution(n: Int, k: Int, list: List<Int>): Long {
        val pSum = IntArray(list.size + 1)
        for (i in 0..list.lastIndex) pSum[i + 1] = pSum[i] + list[i]
        val map = mutableMapOf<Int, Long>()

        var answer = 0L
        for (i in 1..list.size) {
            if (pSum[i] == k) {
                answer++
            }
            if (map[pSum[i] - k] != null) {
                answer += map[pSum[i] - k]!!
            }
            if (map[pSum[i]] != null) {
                map[pSum[i]] = map[pSum[i]]!! + 1L
            } else {
                map[pSum[i]] = 1L
            }
        }

        return answer
    }
}
