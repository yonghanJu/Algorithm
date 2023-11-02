// https://www.acmicpc.net/problem/8980
// 2023-11-01

fun main() {
    val (n, l) = readln().split(' ').map { it.toInt() }
    val pools = List(n) { readln().split(' ').map { it.toInt() } }.sortedBy { it[0] }

    var lastIndex = 0
    var answer = 0

    pools.forEach { (start, end) ->
        if (end >= lastIndex) {
            val max = maxOf(lastIndex, start)
            val add = (end - max) / l + if ((end - max) % l == 0) 0 else 1
            answer += add
            lastIndex = max + add * l
        }
    }
    println(answer)
}
