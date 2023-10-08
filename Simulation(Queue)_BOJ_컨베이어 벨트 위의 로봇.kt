// https://www.acmicpc.net/problem/20055
// 2023-10-08

val nk = readln().split(' ').map { it.toInt() }
val input = readln().split(' ').map { it.toInt() }.toMutableList()

fun main() {
    var step = 0
    var count = 0

    val robotQueue = ArrayDeque<Int>()
    var start = 0
    var end = nk[0] - 1

    while (count < nk[1]) {
        step++
        // 1
        start = (start + nk[0] * 2 - 1) % (nk[0] * 2)
        end = (end + nk[0] * 2 - 1) % (nk[0] * 2)
        if (robotQueue.lastOrNull() == end) robotQueue.removeLast()

        // 2 이동
        for (i in robotQueue.size - 1 downTo 0) {
            val nextSeatIndex = (robotQueue[i] + 1) % (nk[0] * 2)
            if (input[nextSeatIndex] > 0) { // 내구도
                if (i == robotQueue.size - 1 || nextSeatIndex != robotQueue[i + 1]) { // 로봇 없다면
                    robotQueue[i] = nextSeatIndex
                    input[nextSeatIndex]--
                    if (input[nextSeatIndex] == 0) count++
                }
            }
        }
        if (robotQueue.lastOrNull() == end) robotQueue.removeLast()

        // 3
        if (input[start] > 0) {
            robotQueue.addFirst(start)
            input[start]--
            if (input[start] == 0) count++
        }
    }

    println(step)
}
