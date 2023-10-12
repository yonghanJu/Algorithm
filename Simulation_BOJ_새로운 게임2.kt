import java.util.*

// https://www.acmicpc.net/problem/17837
// 2023-10-12

val dx = listOf(0, 0, 0, -1, 1)
val dy = listOf(0, 1, -1, 0, 0)

fun main() {
    val (n, k) = readln().split(' ').map { it.toInt() }
    val table = List(n + 1) { if (it == 0) listOf() else listOf(0) + readln().split(' ').map { it.toInt() } }
    val tableStack = List(n + 1) { List(n + 1) { Stack<Pair<Int, Int>>() } } // Pair(num, dir)
    val positionList = MutableList(k + 1) { Pair(0, 0) } // Pair(r, c)

    repeat(k) {
        val (r, c, d) = readln().split(' ').map { it.toInt() }
        tableStack[r][c].add(Pair(it + 1, d))
        positionList[it + 1] = Pair(r, c)
    }

    var turn = 0
    outer@ while (turn < 1000) {
        turn++

        for (i in 1..positionList.lastIndex) {
            // 위치
            val (r, c) = positionList[i]

            // 방향
            val tmp = mutableListOf<Pair<Int, Int>>().apply { add(tableStack[r][c].pop()) }
            while (tmp.last().first != i) {
                tmp.add(tableStack[r][c].pop())
            }
            var nx = r + dx[tmp.last().second]
            var ny = c + dy[tmp.last().second]

            // 이동
            var case = if (nx in 1..n && ny in 1..n) table[nx][ny] else 2
            while (true) {
                // 파랑
                when (case) { // 반대 방향
                    2 -> {
                        val ordinal = tmp.last().second
                        val nd = 1 + ordinal % 2 + ((ordinal - 1) / 2) * 2
                        val nnx = r + dx[nd]
                        val nny = c + dy[nd]
                        tmp[tmp.lastIndex] = Pair(i, nd)
                        if ((nnx in 1..n && nny in 1..n && table[nnx][nny] != 2).not()) { // 반대도 안됨
                            for (j in tmp.lastIndex downTo 0) {
                                tableStack[r][c].add(tmp[j])
                                nx = r
                                ny = c
                            }
                            break
                        }
                        case = table[nnx][nny]
                        nx = nnx
                        ny = nny
                    }

                    1 -> {
                        for (j in tmp.indices) {
                            tableStack[nx][ny].add(tmp[j])
                        }
                        break
                    }

                    0 -> {
                        for (j in tmp.lastIndex downTo 0) {
                            tableStack[nx][ny].add(tmp[j])
                        }
                        break
                    }
                }
            }

            tmp.forEach { (num, _) ->
                positionList[num] = Pair(nx, ny)
            }
            if (tableStack[nx][ny].size > 3) break@outer
        }
    }
    println(if (turn >= 1000) -1 else turn)
}
