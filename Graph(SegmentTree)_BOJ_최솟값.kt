// https://www.acmicpc.net/problem/10868
// 2023-09-26

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val list = List(n + 1) { if (it == 0) 0 else readln().toInt() }
    val map = mutableMapOf<Pair<Int, Int>, Int>()
    makeSegmentTree(list, 1, n, map)
    val answer = StringBuilder()

    repeat(m) {
        val (l, r) = readln().split(' ').map { it.toInt() }
        answer.append(dfs(map, 1, n, l, r))
        answer.append('\n')
    }
    println(answer)
}

fun makeSegmentTree(list: List<Int>, start: Int, end: Int, map: MutableMap<Pair<Int, Int>, Int>): Int {
    if (start == end) {
        map[Pair(start, end)] = list[start]
        return list[start]
    }

    val l = map[Pair(start, (start + end) / 2)] ?: makeSegmentTree(list, start, (start + end) / 2, map)
    val r = map[Pair((start + end) / 2 + 1, end)] ?: makeSegmentTree(list, (start + end) / 2 + 1, end, map)
    map[Pair(start, end)] = minOf(l, r)

    return minOf(l, r)
}

fun dfs(map: Map<Pair<Int, Int>, Int>, start: Int, end: Int, targetStart: Int, targetEnd: Int): Int {
    if (start >= targetStart && end <= targetEnd) return map[Pair(start, end)]!!

    val l = if (targetStart <= (start + end) / 2) dfs(map, start, (start + end) / 2, targetStart, targetEnd) else Int.MAX_VALUE
    val r = if (targetEnd > (start + end) / 2) dfs(map, (start + end) / 2 + 1, end, targetStart, targetEnd) else Int.MAX_VALUE

    return minOf(l, r)
}

