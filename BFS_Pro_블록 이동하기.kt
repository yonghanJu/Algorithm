class Solution {
    val dx = listOf(0, 1, 0, -1)
    val dy = listOf(1, 0, -1, 0)
    fun solution(board: Array<IntArray>): Int {
        return bfs(board)
    }

    fun bfs(board: Array<IntArray>): Int {
        val isVisited = mutableMapOf<Set<Pair<Int, Int>>, Boolean>()
        isVisited[setOf(Pair(0, 0), Pair(0, 1))] = true
        val q = ArrayDeque<Robot>()
        q.addFirst(Robot(0, 0, 0, 1, 0))

        while (q.isNotEmpty()) {
            val (x1, y1, x2, y2, depth) = q.removeLast()
            if (x1 == board.lastIndex && y1 == board.lastIndex) return depth
            if (x2 == board.lastIndex && y2 == board.lastIndex) return depth
            for (i in 0..3) {
                val newX1 = x1 + dx[i]
                val newY1 = y1 + dy[i]
                val newX2 = x2 + dx[i]
                val newY2 = y2 + dy[i]

                if (newX1 in board.indices && newY1 in board.indices && newX2 in board.indices && newY2 in board.indices &&
                    board[newX1][newY1] == 0 && board[newX2][newY2] == 0
                ) {
                    val key = setOf(Pair(newX1, newY1), Pair(newX2, newY2))
                    if (isVisited[key] != null) continue
                    isVisited[key] = true

                    q.addFirst(Robot(newX1, newY1, newX2, newY2, depth + 1))
                }
            }

            for (i in 0..3) {
                val newX1 = x2 + dx[i]
                val newY1 = y2 + dy[i]
                if (Math.abs(x1 - newX1) == 1 && Math.abs(y1 - newY1) == 1 && newX1 in board.indices && newY1 in board.indices &&
                    board[newX1][newY1] == 0 && board[if (x2 == x1) newX1 else x1][if (y2 == y1) newY1 else y1] == 0
                ) {
                    val key = setOf(Pair(newX1, newY1), Pair(x2, y2))
                    if (isVisited[key] != null) continue
                    isVisited[key] = true

                    q.addFirst(Robot(newX1, newY1, x2, y2, depth + 1))
                }
            }

            for (i in 0..3) {
                val newX2 = x1 + dx[i]
                val newY2 = y1 + dy[i]
                if (Math.abs(x2 - newX2) == 1 && Math.abs(y2 - newY2) == 1 && newX2 in board.indices && newY2 in board.indices &&
                    board[newX2][newY2] == 0 && board[if (x2 == x1) newX2 else x2][if (y2 == y1) newY2 else y2] == 0
                ) {
                    val key = setOf(Pair(newX2, newY2), Pair(x1, y1))
                    if (isVisited[key] != null) continue
                    isVisited[key] = true

                    q.addFirst(Robot(x1, y1, newX2, newY2, depth + 1))
                }
            }
        }

        return -1
    }
}

data class Robot(
    val x1: Int,
    val y1: Int,
    val x2: Int,
    val y2: Int,
    val depth: Int,
)
