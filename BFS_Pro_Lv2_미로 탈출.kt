class Solution {
    val dx = listOf(1, -1, 0, 0)
    val dy = listOf(0, 0, 1, -1)
    
    fun solution(maps: Array<String>): Int {
        var answer: Int = 0
        var start = Pair(0, 0)
        var lebel = Pair(0, 0)
        var exit = Pair(0, 0)
        
        for (i in maps.indices) {
            for (j in maps[i].indices) {
                if (maps[i][j] == 'S') start = Pair(i, j)
                if (maps[i][j] == 'L') lebel = Pair(i, j)
                if (maps[i][j] == 'E') exit = Pair(i, j)
            }
        }
        
        val step1 = bfs(start, lebel, maps).also { if (it == -1) return -1 }
        val step2 = bfs(lebel, exit, maps).also { if (it == -1) return -1 }
        return  step1 + step2
    }
    
    fun bfs(start: Pair<Int, Int>, end: Pair<Int, Int>, maps: Array<String>): Int {
        val isVisited = List(maps.size) { BooleanArray(maps[it].length) }
        val queue = ArrayDeque<Triple<Int, Int, Int>>()
        
        isVisited[start.first][start.second] = true
        queue.addFirst(Triple(start.first, start.second, 0))
        
        var count = 0
        
        while(queue.isEmpty().not()) {
            val (x, y, c) = queue.removeLast()
            if (end.first == x && end.second == y) {
                return c
            }
            
            for(i in 0..3) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                
                if(nx in maps.indices && ny in maps[nx].indices && isVisited[nx][ny].not() && maps[nx][ny] != 'X') {
                    isVisited[nx][ny] = true
                    queue.addFirst(Triple(nx, ny, c + 1))
                }
            }
            
        }
        
        return -1
    }
}
