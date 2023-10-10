// https://www.acmicpc.net/problem/17144
// 2023-10-10

val dx = listOf(-1, 1, 0, 0)
val dy = listOf(0, 0, 1, -1)

fun main() {
    val rct = readln().split(' ').map { it.toInt() }
    var total = 0
    val table = List(rct[0]) { readln().split(' ').map { it.toInt() }.toIntArray().apply { total += sum() } }
    var t = 0
    var up = 0
    var down = 0
    for (i in 0 until rct[0]) {
        if (table[i][0] == -1) {
            up = i
            down = i + 1
            break
        }
    }

    while (t < rct[2]) {
        // 1
        val tmp = List(rct[0]) { IntArray(rct[1]) }
        for (i in table.indices) {
            for (j in table[0].indices) {
                if (table[i][j] > 0) {
                    var p = 0
                    for (d in 0..3) {
                        val nx = i + dx[d]
                        val ny = j + dy[d]
                        if (nx in table.indices && ny in table[0].indices && table[nx][ny] != -1) {
                            p++
                            tmp[nx][ny] += table[i][j] / 5
                        }
                    }
                    tmp[i][j] += table[i][j] - p * (table[i][j] / 5)
                }
            }
        }

        // 2
        // Up Cycle
        for (i in up - 1 downTo 0) tmp[i + 1][0] = tmp[i][0]
        for (j in 1 until rct[1]) tmp[0][j - 1] = tmp[0][j]
        for (i in 1..up) tmp[i - 1][rct[1] - 1] = tmp[i][rct[1] - 1]
        for (j in rct[1] - 2 downTo 0) tmp[up][j + 1] = tmp[up][j]

        // Down Cycle
        for (i in down + 1 until rct[0]) tmp[i - 1][0] = tmp[i][0]
        for (j in 1 until rct[1]) tmp[rct[0] - 1][j - 1] = tmp[rct[0] - 1][j]
        for (i in rct[0] - 2 downTo down) tmp[i + 1][rct[1] - 1] = tmp[i][rct[1] - 1]
        for (j in rct[1] - 2 downTo 0) tmp[down][j + 1] = tmp[down][j]
        tmp[up][0] = -1
        tmp[down][0] = -1
        tmp[up][1] = 0
        tmp[down][1] = 0
        deepCopy(tmp, table)
        t++
    }

    var answer = 0
    table.forEach {
        // println(it.toList() + "${it.sum()}")
        answer += it.sum()
    }
    println(answer + 2)
}

fun deepCopy(from: List<IntArray>, to: List<IntArray>) {
    for (i in from.indices) {
        for (j in from[0].indices) {
            to[i][j] = from[i][j]
        }
    }
}
