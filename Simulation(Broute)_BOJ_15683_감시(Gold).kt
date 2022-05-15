// 2022-05-15
// https://www.acmicpc.net/problem/15683

import java.util.*

class Solution {
    var answer = Int.MAX_VALUE
    var wall = 0
    val stack = Stack<Pair<Int, Int>>()
    lateinit var dirList: IntArray
    lateinit var board: Array<MutableList<Int>>
    lateinit var cctvList: MutableList<Pair<Int, Int>>
    fun solution(array: Array<List<Int>>) {
        cctvList = mutableListOf()
        board = Array(array.size) { array[it].toMutableList() }
        array.forEachIndexed { x, it ->
            it.forEachIndexed { y, v ->
                if (v in 1..5) cctvList.add(Pair(x, y))
                else if (v == 6) wall++
            }
        }

        dirList = IntArray(cctvList.size)
        dfs(0)
        print(answer)
    }

    fun dfs(depth: Int) {
        if (depth == cctvList.size) {
            answer = minOf(answer, board.size * board[0].size - cctvList.size - wall - stack.size)
            return
        }

        for (i in 0..3) {
            dirList[depth] = i
            var cnt = check(depth)
            dfs(depth + 1)
            repeat(cnt) {
                val (popX, popY) = stack.pop()
                board[popX][popY] = 0
            }
        }
    }

    fun check(depth: Int): Int {
        var cnt = 0
        val (x, y) = cctvList[depth]
        when (dirList[depth]) {
            0 -> { // 위 방향
                when (board[x][y]) {
                    1 -> {
                        cnt += checkUp(x, y)
                    }
                    2 -> {
                        cnt += checkUp(x, y) + checkDown(x, y)
                    }
                    3 -> {
                        cnt += checkUp(x, y) + checkRight(x, y)
                    }
                    4 -> {
                        cnt += checkUp(x, y) + checkLeft(x, y) + checkRight(x, y)
                    }
                    5 -> {
                        cnt += checkUp(x, y) + checkLeft(x, y) + checkRight(x, y) + checkDown(x, y)
                    }
                }
            }
            1 -> {
                when (board[x][y]) {
                    1 -> {
                        cnt += checkRight(x, y)
                    }
                    2 -> {
                        cnt += checkRight(x, y) + checkLeft(x, y)
                    }
                    3 -> {
                        cnt += checkDown(x, y) + checkRight(x, y)
                    }
                    4 -> {
                        cnt += checkUp(x, y) + checkDown(x, y) + checkRight(x, y)
                    }
                    5 -> {}
                }
            }
            2 -> {
                when (board[x][y]) {
                    1 -> {
                        cnt += checkDown(x, y)
                    }
                    2 -> {}
                    3 -> {
                        cnt += checkDown(x, y) + checkLeft(x, y)
                    }
                    4 -> {
                        cnt += checkLeft(x, y) + checkDown(x, y) + checkRight(x, y)
                    }
                    5 -> {}
                }
            }
            3 -> {
                when (board[x][y]) {
                    1 -> {
                        cnt += checkLeft(x, y)
                    }
                    2 -> {}
                    3 -> {
                        cnt += checkUp(x, y) + checkLeft(x, y)
                    }
                    4 -> {
                        cnt += checkLeft(x, y) + checkDown(x, y) + checkUp(x, y)
                    }
                    5 -> {}
                }
            }
        }

        return cnt
    }

    fun checkUp(x: Int, y: Int): Int {
        var cnt = 0
        var cx = x
        while (cx >= 0 && board[cx][y] != 6) {
            if (board[cx][y] == 0) {
                cnt++
                board[cx][y] = -1
                stack.add(Pair(cx, y))
            }
            cx--
        }
        return cnt
    }

    fun checkDown(x: Int, y: Int): Int {
        var cnt = 0
        var cx = x
        while (cx < board.size && board[cx][y] != 6) {
            if (board[cx][y] == 0) {
                cnt++
                board[cx][y] = -1
                stack.add(Pair(cx, y))
            }
            cx++
        }
        return cnt

    }

    fun checkLeft(x: Int, y: Int): Int {
        var cnt = 0
        var cy = y
        while (cy >= 0 && board[x][cy] != 6) {
            if (board[x][cy] == 0) {
                cnt++
                board[x][cy] = -1
                stack.add(Pair(x, cy))
            }
            cy--
        }
        return cnt
    }

    fun checkRight(x: Int, y: Int): Int {
        var cnt = 0
        var cy = y
        while (cy < board[0].size && board[x][cy] != 6) {
            if (board[x][cy] == 0) {
                cnt++
                board[x][cy] = -1
                stack.add(Pair(x, cy))
            }
            cy++
        }
        return cnt
    }
}

fun main() {
    val (a, b) = readLine()!!.split(' ')
    Solution().solution(Array(a.toInt()) { readLine()!!.split(' ').map { it.toInt() } })
}
