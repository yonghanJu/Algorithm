// https://www.acmicpc.net/problem/19236
// 2023-10-16

val dx = listOf(0, -1, -1, 0, 1, 1, 1, 0, -1)
val dy = listOf(0, 0, -1, -1, -1, 0, 1, 1, 1)
var answer = 0
fun main() {
    val positions = MutableList(17) { Pair(-1, -1) }
    val table = List(4) { r ->
        readln().split(' ').let {
            val list = mutableListOf<Pair<Int, Int>>()
            for (i in it.indices step 2) {
                list.add(Pair(it[i].toInt(), it[i + 1].toInt()))
                positions[it[i].toInt()] = Pair(r, i / 2)
            }
            list
        }
    }
    dfs(0, 0, 0, table, positions)
    println(answer)
}

fun dfs(x: Int, y: Int, score: Int, table: List<MutableList<Pair<Int, Int>>>, positions: MutableList<Pair<Int, Int>>) {
    // 상어가 냠냠
    val (eat, newD) = table[x][y]
    positions[eat] = Pair(-1, -1)
    table[x][y] = Pair(-1, -1)

    // 물고기 이동
    for (i in positions.indices) {
        if (positions[i].first == -1) continue
        val (curX, curY) = positions[i]
        var nd = table[curX][curY].second
        var nx = curX
        var ny = curY
        var count = 0
        while (count < 8) {
            val nnx = curX + dx[nd]
            val nny = curY + dy[nd]
            if (nnx in 0..3 && nny in 0..3 && (nnx != x || nny != y)) {
                nx = nnx
                ny = nny
                break
            }
            nd = (nd + 1)
            if (nd == 9) nd = 1
            count++
        }

        val target = table[nx][ny]
        if (target.first != -1) positions[target.first] = Pair(curX, curY)
        positions[i] = Pair(nx, ny)
        table[nx][ny] = Pair(i, nd)
        table[curX][curY] = target
    }

    // 상어 이동, 없으면 종료, answer갱신
    val eatable = mutableListOf<Pair<Int, Int>>()
    var nx = x + dx[newD]
    var ny = y + dy[newD]
    while (nx in 0..3 && ny in 0..3) {
        if (table[nx][ny].first != -1) {
            eatable.add(Pair(nx, ny))
        }
        nx += dx[newD]
        ny += dy[newD]
    }
    if (eatable.isNotEmpty()) {
        eatable.forEach { (eatX, eatY) ->
            dfs(
                eatX,
                eatY,
                score + eat,
                table.map { r -> r.toMutableList() }, // .apply { this[x][y] = Pair(-1, -1) },
                positions.toMutableList(),
            )
        }
    } else {
        answer = maxOf(answer, score + eat)
    }
}
