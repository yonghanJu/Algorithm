// https://www.acmicpc.net/problem/1234
// 2023-10-05

val gc = List(11) { List(101) { List(101) { IntArray(101) { -1 } } } }
val df = List(11) { List(101) { List(101) { ULongArray(101) { 0.toULong() } } } }
fun main() {
    val (n, r, g, b) = readln().split(' ').map { it.toInt() }
    println(dfs(1, r, g, b, n))
}

fun dfs(cur: Int, rr: Int, gg: Int, bb: Int, target: Int): ULong { // target--
    if (cur > target) return 1UL
    val (r, g, b) = listOf(rr, gg, bb).sorted()
    if (df[cur][r][g][b] != 0UL) return df[cur][r][g][b]
    var ret = 0UL
    if (cur <= r) ret += dfs(cur + 1, r - cur, g, b, target) * getCount(cur, 0, cur, 0, 0).toULong()
    if (cur <= g) ret += dfs(cur + 1, r, g - cur, b, target) * getCount(cur, 0, 0, cur, 0).toULong()
    if (cur <= b) ret += dfs(cur + 1, r, g, b - cur, target) * getCount(cur, 0, 0, 0, cur).toULong()
    if (cur % 2 == 0) { // 나눠서
        if (minOf(r, g) >= cur / 2) {
            ret += dfs(cur + 1, r - cur / 2, g - cur / 2, b, target) * getCount(
                cur,
                0,
                cur / 2,
                cur / 2,
                0,
            ).toULong()
        }
        if (minOf(b, g) >= cur / 2) {
            ret += dfs(cur + 1, r, g - cur / 2, b - cur / 2, target) * getCount(
                cur,
                0,
                0,
                cur / 2,
                cur / 2,
            ).toULong()
        }
        if (minOf(r, b) >= cur / 2) {
            ret += dfs(cur + 1, r - cur / 2, g, b - cur / 2, target) * getCount(
                cur,
                0,
                cur / 2,
                0,
                cur / 2,
            ).toULong()
        }
    }
    if (cur % 3 == 0 && minOf(r, g, b) >= cur / 3) {
        ret += dfs(
            cur + 1,
            r - cur / 3,
            g - cur / 3,
            b - cur / 3,
            target,
        ) * getCount(
            cur,
            0,
            cur / 3,
            cur / 3,
            cur / 3,
        ).toULong()
    }

    df[cur][r][g][b] = ret
    return ret
}

fun getCount(size: Int, index: Int, r: Int, g: Int, b: Int): Int {
    if (size == 0) return 0
    if (size == index) return 1
    val (a, bb, c) = listOf(r, g, b).sorted()
    if (gc[size][a][bb][c] != -1) return gc[size][a][bb][c]
    var answer = 0
    if (r > 0) answer += getCount(size, index + 1, r - 1, g, b)
    if (g > 0) answer += getCount(size, index + 1, r, g - 1, b)
    if (b > 0) answer += getCount(size, index + 1, r, g, b - 1)

    gc[size][a][bb][c] = answer
    return answer
}
