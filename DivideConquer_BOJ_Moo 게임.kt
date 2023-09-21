// https://www.acmicpc.net/problem/5904
// 2023-09-21

val sList = mutableListOf<Int>().apply { add(3) }

fun main() {
    val n = readln().toInt()
    val (k, size) = getK(n)
    println(re(n, k, size))
}

fun re(n: Int, k: Int, size: Int): Char {
    return if (k == 0 && n == 1) 'm' else if (k == 0) 'o' else when (n) {
            in 0..sList[k - 1] -> re(n, k - 1, sList[k - 1])
            in size - sList[k - 1] + 1..size -> re(n - sList[k - 1] - (k + 3), k - 1, sList[k - 1])
            else -> if (n == sList[k - 1] + 1) 'm' else 'o'
        }
}

fun getK(n: Int): Pair<Int, Int> {
    var size = 3
    var k = 0
    while (n > size) sList.add(run { size += size + 3 + (++k); size})
    return Pair(k, size)
}
