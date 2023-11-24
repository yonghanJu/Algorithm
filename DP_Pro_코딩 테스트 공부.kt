class Solution {
    var maxA = 0
    var maxC = 0
    fun solution(alp: Int, cop: Int, problems: Array<IntArray>): Int {
        problems.forEach { (a, c) ->
            maxA = maxOf(maxA, a)
            maxC = maxOf(maxC, c)
        }
        val dp = List(maxA + 1) { IntArray(maxC + 1) { Int.MAX_VALUE } }
        val ma = minOf(alp, maxA)
        val mc = minOf(cop, maxC)
        dp[ma][mc] = 0

        for (a in ma..maxA) {
            for (c in mc..maxC) {
                for ((reqA, reqC, rewA, rewC, cost) in problems) {
                    if (a < maxA) dp[a + 1][c] = minOf(dp[a + 1][c], dp[a][c] + 1)
                    if (c < maxC) dp[a][c + 1] = minOf(dp[a][c + 1], dp[a][c] + 1)
                    if (a >= reqA && c >= reqC) {
                        dp[minOf(maxA, a + rewA)][minOf(maxC, c + rewC)] =
                            minOf(
                                dp[minOf(maxA, a + rewA)][minOf(maxC, c + rewC)],
                                dp[a][c] + cost,
                            )
                    }
                }
            }
        }

        return dp[maxA][maxC]
    }
}
