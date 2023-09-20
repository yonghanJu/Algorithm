fun main() {
    val (n, b) = readln().split(' ').mapIndexed { idx, it -> if (idx == 0) it.toInt() else it.toLong() }
    val met = List(n.toInt()) { readln().trim().split(' ').map { it.toIntOrNull() ?: 0 } }

    metPow(met, b.toLong()).forEach { list ->
        println(list.map{ it % 1000 }.joinToString(" "))
    }
}

fun metPow(list: List<List<Int>>, p: Long): List<List<Int>> {
    return if (p == 1L) list
    else if (p % 2L != 0L) metMul(metPow(list, p - 1), list)
    else metPow(metMul(list, list), p / 2)
}

fun metMul(a: List<List<Int>>, b: List<List<Int>>): List<List<Int>> {
    val size = a.size
    val list = List(size) { MutableList(size) { 0 } }

    for (i in 0 until size) {
        for (k in 0 until size) {
            for (j in 0 until size) {
                list[i][k] += (a[i][j] * b[j][k]) % 1000
            }
            list[i][k] %= 1000
        }
    }

    return list
}
