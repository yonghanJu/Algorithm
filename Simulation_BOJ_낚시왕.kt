// https://www.acmicpc.net/problem/17143
// 2023-10-09

val rcm = readln().split(' ').map { it.toInt() }
val inputs = List(rcm[2]) { readln().split(' ').map { it.toInt() } }

val dx = listOf(0, -1, 1, 0, 0)
val dy = listOf(0, 0, 0, 1, -1)

fun main() {
    var current = 0
    var table = List(rcm[0] + 1) { MutableList<List<Int>?>(rcm[1] + 1) { null } }
    inputs.forEach { (r, c, s, d, z) ->
        table[r][c] = listOf(s, d, z)
    }
    var answer = 0L
    while (current < rcm[1]) {
        // 1
        current++

        // 2
        for (r in 1..rcm[0]) {
            if (table[r][current] != null) {
                answer += table[r][current]!!.last()
                table[r][current] = null
                break
            }
        }

        // 3
        val tmp = List(rcm[0] + 1) { MutableList<List<Int>?>(rcm[1] + 1) { null } }
        for (i in 1..rcm[0]) {
            for (j in 1..rcm[1]) {
                if (table[i][j] != null) {
                    var (s, d, z) = table[i][j]!!
                    var nr = i + dx[d] * s
                    var nc = j + dy[d] * s
                    while ((nr in 1..rcm[0]).not()) {
                        if (nr < 1) {
                            d = 2
                            nr = (nr * -1) + 2
                        }
                        if (nr > rcm[0]) {
                            d = 1
                            nr = 2 * rcm[0] - nr
                        }
                    }
                    while ((nc in 1..rcm[1]).not()) {
                        if (nc < 1) {
                            d = 3
                            nc = (nc * -1) + 2
                        }
                        if (nc > rcm[1]) {
                            d = 4
                            nc = 2 * rcm[1] - nc
                        }
                    }
                    if ((tmp[nr][nc]?.lastOrNull() ?: 0) < z) {
                        tmp[nr][nc] = listOf(s, d, z)
                    }
                    table[i][j] = null
                }
            }
        }
        table = tmp
    }
    println(answer)
}
