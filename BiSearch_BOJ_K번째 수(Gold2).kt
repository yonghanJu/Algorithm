// https://www.acmicpc.net/problem/2015
// 2023-05-23

fun main() {
    val s = Solution()

    val n = readln().toInt()
    val k = readln().toInt()

    println(s.solution(n, k))
}

class Solution {
    fun solution(n: Int, k: Int): Int {
        var answer = 0

        var left = 1
        var right = k
        var point = (left + right) / 2
        while (left <= right) {
            var count = countSmallerNum(n, point)
            if (count >= k) {
                right = point - 1
            } else {
                left = point + 1
            }
            point = (left + right) / 2
        }

        return point + 1
    }

    private fun countSmallerNum(size: Int, n: Int): Int {
        var answer = 0
        for (i in 1..size) {
            answer += minOf(size, n / i)
        }
        return answer
    }
}
