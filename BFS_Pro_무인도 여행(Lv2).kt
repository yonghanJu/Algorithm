// https://school.programmers.co.kr/learn/courses/30/lessons/154540?language=kotlin
// 2023-05-01

class Solution {
    
    lateinit var isVisited: List<BooleanArray>
    val dx = arrayOf(0, 1, 0, -1)
    val dy = arrayOf(1, 0, -1, 0)
    
    fun solution(maps: Array<String>): IntArray {
        val answer = mutableListOf<Int>()
        
        isVisited = List(maps.size) {BooleanArray(maps[0].length)}
        for(i in 0 until maps.size) {
            for(j in 0 until maps[0].length) {
                val n = bfs(i, j, maps)
                if(n > 0) answer.add(n)
            }
        }
        if(answer.isEmpty()) answer.add(-1)
        return answer.sortedBy{it}.toIntArray()
    }
    
    fun bfs(x: Int, y:Int, maps: Array<String>): Int {
        if(isVisited[x][y] || maps[x][y] == 'X') return -1
        val queue = ArrayDeque<Pair<Int,Int>>()
        
        queue.addFirst(Pair(x, y))
        isVisited[x][y] = true
        
        var sum = (maps[x][y].toInt() - '0'.toInt())
        
        while(queue.isEmpty().not()) {
            val (curX, curY) = queue.removeLast()
            for(i in 0..3){
                val nx = dx[i] + curX
                val ny = dy[i] + curY
                if(nx in 0 until maps.size 
                   && ny in 0 until maps[0].length 
                   && maps[nx][ny] != 'X'  
                   && isVisited[nx][ny].not()) {
                    isVisited[nx][ny] = true
                    sum += (maps[nx][ny].toInt() - '0'.toInt())
                    queue.addFirst(Pair(nx, ny))
                }
            }
        }
        
        return sum
    }
}
