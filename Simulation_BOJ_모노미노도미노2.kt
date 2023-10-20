// https://www.acmicpc.net/problem/20061
// 2023-10-15

val n = readln().toInt()
val input = List(n) { readln().split(' ').map { it.toInt() } }

fun main() {
    val greenBoard = mutableListOf<MutableList<Boolean>>()
    val blueBoard = mutableListOf<MutableList<Boolean>>()

    var score = 0

    input.forEach { (type, x, y) ->
        val greenTile = Pair(y, if (type == 1) 'n' else if (type == 2) 'r' else 'u')
        val blueTile = Pair(x, if (type == 1) 'n' else if (type == 2) 'u' else 'r')

        score += addTile(greenTile, greenBoard)
        score += addTile(blueTile, blueBoard)
    }

    println("$score\n${greenBoard.flatten().count { it } + blueBoard.flatten().count { it }}")
}

fun addTile(tile: Pair<Int, Char>, board: MutableList<MutableList<Boolean>>): Int {
    var h = board.lastIndex
    var score = 0
    // find
    while (h != -1 && !board[h][tile.first] && (tile.second != 'r' || !board[h][tile.first + 1])) {
        h--
    }

    // add
    if (h + 1 in board.indices) {
        board[h + 1][tile.first] = true
        if (tile.second == 'r') board[h + 1][tile.first + 1] = true
        if (tile.second == 'u') {
            if (h + 2 in board.indices) {
                board[h + 2][tile.first] = true
            } else {
                board.add((0..3).map { it == tile.first }.toMutableList())
            }
        }
    } else {
        board.add((0..3).map { (it == tile.first || (tile.second == 'r' && it == tile.first + 1)) }.toMutableList())
        if (tile.second == 'u') {
            board.add((0..3).map { it == tile.first }.toMutableList())
        }
    }

    // remove
    if(tile.second == 'u' && h + 2 <= 3 && board[h + 2].all { it }) {
        board.removeAt(h + 2)
        score++
    }
    if (h + 1 <= 3 && board[h + 1].all { it }) {
        board.removeAt(h + 1)
        score++
    }

    while (board.size > 4) board.removeAt(0)

    return score
}
