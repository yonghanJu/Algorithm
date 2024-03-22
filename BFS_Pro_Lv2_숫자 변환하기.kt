class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
        var answer: Int = -1
        val isVisited = BooleanArray(y + 1)
        isVisited[x] = true
        val dq = ArrayDeque<Pair<Int, Int>>()
        dq.addFirst(Pair(x, 0))
        
        while (dq.isNotEmpty()) {
            val (cur, count) = dq.removeLast()
            if (cur == y) return count
            
            if (cur + n in x..y && isVisited[cur + n].not()) {
                isVisited[cur + n] = true
                dq.addFirst(Pair(cur + n, count + 1))
            }
            
            if (cur * 2 in x..y && isVisited[cur * 2].not()) {
                isVisited[cur * 2] = true
                dq.addFirst(Pair(cur * 2, count + 1))
            }
            
            if (cur * 3 in x..y && isVisited[cur * 3].not()) {
                isVisited[cur * 3] = true
                dq.addFirst(Pair(cur * 3, count + 1))
            }
        }
        
        return answer
    }
}
