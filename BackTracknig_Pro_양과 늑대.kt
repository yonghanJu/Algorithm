class Solution {
    private var answer: Int = 0
    fun solution(info: IntArray, edges: Array<IntArray>): Int {
        val graph = List(info.size) { mutableListOf<Int>() }
        edges.forEach { (from, to) ->
            graph[from].add(to)
        }

        dfs(0, mutableSetOf(), 0, 0, graph, info)

        return answer
    }

    fun dfs(cur: Int, canGo: MutableSet<Int>, l: Int, w: Int, graph: List<List<Int>>, info: IntArray) {
        var (lamb, wolf) = Pair(l, w)
        lamb += (info[cur] + 1) % 2
        wolf += info[cur]
        if (wolf >= lamb) return

        canGo.remove(cur)

        graph[cur].forEach {
            canGo.add(it)
        }

        if (answer < lamb) {
            answer = maxOf(answer, lamb)
        }

        canGo.forEach {
            dfs(it, canGo.toMutableSet(), lamb, wolf, graph, info)
        }
    }
}
