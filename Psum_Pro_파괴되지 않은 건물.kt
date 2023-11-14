class Solution {
    // 계속 더하는 부분에서는 누적합을 생각할 수 있다.
    // 넓은 범위속에 최저, 최대 하나의 값을 뽑는것은 이진탐색
    fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
        var answer: Int = 0
        val psum = List(board.size + 1) { IntArray(board[0].size + 1) }
        skill.forEach {
            val (type, r1, c1, r2, c2) = it.toList()
            val degree = if(type == 1) -it.last() else it.last()
            psum[r1][c1] += degree
            psum[r1][c2 + 1] -= degree
            psum[r2 + 1][c1] -= degree
            psum[r2 + 1][c2 + 1] += degree  
        }
        for(j in 0 until psum[0].lastIndex) {
            for(i in 0 until psum.lastIndex) {
                psum[i + 1][j] += psum[i][j]
            }   
        }
        
        for(j in 0 until psum[0].lastIndex) {
            for(i in 0 until psum.lastIndex) {
                psum[i][j+ 1] += psum[i][j]
            }   
        }
        
        for(j in board[0].indices) {
            for(i in board.indices) {
                if(board[i][j] + psum[i][j] > 0) answer ++
            }   
        }
        
        return answer
    }
}
