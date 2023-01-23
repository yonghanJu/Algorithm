// 2022-12-31
// https://www.acmicpc.net/problem/1866

var truckPrice = 0
var heliPrice = 0

fun solution(count: Int, list: List<Int>, prices: List<Int>) {
    truckPrice = prices[0]
    heliPrice = prices[1]

    val distanceDiff = List(count) { IntArray(count) }
    for (i in 0 until count) {
        for (j in 0 until count) {
            distanceDiff[i][j] = abs(list[i] - list[j])
        }
    }

    val pSum = List(count + 1) { IntArray(count + 1) }

    for (i in 1..count) {
        for (j in 1..count) {
            if (i < j) pSum[i][j] = pSum[i][j - 1] + distanceDiff[i - 1][j - 1]
        }
    }

    for (i in count downTo 1) {
        for (j in count downTo 1) {
            if (j < i) pSum[i][j] = pSum[i][j + 1] + distanceDiff[i - 1][j - 1]
        }
    }

    val dp = IntArray(list.size + 1) { Int.MAX_VALUE }

    for (i in 1..count) {
        for (j in 1..i) {
            val mid = (i + j) / 2
            dp[i] = minOf(
                minOf(dp[i], (if (dp[i - 1] == Int.MAX_VALUE) 0 else dp[i - 1]) + list[i - 1] * truckPrice),
                (if (dp[j - 1] == Int.MAX_VALUE) 0 else dp[j - 1]) + heliPrice + (pSum[mid][i] + pSum[mid][j]) * truckPrice
            )
        }
    }

    println(dp.last())
}

fun main() {
    solution(readLine()!!.toInt(),
        readLine()!!.split(' ').map { it.toInt() }.sorted(),
        readLine()!!.split(' ').map { it.toInt() })
}

fun abs(num: Int) = if (num > 0) num else -num
