// https://www.acmicpc.net/problem/14438
// 2023-09-27

fun main() {
    val n = readln().toInt()
    val list = listOf(0) + readln().split(' ').map { it.toInt() }
    val m = readln().toInt()
    val queries = List(m) { readln().split(' ').map { it.toInt() } }

    val tree = MutableList(n * 3) { Int.MAX_VALUE } // ?? 왜 tree 리스트의 크기가 n*2를 하면 부족하지??
    makeSegmentTree(tree, list, 1, 1, n)

    val sb = StringBuilder()
    queries.forEach { query ->
        if (query[0] == 1) {
            replaceNode(tree, 1, query[1], query[2], 1, n)
        } else {
            sb.append(getMin(tree, 1, 1, n, query[1], query[2]))
            sb.append('\n')
        }
    }
    println(sb)
}

fun makeSegmentTree(tree: MutableList<Int>, list: List<Int>, node: Int, start: Int, end: Int) {
    if (start == end) {
        tree[node] = list[start]
        return
    }

    makeSegmentTree(tree, list, node * 2, start, (start + end) / 2)
    makeSegmentTree(tree, list, node * 2 + 1, (start + end) / 2 + 1, end)

    tree[node] = minOf(tree[node * 2], tree[node * 2 + 1])
}

fun replaceNode(tree: MutableList<Int>, node: Int, index: Int, v: Int, start: Int, end: Int): Int {
    if (start == end) {
        tree[node] = v
        return v
    }

    var l = tree[node * 2]
    var r = tree[node * 2 + 1]
    if (index in start..(start + end) / 2) {
        l = replaceNode(tree, node * 2, index, v, start, (start + end) / 2)
    } else if (index in (start + end) / 2 + 1..end) {
        r = replaceNode(tree, node * 2 + 1, index, v, (start + end) / 2 + 1, end)
    }
    tree[node] = minOf(l, r)
    return tree[node]
}

fun getMin(tree: List<Int>, node: Int, curStart: Int, curEnd: Int, targetStart: Int, targetEnd: Int): Int {
    if (curStart >= targetStart && curEnd <= targetEnd) return tree[node]
    val l = if (targetStart <= (curStart + curEnd) / 2) {
        getMin(tree, node * 2, curStart, (curStart + curEnd) / 2, targetStart, targetEnd)
    } else {
        Int.MAX_VALUE
    }
    val r = if (targetEnd > (curStart + curEnd) / 2) {
        getMin(tree, node * 2 + 1, (curStart + curEnd) / 2 + 1, curEnd, targetStart, targetEnd)
    } else {
        Int.MAX_VALUE
    }
    return minOf(l, r)
}
