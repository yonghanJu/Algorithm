import java.lang.StringBuilder
import java.util.PriorityQueue

// https://www.acmicpc.net/problem/1933
// 2023-09-16

fun main() {
    val mutableList = mutableListOf<Info>()
    val input = List(readln().toInt()) { readln().split(' ').map { it.toInt() } }
    input.forEach {
        mutableList.add(Info(it[0], it[1]))
        mutableList.add(Info(it[2], -it[1]))
    }
    mutableList.sortWith(compareBy<Info> { it.index }.thenBy { -it.height })

    var maxHeight = 0
    var index = -1
    val pq = PriorityQueue<Info>(compareBy { -it.height })
    val map = mutableMapOf<Int, Int>() // <Height, Count>
    val sb = StringBuilder()
    for (i in mutableList.indices) {
        val it = mutableList[i]
        if (it.height > 0) { // 시작
            pq.add(it)
        } else { // 끝
            if (pq.peek().height == -it.height) {
                pq.poll()
            } else {
                map[-it.height] = map.getOrDefault(-it.height, 0) + 1
            }
        }

        while (pq.peek() != null && (map[pq.peek()?.height] ?: 0) > 0) {
            map[pq.peek().height] = map[pq.peek().height]!! - 1
            pq.poll()
        }


        if ((pq.peek()?.height ?: 0) != maxHeight) {
            maxHeight = pq.peek()?.height ?: 0
            sb.append(it.index)
            sb.append(' ')
            sb.append(maxOf(maxHeight, 0))
            sb.append(' ')
        }
    }

    println(sb)
}

data class Info(
    val index: Int,
    val height: Int,
)
