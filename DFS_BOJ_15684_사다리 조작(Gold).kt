// 2022-11-19
// https://www.acmicpc.net/problem/15684

class Solution {
    var n = 0
    var h = 0
    private var table = List(0) { BooleanArray(0) }
    private var answer = Int.MAX_VALUE
    fun solution(info: List<Int>, list: List<IntArray>) {
        n = info[0]
        h = info[2]
        table = List(h + 1) { BooleanArray(n + 1) }.apply {
            repeat(info[1]) {
                get(list[it][0])[list[it][1]] = true
            }
        }
        dfs(1, 1, 1, 0)
        println(if (answer == Int.MAX_VALUE) -1 else answer)
    }

    private fun dfs(startY: Int, x: Int, y: Int, depth: Int) {
        if (depth == 4 || depth == answer ) return  // 4 초과
        if (x > h && startY == y && y == n) { // 종료 조건
            answer = minOf(answer, depth)
            return
        }
        if (x > h) {
            if (startY == y) dfs(startY + 1, 1, startY + 1, depth) // 다음 줄
            return
        }

        // 경우의 수
        if (table[x][y]) { // 오른쪽 다리가 있으면
            dfs(startY, x + 1, y + 1, depth)
        } else if (table[x][y - 1]) { // 왼쪽 다리가 있으면
            dfs(startY, x + 1, y - 1, depth)
        } else { // 다리가 없으면
            dfs(startY, x + 1, y, depth) // 다리 안놓기
            if (y < n && table[x][y].not() && table[x][y+1].not()) { // 다리 놓기 오른쪽
                table[x][y] = true
                dfs(startY, x + 1, y + 1, depth + 1)
                table[x][y] = false
            }
            if (y > 1 && table[x][y - 1].not() && table[x][y-2].not()) { // 다리 놓기 왼쪽
                table[x][y - 1] = true
                dfs(startY, x + 1, y - 1, depth + 1)
                table[x][y - 1] = false
            }
        }
    }
}

fun main() {
    val info = readLine()!!.split(" ").map { it.toInt() }.toList()
    val list = List(info[1]) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }
    Solution().solution(info, list)

}
