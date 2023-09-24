// https://www.acmicpc.net/problem/2110
// 2023-09-24
// 다익스트라로는 풀 수 없기때문에 이진탐색으로 바꿔서 푸는 사고가 필요함

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val bridges = List(m) { readln().split(' ').map { it.toInt() } }
    val (fac1, fac2) = readln().split(' ').map { it.toInt() }
    val graph = List(n + 1) { mutableListOf<Pair<Int, Int>>() }
    bridges.forEach {
        graph[it[0]].add(Pair(it[1], it[2]))
        graph[it[1]].add(Pair(it[0], it[2]))
    }
    graph.map {
        it.sortedBy { p -> -p.second }
    }

    val dist = IntArray(n + 1) { Int.MAX_VALUE }
    dist[fac1] = 0

    var answer = 0
    var l = 0
    var r = 1000000000
    var mid = (l + r) / 2
    while (l <= r) {
        mid = (l + r) / 2
        if (bfs(mid, fac1, fac2, graph)) { // 방문 가능, 더 늘려
            l = mid + 1
            if(answer < mid) answer = mid
        } else {
            r = mid - 1
        }
    }
    println(answer)
}

fun bfs(weight: Int, from: Int, to: Int, graph: List<List<Pair<Int, Int>>>): Boolean {
    val isVisited = BooleanArray(graph.size)
    val q = ArrayDeque<Int>()

    isVisited[from] = true
    q.addFirst(from)

    while(q.isNotEmpty()) {
        val cur = q.removeLast()
        if(cur == to) return true
        graph[cur].forEach {
            if(isVisited[it.first].not() && it.second >= weight) {
                isVisited[it.first] = true
                q.addFirst(it.first)
            }
        }
    }

    return false
}
