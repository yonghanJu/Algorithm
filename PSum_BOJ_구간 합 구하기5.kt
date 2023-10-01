// https://www.acmicpc.net/problem/11660
// 2023-10-01

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val met = List(n) { readln().split(' ').map { it.toInt() } }
    val boxes = List(m) { readln().split(' ').map { it.toInt() } }

    val pSum = List(n + 1) { MutableList(n + 1) { 0 } }
    for (i in met.indices) {
        for (j in met[0].indices) {
            pSum[i + 1][j + 1] = pSum[i][j + 1] + pSum[i + 1][j] - pSum[i][j] + met[i][j]
        }
    }

    val sb = StringBuilder()
    for ((x1, y1, x2, y2) in boxes) {
        sb.append(pSum[x2][y2] - pSum[x1 - 1][y2] - pSum[x2][y1 - 1] + pSum[x1 - 1][y1 - 1])
        sb.append('\n')
    }

    println(sb)
}
