import kotlin.math.sqrt

// https://www.acmicpc.net/problem/2022
// 2023-09-25

fun main() {
    val (x, y, c) = readln().split(' ').map { it.toDouble() }

    var l = 0.0
    var r = minOf(x, y)
    var mid = (l + r) / 2

    while (l <= r) {
        mid = (l + r) / 2
        val height = getHeight(x, y, mid)
        if (height == c) {
            println("h = c")
            break
        }
        val e = kotlin.math.abs(height - c)
        if (e < 0.001) break
        if (height < c) {
            r = mid - e / 1000
        } else {
            l = mid + e / 1000
        }
    }
    println("%.3f".format(mid))
}

fun getHeight(x: Double, y: Double, w: Double): Double {
    val yh = sqrt(y * y - w * w)
    val xh = sqrt(x * x - w * w)
    val a = xh / ((yh / w) + (xh / w))
    return (yh / w) * a
}
