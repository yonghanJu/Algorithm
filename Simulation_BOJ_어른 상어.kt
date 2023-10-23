// https://www.acmicpc.net/problem/19237
// 2023-10-22

val dx = listOf(0, -1, 1, 0, 0)
val dy = listOf(0, 0, 0, -1, 1)
val nmk = readln().split(' ').map { it.toInt() }
val initState = List(nmk[0]) { readln().split(' ').map { it.toInt() } }
val dirs = readln().split(' ').map { it.toInt() }
val dirPriority = listOf(listOf(listOf(-1))) + List(nmk[1]) {
    listOf(listOf(-1)) + List(4) {
        listOf(-1) + readln().split(' ').map { it.toInt() }
    }
}

fun main() {
    val (n, m, k) = nmk
    var t = 0
    val table = List(n) { MutableList(n) { Pair(0, 0) } }
    val positions = MutableList(m + 1) { Triple(-1, -1, -1) }
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (initState[i][j] > 0) {
                table[i][j] = Pair(initState[i][j], k)
                positions[initState[i][j]] = Triple(i, j, dirs[initState[i][j] - 1])
            }
        }
    }

    var count = 0
    while (t <= 1000 && count != 1) {
        // 상어 이동
        val isVisited = List(n) { BooleanArray(n) }
        for (i in 1..m) {
            val (x, y, dir) = positions[i]
            if (x == -1) continue

            var move = false
            var (tmpX, tmpY, tmpD) = listOf(-1, -1, -1)
            for (j in 1..4) {
                val d = dirPriority[i][dir][j]
                val nx = x + dx[d]
                val ny = y + dy[d]
                if (nx in 0 until n && ny in 0 until n) {
                    if (tmpX == -1 && table[nx][ny].first == i) {
                        tmpX = nx
                        tmpY = ny
                        tmpD = d
                    }
                    if (table[nx][ny].second <= 0) {
                        positions[i] = Triple(nx, ny, d)
                        move = true
                        break
                    }
                }
            }

            if (move.not()) {
                positions[i] = Triple(tmpX, tmpY, tmpD)
            }

            if (isVisited[positions[i].first][positions[i].second]) {
                positions[i] = Triple(-1, -1, -1)
            } else {
                isVisited[positions[i].first][positions[i].second] = true
            }
        }

        // 냄새의 이동
        for (i in 0 until n) {
            for (j in 0 until n) {
                table[i][j] = table[i][j].copy(second = table[i][j].second - 1)
            }
        }
        count = 0
        positions.forEachIndexed { idx, (x, y) ->
            if (x != -1) {
                table[x][y] = Pair(idx, k)
                count++
            }
        }
        t++
    }
    println(if (t <= 1000) t else -1)
}
