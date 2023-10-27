// https://www.acmicpc.net/problem/3109
// 2023-10-28

val rc = readln().split(' ').map { it.toInt() }
val r = rc[0]
val c = rc[1]
val table = List(r) { readln().toCharArray() }
val isVisited = List(r) { IntArray(c) }

fun main() {
    var answer = 0
    for (i in 0 until r) {
        isVisited[i][0] = 1
        if (dfs(i, 0)) {
            answer++
        } else {
            isVisited[i][0] = -1
        }
    }
    println(answer)
}

fun dfs(i: Int, j: Int): Boolean {
    if (j == c - 1) {
        return true
    }
    for (d in -1..1) {
        if (i + d in 0 until r && isVisited[i + d][j + 1] == 0 && table[i + d][j + 1] == '.') {
            isVisited[i + d][j + 1] = 1
            val result = dfs(i + d, j + 1)
            if (result) return true
            isVisited[i + d][j + 1] = -1
        }
    }

    return false
}
