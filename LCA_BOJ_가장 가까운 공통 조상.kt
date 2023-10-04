import java.lang.StringBuilder

// https://www.acmicpc.net/problem/3584
// 2023-10-01

fun main() {
    val sb = StringBuilder()
    repeat(readln().toInt()) {
        val n = readln().toInt()
        val tree = List(n + 1) { mutableListOf<Int>() }
        val isParent = BooleanArray(n + 1)
        for (i in 1 until n) {
            val (p, c) = readln().split(' ').map { it.toInt() }
            tree[p].add(c)
            isParent[c] = true
        }
        val (a, b) = readln().split(' ').map { it.toInt() }
        var root = 0
        for (i in 1..n) {
            if (isParent[i].not()) root = i
        }

        val track1 = ArrayDeque<Int>()
        val track2 = ArrayDeque<Int>()
        dfs(root, a, tree, track1)
        dfs(root, b, tree, track2)
        var answer = 0
        while (track1.isNotEmpty() && track2.isNotEmpty()) {
            if(track1.first() == track2.first()) {
                answer = track1.removeFirst()
                track2.removeFirst()
            } else {
                break
            }
        }
        sb.append(answer)
        sb.append('\n')
    }
    println(sb)
}

fun dfs(cur: Int, target: Int, graph: List<List<Int>>, answer: ArrayDeque<Int>): Boolean {
    if (target == cur) {
        answer.addFirst(cur)
        return true
    }

    graph[cur].forEach {
        if(dfs(it, target, graph, answer)) {
            answer.addFirst(cur)
            return true
        }
    }

    return false
}
