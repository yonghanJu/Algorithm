// https://www.acmicpc.net/problem/17825
// 2023-10-14

var answer = 0
val input = readln().split(' ').map { it.toInt() }

fun main() {
    val (graph, nodes) = makeGraph()

    dfs(listOf(0, 0, 0, 0), 0, graph, nodes, 0)
    println(answer)
}

fun dfs(state: List<Int>, level: Int, graph: List<List<Int>>, nodes: List<Int>, score: Int) {
    answer = maxOf(answer, score)
    if (level == 10) return
    for (i in state.indices) {
        val curIndex = state[i]
        if (nodes[curIndex] != 0) {
            val toIndex = go(input[level], curIndex, graph)
            if (state.any { (it != 21 && it == toIndex) }.not()) {
                dfs(
                    state.toMutableList().apply { set(i, toIndex) },
                    level + 1,
                    graph,
                    nodes,
                    score + nodes[toIndex],
                )
            }
        }
    }
}

fun go(n: Int, cur: Int, graph: List<List<Int>>): Int {
    var answer = cur
    repeat(n) {
        answer = if (it == 0) {
            graph[answer].lastOrNull() ?: 21
        } else {
            graph[answer].firstOrNull() ?: 21
        }
    }
    return answer
}

fun makeGraph(): Pair<List<List<Int>>, List<Int>> {
    val info = mutableListOf<Int>()
    info.add(-1)
    for (i in 1..20) {
        info.add(i * 2)
    }
    info.add(0) // index 21
    info.add(25) // index 22
    for (i in 13..19 step 3) info.add(i) // index 23~25
    for (i in 22..24 step 2) info.add(i) // index 26~27
    for (i in 28 downTo 26) info.add(i) // index 28 ~ 30
    for (i in 30..35 step 5) info.add(i) // index 31 ~ 32

    val graph = List(info.size) { mutableListOf<Int>() }

    for (i in 0..20) {
        graph[i].add(i + 1)
    }

    graph[5].add(23)
    for (i in 23..24) {
        graph[i].add(i + 1)
    }
    graph[25].add(22)

    graph[10].add(26)
    graph[26].add(27)
    graph[27].add(22)

    graph[15].add(28)
    for (i in 28..29) graph[i].add(i + 1)
    graph[30].add(22)

    graph[22].add(31)
    graph[31].add(32)
    graph[32].add(20)

    return Pair(graph, info)
}
