import java.util.*

// https://www.acmicpc.net/problem/17822
// 2023-10-13

val dx = listOf(0, 0, 1, -1)
val dy = listOf(1, -1, 0, 0)

fun main() {
    val (n, m, t) = readln().split(' ').map { it.toInt() }
    val table = List(n) { ArrayDeque<Int>() }
    repeat(n) {
        readln().split(' ').map { it.toInt() }.forEach { num ->
            table[it].addLast(num)
        }
    }
    val inst = List(t) { readln().split(' ').map { it.toInt() } }
    var answer = 0

    repeat(t) {
        val (r, d, k) = inst[it]
        var rr = r
        if (d == 0) { // 시계
            while (rr <= n) {
                repeat(k) {
                    table[rr - 1].addFirst(table[rr - 1].removeLast())
                }
                rr += r
            }
        } else { // 반시계
            while (rr <= n) {
                repeat(k) {
                    table[rr - 1].addLast(table[rr - 1].removeFirst())
                }
                rr += r
            }
        }

        val isVisited = List(n) { BooleanArray(m) }
        var flag = false
        val met = table.map { adq -> adq.toMutableList() }
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (met[i][j] != 0 && isVisited[i][j].not()) {
                    val adjacent = dfs(i, j, met, isVisited, n, m)
                    if (adjacent.size > 1) {
                        flag = true
                        adjacent.forEach { (x, y) ->
                            met[x][y] = 0
                        }
                    }
                }
            }
        }
        if (flag.not()) {
            var sum = 0
            var count = 0
            for (i in 0 until n) {
                for (j in 0 until m) {
                    if (met[i][j] != 0) {
                        sum += met[i][j]
                        count++
                    }
                }
            }
            val avg = sum.toDouble() / count
            for (i in 0 until n) {
                for (j in 0 until m) {
                    if (met[i][j] != 0) {
                        if (met[i][j] > avg) {
                            met[i][j]--
                        } else if (met[i][j] < avg) {
                            met[i][j]++
                        }
                    }
                }
            }
        }
        for (i in 0 until n) {
            table[i].clear()
            for (j in 0 until m) table[i].addLast(met[i][j])
        }
    }

    table.forEach {
        answer += it.sum()
    }
    println(answer)
}

fun dfs(x: Int, y: Int, met: List<List<Int>>, isVisited: List<BooleanArray>, n: Int, m: Int): List<Pair<Int, Int>> {
    isVisited[x][y] = true
    val list = mutableListOf<Pair<Int, Int>>().apply { add(Pair(x, y)) }

    for (i in 0..3) {
        val nx = x + dx[i]
        var ny = y + dy[i]

        if (nx in 0 until n && ny in -1..m) {
            if (ny == -1) ny = m - 1
            if (ny == m) ny = 0
            if (isVisited[nx][ny].not() && met[nx][ny] == met[x][y]) {
                list.addAll(dfs(nx, ny, met, isVisited, n, m))
            }
        }
    }

    return list
}
