import java.util.*

class Solution {
    private lateinit var costs: List<List<IntArray>>
    val dx = listOf(0, 0, 1, -1)
    val dy = listOf(1, -1, 0, 0)
    var size = 0
    fun solution(board: Array<IntArray>): Int {
        var answer = 0
        size = board.size
        costs = List(size){ List(size) { IntArray(4) {Int.MAX_VALUE } } }
        (0..3).forEach {
            costs[0][0][it] = 0
        }
        
        bfs(board)
        
        return costs.last().last().reduce{ s, acc -> minOf(s, acc) }
    }
    
    fun bfs(board: Array<IntArray>) {
        val q = ArrayDeque<Node>()
        q.addFirst(Node(0, 0, 0))
        q.addFirst(Node(0, 0, 2))
        
        while(q.isNotEmpty()) {
            val (x, y, prevD) = q.poll()
            
            for(i in 0..3) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                
                if(nx in board.indices && ny in board.indices && board[nx][ny] == 0) {
                    if(costs[nx][ny][i] > costs[x][y][prevD] + if(i == prevD) 100 else 600) {
                        costs[nx][ny][i] = costs[x][y][prevD] + if(i == prevD) 100 else 600
                        
                        q.addFirst(Node(nx, ny, i))
                    }
                }
            }
        }
    }
}

data class Node(
    val x: Int,
    val y: Int,
    val prevD: Int,
)
