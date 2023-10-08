import kotlin.math.pow

// https://www.acmicpc.net/problem/15685
// 2023-10-07

val dx = listOf(1, 0, -1, 0)
val dy = listOf(0, -1, 0, 1)

fun main() {
    val input = List(readln().toInt()) { readln().split(' ').map { it.toInt() } }
    val table = List(101) { BooleanArray(101) }

    input.forEach { (x, y, dir, level) ->
        table[x][y] = true
        if (level > 0) {
            re(x + dx[dir], y + dy[dir], mutableListOf(dir), level, table)
        } else {
            table[x + dx[dir]][y + dy[dir]] = true
        }
    }
    var answer = 0
    for (i in 0..99) {
        for (j in 0..99) {
            if (table[i][j] && table[i + 1][j] && table[i][j + 1] && table[i + 1][j + 1]) {
                answer++
            }
        }
    }
    println(answer)
}

fun re(x: Int, y: Int, dirs: MutableList<Int>, level: Int, table: List<BooleanArray>) {
    var curX = x
    var curY = y
    table[curX][curY] = true

    val rotate = rotate(dirs)
    for (i in rotate.lastIndex downTo 0) {
        curX += dx[rotate[i]]
        curY += dy[rotate[i]]
        table[curX][curY] = true
        dirs.add(rotate[i])
    }

    if (dirs.size == 2.0.pow(level).toInt()) {
        return
    }
    re(curX, curY, dirs, level, table)
}

fun rotate(dirs: List<Int>): List<Int> {
    return dirs.map { (it + 2) % 4 }.map { (it + 3) % 4 }
}
