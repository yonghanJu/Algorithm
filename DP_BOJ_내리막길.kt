// https://www.acmicpc.net/problem/1520
// 2023-09-02

fun main() {
    val s = Solution()
    val (n, m) = readln().split(' ').map { it.toInt() }

    print(s.solution(n, m, List(n) { readln().split(' ').map { it.toInt() } }))
}

class Solution {
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0, -1, 0)
    fun solution(n: Int, m: Int, list: List<List<Int>>): Int {
        val isVisited = List(n) { IntArray(m) }
        val dp = List(n) { IntArray(m) }
        return dfs(0, 0, n, m, list, isVisited, dp)
    }

    fun dfs(x: Int, y: Int, n: Int, m: Int, list: List<List<Int>>, isVisited: List<IntArray>, dp: List<IntArray>): Int {
        if (x == n - 1 && y == m - 1) {
            return 1
        } else if (dp[x][y] > 0) {
            return isVisited[x][y]
        }
        dp[x][y] = 1

        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx in 0 until n && ny in 0 until m && list[nx][ny] < list[x][y]) {
                isVisited[x][y] += dfs(nx, ny, n, m, list, isVisited, dp)
            }
        }

        return isVisited[x][y]
    }
}
