// https://www.acmicpc.net/problem/2110
// 2023-09-23

fun main() {
    val (n, c) = readln().split(' ').map { it.toInt() }
    val list = List(n) { readln().toInt() }.sorted()

    var start = 1
    var end = list.last() - list.first()
    var answer = 0
    var mid = 0
    while (start <= end) {
        mid = (start + end) / 2
        val count = count(mid, list)

        if (count < c) { // 길이를 더 줄여야함
            end = mid - 1
        } else { // 길이를 더 늘려도 됨
            start = mid + 1
            if (answer < mid) answer = mid
        }
    }
    println(answer)
}

fun count(distance: Int, list: List<Int>): Int {
    var count = 1
    var lastIndex = 0
    for (i in 1..list.lastIndex) {
        if (list[i] - list[lastIndex] >= distance) {
            lastIndex = i
            count++
        }
    }
    return count
}
