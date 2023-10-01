// https://www.acmicpc.net/problem/11659
// 2023-09-28

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val list = readln().split(' ').map { it.toLong() }
    val boundaries = List(m) { readln().split(' ').map { it.toInt() } }

    val pSum = MutableList(n + 1) { if (it == 0) 0 else list[it - 1] }

    for (i in 1..pSum.lastIndex) {
        pSum[i] = pSum[i - 1] + list[i - 1]
    }

    val sb = StringBuilder()
    for ((start, end) in boundaries) {
        sb.append(pSum[end] - pSum[start - 1])
        sb.append('\n')
    }
    println(sb)
}
