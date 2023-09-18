import java.math.BigInteger

// https://www.acmicpc.net/problem/1891
// 2023-09-18

fun main() {
    val (n, d) = readln().split(' ')
    val (mx, my) = readln().split(' ').map { BigInteger(it) }

    val zero = BigInteger("0")
    var size = BigInteger("1") // 주의! Double.pow()를 사용해서 계산했더니 오차 때문에 오답이 나옴
    val two = BigInteger("2")
    repeat(n.toInt()) {
        size *= two
    }

    val (x, y) = findXY(d, zero, zero, size)
    if ((x >= zero && x < size && y >= zero && y < size).not()) println(-1).let { return }
    val nx = x + mx
    val ny = y + my
    println(if (nx >= zero && nx < size && ny >= zero && ny < size) findD("", nx, ny, size) else "-1")
}

fun findXY(d: String, x: BigInteger, y: BigInteger, size: BigInteger): Pair<BigInteger, BigInteger> {
    if (size == BigInteger("1")) return Pair(x, y)

    val nd = d.drop(1)
    val halfSize = size.divide(BigInteger("2"))
    val p = when (d[0]) {
        '1' -> findXY(nd, x + halfSize, y + halfSize, halfSize)
        '2' -> findXY(nd, x, y + halfSize, halfSize)
        '3' -> findXY(nd, x, y, halfSize)
        else -> findXY(nd, x + halfSize, y, halfSize)
    }

    return p
}

fun findD(d: String, x: BigInteger, y: BigInteger, size: BigInteger): String {
    if (size == BigInteger("1")) return d

    val halfSize = size.divide(BigInteger("2"))
    var append = ""
    val nd = if (x >= halfSize && y >= halfSize) {
        append = "1"
        findD(d, x.mod(halfSize), y.mod(halfSize), halfSize)
    } else if (x < halfSize && y >= halfSize) {
        append = "2"
        findD(d, x, y.mod(halfSize), halfSize)
    } else if (x < halfSize && y < halfSize) {
        append = "3"
        findD(d, x, y, halfSize)
    } else {
        append = "4"
        findD(d, x.mod(halfSize), y, halfSize)
    }
    return append + nd
}
