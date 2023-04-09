// 2023-04-10
// https://school.programmers.co.kr/learn/courses/30/lessons/169199

val dx = arrayOf(0, 1 , 0, -1)
val dy = arrayOf(1 ,0 , -1, 0)

class Solution {
    fun solution(board: Array<String>): Int {
        var goalX = 0
        var goalY = 0
        var startX = 0
        var startY = 0
        for(i in board.indices) {
            for(j in board[0].indices) {
                if(board[i][j] == 'G') {
                    goalX = i
                    goalY = j
                }
                if(board[i][j] == 'R') {
                    startX = i
                    startY = j
                    board[i] = board[i].replace('R','.')
                    println(board[i])
                }
            }
        }
        return bfs(board, goalX, goalY, startX, startY)
    }
    
    fun bfs(board: Array<String>, goalX: Int, goalY: Int, startX: Int, startY:Int): Int {
        val queue = ArrayDeque<Triple<Int, Int, Int>>()
        val isVisited = List(board.size) {BooleanArray(board[0].length)}
        println("$startX $startY")
        queue.addFirst(Triple(startX, startY, 0))
        isVisited[startX][startY] = true
        
        while(queue.isEmpty().not()) {
            val (x, y, depth) = queue.removeLast()
            if(x == goalX && y == goalY) return depth
            
            for(i in 0..3) {
                var nx = x
                var ny = y
                while(nx + dx[i] in board.indices 
                      && ny + dy[i] in board[0].indices 
                      && board[nx + dx[i]][ny + dy[i]] != 'D') {
                    nx += dx[i]
                    ny += dy[i]
                }
                if(isVisited[nx][ny].not()) { // 정지
                    isVisited[nx][ny] = true
                    queue.addFirst(Triple(nx, ny, depth + 1))
                }
            }
        }
        return -1
    }
}
