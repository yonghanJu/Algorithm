// 2023-03-06
// https://www.acmicpc.net/problem/2250

val answerMap = mutableMapOf<Int, Int>()

fun solution(input: List<List<Int>>) {
    val map = mutableMapOf<Int, TNode>()

    val rootCount = IntArray(input.size)
    for (list in input) {
        if (list[1] != -1) rootCount[list[1] - 1]++
        if (list[2] != -1) rootCount[list[2] - 1]++
    }

    val queue = ArrayDeque<Int>()
    var root = 0
    for (i in rootCount.indices) {
        if (rootCount[i] == 0) {
            queue.addFirst(i + 1)
            map[i + 1] = TNode()
            root = i + 1
            break
        }
    }

    while (queue.isNotEmpty()) {
        val num = queue.removeLast()
        val node = map[num]
        if (input[num - 1][1] != -1) {
            val lNode = TNode()
            node!!.lNode = lNode
            map[input[num - 1][1]] = lNode
            queue.addFirst(input[num - 1][1])
        }
        if (input[num - 1][2] != -1) {
            val rNode = TNode()
            node!!.rNode = rNode
            map[input[num - 1][2]] = rNode
            queue.addFirst(input[num - 1][2])
        }
    }

    dfs(map[root]!!, 1)
    println("${answer.first} ${answer.second}")
}

fun main() {
    solution(Array(readLine()!!.toInt()) { readLine()!!.split(" ").map { it.toInt() } }.sortedBy { it.first() })
}

class TNode() {
    var lNode: TNode? = null
    var rNode: TNode? = null
}

var answer = Pair(1, 1)
var count = 0

fun dfs(node: TNode, depth: Int) {
    node.lNode?.run {
        dfs(this, depth + 1)
    }

    count++
    if (answerMap[depth] == null) {
        answerMap[depth] = count
    } else {
        if (answer.second <= count - answerMap[depth]!! + 1) {
            answer = Pair(depth, count - answerMap[depth]!! + 1)
        }
    }

    node.rNode?.run {
        dfs(this, depth + 1)
    }
}
