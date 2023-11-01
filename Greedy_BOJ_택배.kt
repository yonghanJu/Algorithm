// https://www.acmicpc.net/problem/8980
// 2023-11-01

fun main() {
    val (n, c) = readln().split(' ').map { it.toInt() }
    val m = readln().toInt()
    val boxes =
        List(m) { readln().split(' ').map { it.toInt() } }.sortedWith(compareBy<List<Int>> { it[1] }.thenBy { -it[0] })
    var answer = 0

    val caps = IntArray(n + 1)
    boxes.forEach { box ->
        var max = 0
        for(i in box[0] until box[1]) {
            max = maxOf(max, caps[i])
        }

        val overload = minOf(c - max, box[2])
        answer += overload
        for(i in box[0] until box[1]) {
            caps[i] += overload
        }
    }

    println(answer)
}
