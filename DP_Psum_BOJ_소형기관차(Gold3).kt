// https://www.acmicpc.net/problem/2616
// 2023-05-07

fun main() {
    val trainCount = readln().toInt()
    val trainList = readln().split(' ').map { it.toInt() }
    val trainPSum = IntArray(trainCount) { trainList[0] }
    val maxCount = readln().toInt()

    val dp = List(3) { IntArray(trainCount) }
    for (i in 1..trainList.lastIndex) {
        trainPSum[i] = trainPSum[i - 1] + trainList[i]
    }

    for (i in 0..2) { // 기관차 순서
        for (j in (i * maxCount)..trainCount - maxCount) { // 승객 열차
            if (i == 0) {
                dp[i][j] = maxOf(trainPSum[j + maxCount - 1] - if (j != 0) trainPSum[j - 1] else 0, if(j != 0) dp[i][j-1] else 0)
            } else {
                dp[i][j] = maxOf(dp[i][j - 1], dp[i - 1][j - maxCount] + trainPSum[j + maxCount - 1] - trainPSum[j - 1])
            }
        }
    }

    println(dp[2][trainCount-maxCount])
}
