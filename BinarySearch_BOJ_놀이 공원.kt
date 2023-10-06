// https://www.acmicpc.net/problem/1561
// 2023-10-06

fun main() {
    val (N, m) = readln().split(' ').map { it.toInt() }
    val mList = readln().split(' ').map { it.toInt() }
    if (N <= m) {
        println(N)
        return
    }
    val n = N - m
    var r = 60000000000L
    var l = 0L
    var mid = 0L
    var time = Long.MAX_VALUE
    while (l <= r) {
        mid = (r + l) / 2

        if (count(mid, mList) >= n) {
            r = mid - 1
            if (time > mid) time = mid
        } else {
            l = mid + 1
        }
    }

    println(getMin(time, mList, n))
}

fun getMin(time: Long, mList: List<Int>, n: Int): Int {
    var x = n - count(time - 1, mList)
    for (i in mList.indices) {
        if (time % mList[i] == 0L) {
            x--
            if (x == 0L) return i + 1
        }
    }

    return -1
}

fun count(h: Long, mList: List<Int>): Long {
    var answer = 0L
    mList.forEach {
        answer += h / it.toLong()
    }
    return answer
}
