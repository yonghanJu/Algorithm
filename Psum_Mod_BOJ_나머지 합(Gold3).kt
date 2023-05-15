// https://www.acmicpc.net/problem/10986
// 2023-05-15

fun main() {
    val s = Solution()
    println(s.solution())
}

class Solution {
    fun solution(): Long {
        val (n, m) = readln().split(' ').map { it.toInt() }
        val count = LongArray(m)
        val list = readln().split(' ').map { it.toInt() % m }
        val pSum = IntArray(n)
        pSum[0] = list[0]
        count[pSum[0] % m]++
        for (i in 1..list.lastIndex) {
            pSum[i] = ((pSum[i - 1] % m) + (list[i] % m)) % m
            count[pSum[i]]++
        }

        var answer: Long = count[0]
        for (i in 0 until m) {
            answer += (count[i] * (count[i] - 1)) / 2
        }

        return answer
    }
}
