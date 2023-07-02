// https://www.acmicpc.net/problem/1029
// 2023-07-02

fun main() {
    val s = Solution()
    println(s.solution(List(readln().toInt()) { readln().toCharArray().map { it.code - '0'.code } }))
}

class Solution {
    private var answer = 1
    fun solution(priceTable: List<List<Int>>): Int {
        val dp = List(priceTable.size + 1) { mutableMapOf<List<Boolean>, List<Int>>() }
        val initKey = List(priceTable.size) { it == 0 }
        dp[0][initKey] = List(priceTable.size) { if (it == 0) 0 else -1 }
        // dp[몇번째][상태][거래자] = 가격

        for (depth in 1 until priceTable.size) {
            val prevMap = dp[depth - 1]
            prevMap.forEach { (state, prices) ->
                prices.forEachIndexed { from, price ->
                    if (price >= 0) {
                        for (to in state.indices) {
                            if (state[to].not()) { // 소유 x
                                val newState = state.toMutableList().apply { set(to, true) }
                                if (price <= priceTable[from][to]) {
                                    answer = depth + 1
                                    val newList = (dp[depth][newState] ?: List(prices.size) { -1 }).toMutableList()
                                        .apply {
                                            set(to, if(get(to) == -1) priceTable[from][to] else minOf(priceTable[from][to], get(to)))
                                        }
                                    dp[depth][newState] = newList
                                }
                            }
                        }
                    }
                }
            }
        }

        return answer
    }
}
