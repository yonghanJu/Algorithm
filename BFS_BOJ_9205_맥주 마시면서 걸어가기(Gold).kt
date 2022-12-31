// 2022-12-31
// https://www.acmicpc.net/problem/9205

class Solution {
    lateinit var array: List<List<Short>>

    fun solution(input: List<List<Short>>) {
        array = input

        println(if (bfs()) "happy" else "sad")
    }

    private fun bfs(): Boolean {

        val deque = ArrayDeque<Int>().apply { addFirst(0) }
        val isVisited = BooleanArray(array.size).apply { set(0, true) }

        while (deque.isNotEmpty()) {
            val last = deque.removeLast()
            if (last == array.lastIndex) return true

            for (i in isVisited.indices) {
                if (isVisited[i]) continue

                if (abs(array[last][0].minus(array[i][0]).toShort()) + abs(
                        array[last][1].minus(array[i][1]).toShort()
                    ) <= 1000
                ) {
                    deque.addFirst(i)
                    isVisited[i] = true
                }
            }
        }

        return false
    }

    private fun abs(short: Short): Short {
        return if (short < 0) (-1 * short).toShort() else short
    }
}

fun main() {
    repeat(readLine()!!.toInt()) {
        Solution().solution(List(readLine()!!.toInt() + 2) {
            readLine()!!.split(" ").map { it.toShort() }
        })
    }
}
