import java.util.PriorityQueue

// https://www.acmicpc.net/problem/1753
// 2023-06-07

fun main() {
    val s = Solution()
    val (n, e) = readln().split(' ').map { it.toInt() }
    val startNode = readln().toInt()
    val edges = List(e) { readln().split(' ').map { it.toInt() } }
    s.solution(n, startNode, edges).forEach { println(if (it == Int.MAX_VALUE) "INF" else it) }
}

class Solution {
    fun solution(nodeSize: Int, startNode: Int, edges: List<List<Int>>): List<Int> {
        val isVisited = BooleanArray(nodeSize + 1)
        val dist = IntArray(nodeSize + 1) { Int.MAX_VALUE }.apply { this[startNode] = 0 }
        val graph = List(1 + nodeSize) { mutableListOf<Node>() }
        edges.forEach { (index1, index2, weight) ->
            graph[index1].add(Node(index2, weight))
        }

        // startNode에서 이동하려는 곳의 Node(index, weight) 를 가중치 순으로 정렬
        val pq = PriorityQueue(compareBy<Node> { it.weight }).apply { add(Node(startNode, 0)) }

        // startNode 에서 가장 가까운 노드 순으로 반복
        while (pq.isEmpty().not()) {
            val toNode = pq.poll()
            if (isVisited[toNode.index]) continue // 방문 노드이면 건너뜀
            isVisited[toNode.index] = true

            // 새롭게 이동한 거리 정보를 이용해 startNode->newNode 까지의 거리를 재정의, pq에 넣기
            graph[toNode.index].forEach { (index, weight) ->
                dist[index] = minOf(dist[index], dist[toNode.index] + weight)
                pq.add(Node(index, dist[index]))
            }
        }

        return dist.toList().subList(1, dist.size)
    }
}

data class Node(val index: Int, val weight: Int)
